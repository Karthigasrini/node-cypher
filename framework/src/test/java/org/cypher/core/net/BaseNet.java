package org.cypher.core.net;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultMessageSizeEstimator;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.io.File;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.cypher.common.application.Application;
import org.cypher.common.application.ApplicationFactory;
import org.cypher.common.application.CypherApplicationContext;
import org.cypher.common.parameter.CommonParameter;
import org.cypher.common.utils.FileUtil;
import org.cypher.common.utils.ReflectUtils;
import org.cypher.core.Constant;
import org.cypher.core.config.DefaultConfig;
import org.cypher.core.config.args.Args;
import org.cypher.core.net.peer.PeerConnection;
import org.cypher.core.services.RpcApiService;

@Slf4j
public abstract class BaseNet {

  private static String dbPath = "output-net";
  private static String dbDirectory = "net-database";
  private static String indexDirectory = "net-index";
  private static int port = 10000;

  protected CypherApplicationContext context;

  private RpcApiService rpcApiService;
  private Application appT;
  private CypherNetDelegate cypherNetDelegate;

  private ExecutorService executorService = Executors.newFixedThreadPool(1);

  public static Channel connect(ByteToMessageDecoder decoder) throws InterruptedException {
    NioEventLoopGroup group = new NioEventLoopGroup(1);
    Bootstrap b = new Bootstrap();
    b.group(group).channel(NioSocketChannel.class)
        .handler(new ChannelInitializer<Channel>() {
          @Override
          protected void initChannel(Channel ch) throws Exception {
            ch.config().setRecvByteBufAllocator(new FixedRecvByteBufAllocator(256 * 1024));
            ch.config().setOption(ChannelOption.SO_RCVBUF, 256 * 1024);
            ch.config().setOption(ChannelOption.SO_BACKLOG, 1024);
            ch.pipeline()
                .addLast("readTimeoutHandler", new ReadTimeoutHandler(600, TimeUnit.SECONDS))
                .addLast("writeTimeoutHandler", new WriteTimeoutHandler(600, TimeUnit.SECONDS));
            ch.pipeline().addLast("protoPender", new ProtobufVarint32LengthFieldPrepender());
            ch.pipeline().addLast("lengthDecode", new ProtobufVarint32FrameDecoder());
            ch.pipeline().addLast("handshakeHandler", decoder);
            ch.closeFuture();
          }
        }).option(ChannelOption.SO_KEEPALIVE, true)
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 60000)
        .option(ChannelOption.MESSAGE_SIZE_ESTIMATOR, DefaultMessageSizeEstimator.DEFAULT);
    return b.connect(Constant.LOCAL_HOST, port).sync().channel();
  }

  @Before
  public void init() throws Exception {
    executorService.execute(new Runnable() {
      @Override
      public void run() {
        logger.info("Full node running.");
        Args.setParam(
            new String[]{
                "--output-directory", dbPath,
                "--storage-db-directory", dbDirectory,
                "--storage-index-directory", indexDirectory
            },
            "config.conf"
        );
        CommonParameter parameter = Args.getInstance();
        parameter.setNodeListenPort(port);
        parameter.getSeedNode().getIpList().clear();
        parameter.setNodeExternalIp(Constant.LOCAL_HOST);
        context = new CypherApplicationContext(DefaultConfig.class);
        appT = ApplicationFactory.create(context);
        rpcApiService = context.getBean(RpcApiService.class);
        appT.addService(rpcApiService);
        appT.initServices(parameter);
        appT.startServices();
        appT.startup();
        cypherNetDelegate = context.getBean(CypherNetDelegate.class);
        rpcApiService.blockUntilShutdown();
      }
    });
    int tryTimes = 0;
    while (++tryTimes < 100 && cypherNetDelegate == null) {
      Thread.sleep(3000);
    }
  }

  @After
  public void destroy() {
    Collection<PeerConnection> peerConnections = ReflectUtils
        .invokeMethod(cypherNetDelegate, "getActivePeer");
    for (PeerConnection peer : peerConnections) {
      peer.close();
    }

    context.destroy();
    FileUtil.deleteDir(new File(dbPath));
  }
}
