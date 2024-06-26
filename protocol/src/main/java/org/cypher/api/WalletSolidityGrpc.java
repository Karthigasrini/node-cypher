package org.cypher.api;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.0)",
    comments = "Source: api/api.proto")
public final class WalletSolidityGrpc {

  private WalletSolidityGrpc() {}

  public static final String SERVICE_NAME = "protocol.WalletSolidity";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAccountMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.protos.Protocol.Account,
      org.cypher.protos.Protocol.Account> METHOD_GET_ACCOUNT = getGetAccountMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.protos.Protocol.Account,
      org.cypher.protos.Protocol.Account> getGetAccountMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.protos.Protocol.Account,
      org.cypher.protos.Protocol.Account> getGetAccountMethod() {
    io.grpc.MethodDescriptor<org.cypher.protos.Protocol.Account, org.cypher.protos.Protocol.Account> getGetAccountMethod;
    if ((getGetAccountMethod = WalletSolidityGrpc.getGetAccountMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetAccountMethod = WalletSolidityGrpc.getGetAccountMethod) == null) {
          WalletSolidityGrpc.getGetAccountMethod = getGetAccountMethod = 
              io.grpc.MethodDescriptor.<org.cypher.protos.Protocol.Account, org.cypher.protos.Protocol.Account>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.Account.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.Account.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetAccount"))
                  .build();
          }
        }
     }
     return getGetAccountMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAccountByIdMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.protos.Protocol.Account,
      org.cypher.protos.Protocol.Account> METHOD_GET_ACCOUNT_BY_ID = getGetAccountByIdMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.protos.Protocol.Account,
      org.cypher.protos.Protocol.Account> getGetAccountByIdMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.protos.Protocol.Account,
      org.cypher.protos.Protocol.Account> getGetAccountByIdMethod() {
    io.grpc.MethodDescriptor<org.cypher.protos.Protocol.Account, org.cypher.protos.Protocol.Account> getGetAccountByIdMethod;
    if ((getGetAccountByIdMethod = WalletSolidityGrpc.getGetAccountByIdMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetAccountByIdMethod = WalletSolidityGrpc.getGetAccountByIdMethod) == null) {
          WalletSolidityGrpc.getGetAccountByIdMethod = getGetAccountByIdMethod = 
              io.grpc.MethodDescriptor.<org.cypher.protos.Protocol.Account, org.cypher.protos.Protocol.Account>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetAccountById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.Account.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.Account.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetAccountById"))
                  .build();
          }
        }
     }
     return getGetAccountByIdMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListWitnessesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.WitnessList> METHOD_LIST_WITNESSES = getListWitnessesMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.WitnessList> getListWitnessesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.WitnessList> getListWitnessesMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.api.GrpcAPI.WitnessList> getListWitnessesMethod;
    if ((getListWitnessesMethod = WalletSolidityGrpc.getListWitnessesMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getListWitnessesMethod = WalletSolidityGrpc.getListWitnessesMethod) == null) {
          WalletSolidityGrpc.getListWitnessesMethod = getListWitnessesMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.api.GrpcAPI.WitnessList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "ListWitnesses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.EmptyMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.WitnessList.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("ListWitnesses"))
                  .build();
          }
        }
     }
     return getListWitnessesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAssetIssueListMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.AssetIssueList> METHOD_GET_ASSET_ISSUE_LIST = getGetAssetIssueListMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.AssetIssueList> getGetAssetIssueListMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.AssetIssueList> getGetAssetIssueListMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.api.GrpcAPI.AssetIssueList> getGetAssetIssueListMethod;
    if ((getGetAssetIssueListMethod = WalletSolidityGrpc.getGetAssetIssueListMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetAssetIssueListMethod = WalletSolidityGrpc.getGetAssetIssueListMethod) == null) {
          WalletSolidityGrpc.getGetAssetIssueListMethod = getGetAssetIssueListMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.api.GrpcAPI.AssetIssueList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetAssetIssueList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.EmptyMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.AssetIssueList.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetAssetIssueList"))
                  .build();
          }
        }
     }
     return getGetAssetIssueListMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetPaginatedAssetIssueListMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.PaginatedMessage,
      org.cypher.api.GrpcAPI.AssetIssueList> METHOD_GET_PAGINATED_ASSET_ISSUE_LIST = getGetPaginatedAssetIssueListMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.PaginatedMessage,
      org.cypher.api.GrpcAPI.AssetIssueList> getGetPaginatedAssetIssueListMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.PaginatedMessage,
      org.cypher.api.GrpcAPI.AssetIssueList> getGetPaginatedAssetIssueListMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.PaginatedMessage, org.cypher.api.GrpcAPI.AssetIssueList> getGetPaginatedAssetIssueListMethod;
    if ((getGetPaginatedAssetIssueListMethod = WalletSolidityGrpc.getGetPaginatedAssetIssueListMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetPaginatedAssetIssueListMethod = WalletSolidityGrpc.getGetPaginatedAssetIssueListMethod) == null) {
          WalletSolidityGrpc.getGetPaginatedAssetIssueListMethod = getGetPaginatedAssetIssueListMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.PaginatedMessage, org.cypher.api.GrpcAPI.AssetIssueList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetPaginatedAssetIssueList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.PaginatedMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.AssetIssueList.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetPaginatedAssetIssueList"))
                  .build();
          }
        }
     }
     return getGetPaginatedAssetIssueListMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAssetIssueByNameMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> METHOD_GET_ASSET_ISSUE_BY_NAME = getGetAssetIssueByNameMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> getGetAssetIssueByNameMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> getGetAssetIssueByNameMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> getGetAssetIssueByNameMethod;
    if ((getGetAssetIssueByNameMethod = WalletSolidityGrpc.getGetAssetIssueByNameMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetAssetIssueByNameMethod = WalletSolidityGrpc.getGetAssetIssueByNameMethod) == null) {
          WalletSolidityGrpc.getGetAssetIssueByNameMethod = getGetAssetIssueByNameMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetAssetIssueByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.BytesMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetAssetIssueByName"))
                  .build();
          }
        }
     }
     return getGetAssetIssueByNameMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAssetIssueListByNameMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.api.GrpcAPI.AssetIssueList> METHOD_GET_ASSET_ISSUE_LIST_BY_NAME = getGetAssetIssueListByNameMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.api.GrpcAPI.AssetIssueList> getGetAssetIssueListByNameMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.api.GrpcAPI.AssetIssueList> getGetAssetIssueListByNameMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.api.GrpcAPI.AssetIssueList> getGetAssetIssueListByNameMethod;
    if ((getGetAssetIssueListByNameMethod = WalletSolidityGrpc.getGetAssetIssueListByNameMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetAssetIssueListByNameMethod = WalletSolidityGrpc.getGetAssetIssueListByNameMethod) == null) {
          WalletSolidityGrpc.getGetAssetIssueListByNameMethod = getGetAssetIssueListByNameMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.api.GrpcAPI.AssetIssueList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetAssetIssueListByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.BytesMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.AssetIssueList.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetAssetIssueListByName"))
                  .build();
          }
        }
     }
     return getGetAssetIssueListByNameMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAssetIssueByIdMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> METHOD_GET_ASSET_ISSUE_BY_ID = getGetAssetIssueByIdMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> getGetAssetIssueByIdMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> getGetAssetIssueByIdMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> getGetAssetIssueByIdMethod;
    if ((getGetAssetIssueByIdMethod = WalletSolidityGrpc.getGetAssetIssueByIdMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetAssetIssueByIdMethod = WalletSolidityGrpc.getGetAssetIssueByIdMethod) == null) {
          WalletSolidityGrpc.getGetAssetIssueByIdMethod = getGetAssetIssueByIdMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetAssetIssueById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.BytesMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetAssetIssueById"))
                  .build();
          }
        }
     }
     return getGetAssetIssueByIdMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetNowBlockMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.protos.Protocol.Block> METHOD_GET_NOW_BLOCK = getGetNowBlockMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.protos.Protocol.Block> getGetNowBlockMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.protos.Protocol.Block> getGetNowBlockMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.protos.Protocol.Block> getGetNowBlockMethod;
    if ((getGetNowBlockMethod = WalletSolidityGrpc.getGetNowBlockMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetNowBlockMethod = WalletSolidityGrpc.getGetNowBlockMethod) == null) {
          WalletSolidityGrpc.getGetNowBlockMethod = getGetNowBlockMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.protos.Protocol.Block>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetNowBlock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.EmptyMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.Block.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetNowBlock"))
                  .build();
          }
        }
     }
     return getGetNowBlockMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetNowBlock2Method()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.BlockExtention> METHOD_GET_NOW_BLOCK2 = getGetNowBlock2Method();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.BlockExtention> getGetNowBlock2Method;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.BlockExtention> getGetNowBlock2Method() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.api.GrpcAPI.BlockExtention> getGetNowBlock2Method;
    if ((getGetNowBlock2Method = WalletSolidityGrpc.getGetNowBlock2Method) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetNowBlock2Method = WalletSolidityGrpc.getGetNowBlock2Method) == null) {
          WalletSolidityGrpc.getGetNowBlock2Method = getGetNowBlock2Method = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.api.GrpcAPI.BlockExtention>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetNowBlock2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.EmptyMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.BlockExtention.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetNowBlock2"))
                  .build();
          }
        }
     }
     return getGetNowBlock2Method;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetBlockByNumMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage,
      org.cypher.protos.Protocol.Block> METHOD_GET_BLOCK_BY_NUM = getGetBlockByNumMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage,
      org.cypher.protos.Protocol.Block> getGetBlockByNumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage,
      org.cypher.protos.Protocol.Block> getGetBlockByNumMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage, org.cypher.protos.Protocol.Block> getGetBlockByNumMethod;
    if ((getGetBlockByNumMethod = WalletSolidityGrpc.getGetBlockByNumMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetBlockByNumMethod = WalletSolidityGrpc.getGetBlockByNumMethod) == null) {
          WalletSolidityGrpc.getGetBlockByNumMethod = getGetBlockByNumMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.NumberMessage, org.cypher.protos.Protocol.Block>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetBlockByNum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.NumberMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.Block.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetBlockByNum"))
                  .build();
          }
        }
     }
     return getGetBlockByNumMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetBlockByNum2Method()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage,
      org.cypher.api.GrpcAPI.BlockExtention> METHOD_GET_BLOCK_BY_NUM2 = getGetBlockByNum2Method();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage,
      org.cypher.api.GrpcAPI.BlockExtention> getGetBlockByNum2Method;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage,
      org.cypher.api.GrpcAPI.BlockExtention> getGetBlockByNum2Method() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage, org.cypher.api.GrpcAPI.BlockExtention> getGetBlockByNum2Method;
    if ((getGetBlockByNum2Method = WalletSolidityGrpc.getGetBlockByNum2Method) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetBlockByNum2Method = WalletSolidityGrpc.getGetBlockByNum2Method) == null) {
          WalletSolidityGrpc.getGetBlockByNum2Method = getGetBlockByNum2Method = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.NumberMessage, org.cypher.api.GrpcAPI.BlockExtention>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetBlockByNum2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.NumberMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.BlockExtention.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetBlockByNum2"))
                  .build();
          }
        }
     }
     return getGetBlockByNum2Method;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTransactionCountByBlockNumMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage,
      org.cypher.api.GrpcAPI.NumberMessage> METHOD_GET_TRANSACTION_COUNT_BY_BLOCK_NUM = getGetTransactionCountByBlockNumMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage,
      org.cypher.api.GrpcAPI.NumberMessage> getGetTransactionCountByBlockNumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage,
      org.cypher.api.GrpcAPI.NumberMessage> getGetTransactionCountByBlockNumMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage, org.cypher.api.GrpcAPI.NumberMessage> getGetTransactionCountByBlockNumMethod;
    if ((getGetTransactionCountByBlockNumMethod = WalletSolidityGrpc.getGetTransactionCountByBlockNumMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetTransactionCountByBlockNumMethod = WalletSolidityGrpc.getGetTransactionCountByBlockNumMethod) == null) {
          WalletSolidityGrpc.getGetTransactionCountByBlockNumMethod = getGetTransactionCountByBlockNumMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.NumberMessage, org.cypher.api.GrpcAPI.NumberMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetTransactionCountByBlockNum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.NumberMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.NumberMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetTransactionCountByBlockNum"))
                  .build();
          }
        }
     }
     return getGetTransactionCountByBlockNumMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetDelegatedResourceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.DelegatedResourceMessage,
      org.cypher.api.GrpcAPI.DelegatedResourceList> METHOD_GET_DELEGATED_RESOURCE = getGetDelegatedResourceMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.DelegatedResourceMessage,
      org.cypher.api.GrpcAPI.DelegatedResourceList> getGetDelegatedResourceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.DelegatedResourceMessage,
      org.cypher.api.GrpcAPI.DelegatedResourceList> getGetDelegatedResourceMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.DelegatedResourceMessage, org.cypher.api.GrpcAPI.DelegatedResourceList> getGetDelegatedResourceMethod;
    if ((getGetDelegatedResourceMethod = WalletSolidityGrpc.getGetDelegatedResourceMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetDelegatedResourceMethod = WalletSolidityGrpc.getGetDelegatedResourceMethod) == null) {
          WalletSolidityGrpc.getGetDelegatedResourceMethod = getGetDelegatedResourceMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.DelegatedResourceMessage, org.cypher.api.GrpcAPI.DelegatedResourceList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetDelegatedResource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.DelegatedResourceMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.DelegatedResourceList.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetDelegatedResource"))
                  .build();
          }
        }
     }
     return getGetDelegatedResourceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetDelegatedResourceAccountIndexMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.DelegatedResourceAccountIndex> METHOD_GET_DELEGATED_RESOURCE_ACCOUNT_INDEX = getGetDelegatedResourceAccountIndexMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.DelegatedResourceAccountIndex> getGetDelegatedResourceAccountIndexMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.DelegatedResourceAccountIndex> getGetDelegatedResourceAccountIndexMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.Protocol.DelegatedResourceAccountIndex> getGetDelegatedResourceAccountIndexMethod;
    if ((getGetDelegatedResourceAccountIndexMethod = WalletSolidityGrpc.getGetDelegatedResourceAccountIndexMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetDelegatedResourceAccountIndexMethod = WalletSolidityGrpc.getGetDelegatedResourceAccountIndexMethod) == null) {
          WalletSolidityGrpc.getGetDelegatedResourceAccountIndexMethod = getGetDelegatedResourceAccountIndexMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.Protocol.DelegatedResourceAccountIndex>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetDelegatedResourceAccountIndex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.BytesMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.DelegatedResourceAccountIndex.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetDelegatedResourceAccountIndex"))
                  .build();
          }
        }
     }
     return getGetDelegatedResourceAccountIndexMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetExchangeByIdMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.Exchange> METHOD_GET_EXCHANGE_BY_ID = getGetExchangeByIdMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.Exchange> getGetExchangeByIdMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.Exchange> getGetExchangeByIdMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.Protocol.Exchange> getGetExchangeByIdMethod;
    if ((getGetExchangeByIdMethod = WalletSolidityGrpc.getGetExchangeByIdMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetExchangeByIdMethod = WalletSolidityGrpc.getGetExchangeByIdMethod) == null) {
          WalletSolidityGrpc.getGetExchangeByIdMethod = getGetExchangeByIdMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.Protocol.Exchange>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetExchangeById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.BytesMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.Exchange.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetExchangeById"))
                  .build();
          }
        }
     }
     return getGetExchangeByIdMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListExchangesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.ExchangeList> METHOD_LIST_EXCHANGES = getListExchangesMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.ExchangeList> getListExchangesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.ExchangeList> getListExchangesMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.api.GrpcAPI.ExchangeList> getListExchangesMethod;
    if ((getListExchangesMethod = WalletSolidityGrpc.getListExchangesMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getListExchangesMethod = WalletSolidityGrpc.getListExchangesMethod) == null) {
          WalletSolidityGrpc.getListExchangesMethod = getListExchangesMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.api.GrpcAPI.ExchangeList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "ListExchanges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.EmptyMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.ExchangeList.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("ListExchanges"))
                  .build();
          }
        }
     }
     return getListExchangesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTransactionByIdMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.Transaction> METHOD_GET_TRANSACTION_BY_ID = getGetTransactionByIdMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.Transaction> getGetTransactionByIdMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.Transaction> getGetTransactionByIdMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.Protocol.Transaction> getGetTransactionByIdMethod;
    if ((getGetTransactionByIdMethod = WalletSolidityGrpc.getGetTransactionByIdMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetTransactionByIdMethod = WalletSolidityGrpc.getGetTransactionByIdMethod) == null) {
          WalletSolidityGrpc.getGetTransactionByIdMethod = getGetTransactionByIdMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.Protocol.Transaction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetTransactionById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.BytesMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.Transaction.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetTransactionById"))
                  .build();
          }
        }
     }
     return getGetTransactionByIdMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTransactionInfoByIdMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.TransactionInfo> METHOD_GET_TRANSACTION_INFO_BY_ID = getGetTransactionInfoByIdMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.TransactionInfo> getGetTransactionInfoByIdMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.TransactionInfo> getGetTransactionInfoByIdMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.Protocol.TransactionInfo> getGetTransactionInfoByIdMethod;
    if ((getGetTransactionInfoByIdMethod = WalletSolidityGrpc.getGetTransactionInfoByIdMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetTransactionInfoByIdMethod = WalletSolidityGrpc.getGetTransactionInfoByIdMethod) == null) {
          WalletSolidityGrpc.getGetTransactionInfoByIdMethod = getGetTransactionInfoByIdMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.Protocol.TransactionInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetTransactionInfoById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.BytesMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.TransactionInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetTransactionInfoById"))
                  .build();
          }
        }
     }
     return getGetTransactionInfoByIdMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGenerateAddressMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.AddressPrKeyPairMessage> METHOD_GENERATE_ADDRESS = getGenerateAddressMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.AddressPrKeyPairMessage> getGenerateAddressMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.AddressPrKeyPairMessage> getGenerateAddressMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.api.GrpcAPI.AddressPrKeyPairMessage> getGenerateAddressMethod;
    if ((getGenerateAddressMethod = WalletSolidityGrpc.getGenerateAddressMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGenerateAddressMethod = WalletSolidityGrpc.getGenerateAddressMethod) == null) {
          WalletSolidityGrpc.getGenerateAddressMethod = getGenerateAddressMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.api.GrpcAPI.AddressPrKeyPairMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GenerateAddress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.EmptyMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.AddressPrKeyPairMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GenerateAddress"))
                  .build();
          }
        }
     }
     return getGenerateAddressMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMerkleTreeVoucherInfoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.protos.contract.ShieldContract.OutputPointInfo,
      org.cypher.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo> METHOD_GET_MERKLE_TREE_VOUCHER_INFO = getGetMerkleTreeVoucherInfoMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.protos.contract.ShieldContract.OutputPointInfo,
      org.cypher.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo> getGetMerkleTreeVoucherInfoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.protos.contract.ShieldContract.OutputPointInfo,
      org.cypher.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo> getGetMerkleTreeVoucherInfoMethod() {
    io.grpc.MethodDescriptor<org.cypher.protos.contract.ShieldContract.OutputPointInfo, org.cypher.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo> getGetMerkleTreeVoucherInfoMethod;
    if ((getGetMerkleTreeVoucherInfoMethod = WalletSolidityGrpc.getGetMerkleTreeVoucherInfoMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetMerkleTreeVoucherInfoMethod = WalletSolidityGrpc.getGetMerkleTreeVoucherInfoMethod) == null) {
          WalletSolidityGrpc.getGetMerkleTreeVoucherInfoMethod = getGetMerkleTreeVoucherInfoMethod = 
              io.grpc.MethodDescriptor.<org.cypher.protos.contract.ShieldContract.OutputPointInfo, org.cypher.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetMerkleTreeVoucherInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.contract.ShieldContract.OutputPointInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetMerkleTreeVoucherInfo"))
                  .build();
          }
        }
     }
     return getGetMerkleTreeVoucherInfoMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getScanNoteByIvkMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.IvkDecryptParameters,
      org.cypher.api.GrpcAPI.DecryptNotes> METHOD_SCAN_NOTE_BY_IVK = getScanNoteByIvkMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.IvkDecryptParameters,
      org.cypher.api.GrpcAPI.DecryptNotes> getScanNoteByIvkMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.IvkDecryptParameters,
      org.cypher.api.GrpcAPI.DecryptNotes> getScanNoteByIvkMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.IvkDecryptParameters, org.cypher.api.GrpcAPI.DecryptNotes> getScanNoteByIvkMethod;
    if ((getScanNoteByIvkMethod = WalletSolidityGrpc.getScanNoteByIvkMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getScanNoteByIvkMethod = WalletSolidityGrpc.getScanNoteByIvkMethod) == null) {
          WalletSolidityGrpc.getScanNoteByIvkMethod = getScanNoteByIvkMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.IvkDecryptParameters, org.cypher.api.GrpcAPI.DecryptNotes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "ScanNoteByIvk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.IvkDecryptParameters.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.DecryptNotes.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("ScanNoteByIvk"))
                  .build();
          }
        }
     }
     return getScanNoteByIvkMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getScanAndMarkNoteByIvkMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.IvkDecryptAndMarkParameters,
      org.cypher.api.GrpcAPI.DecryptNotesMarked> METHOD_SCAN_AND_MARK_NOTE_BY_IVK = getScanAndMarkNoteByIvkMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.IvkDecryptAndMarkParameters,
      org.cypher.api.GrpcAPI.DecryptNotesMarked> getScanAndMarkNoteByIvkMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.IvkDecryptAndMarkParameters,
      org.cypher.api.GrpcAPI.DecryptNotesMarked> getScanAndMarkNoteByIvkMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.IvkDecryptAndMarkParameters, org.cypher.api.GrpcAPI.DecryptNotesMarked> getScanAndMarkNoteByIvkMethod;
    if ((getScanAndMarkNoteByIvkMethod = WalletSolidityGrpc.getScanAndMarkNoteByIvkMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getScanAndMarkNoteByIvkMethod = WalletSolidityGrpc.getScanAndMarkNoteByIvkMethod) == null) {
          WalletSolidityGrpc.getScanAndMarkNoteByIvkMethod = getScanAndMarkNoteByIvkMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.IvkDecryptAndMarkParameters, org.cypher.api.GrpcAPI.DecryptNotesMarked>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "ScanAndMarkNoteByIvk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.IvkDecryptAndMarkParameters.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.DecryptNotesMarked.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("ScanAndMarkNoteByIvk"))
                  .build();
          }
        }
     }
     return getScanAndMarkNoteByIvkMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getScanNoteByOvkMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.OvkDecryptParameters,
      org.cypher.api.GrpcAPI.DecryptNotes> METHOD_SCAN_NOTE_BY_OVK = getScanNoteByOvkMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.OvkDecryptParameters,
      org.cypher.api.GrpcAPI.DecryptNotes> getScanNoteByOvkMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.OvkDecryptParameters,
      org.cypher.api.GrpcAPI.DecryptNotes> getScanNoteByOvkMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.OvkDecryptParameters, org.cypher.api.GrpcAPI.DecryptNotes> getScanNoteByOvkMethod;
    if ((getScanNoteByOvkMethod = WalletSolidityGrpc.getScanNoteByOvkMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getScanNoteByOvkMethod = WalletSolidityGrpc.getScanNoteByOvkMethod) == null) {
          WalletSolidityGrpc.getScanNoteByOvkMethod = getScanNoteByOvkMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.OvkDecryptParameters, org.cypher.api.GrpcAPI.DecryptNotes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "ScanNoteByOvk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.OvkDecryptParameters.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.DecryptNotes.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("ScanNoteByOvk"))
                  .build();
          }
        }
     }
     return getScanNoteByOvkMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getIsSpendMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NoteParameters,
      org.cypher.api.GrpcAPI.SpendResult> METHOD_IS_SPEND = getIsSpendMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NoteParameters,
      org.cypher.api.GrpcAPI.SpendResult> getIsSpendMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NoteParameters,
      org.cypher.api.GrpcAPI.SpendResult> getIsSpendMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NoteParameters, org.cypher.api.GrpcAPI.SpendResult> getIsSpendMethod;
    if ((getIsSpendMethod = WalletSolidityGrpc.getIsSpendMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getIsSpendMethod = WalletSolidityGrpc.getIsSpendMethod) == null) {
          WalletSolidityGrpc.getIsSpendMethod = getIsSpendMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.NoteParameters, org.cypher.api.GrpcAPI.SpendResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "IsSpend"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.NoteParameters.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.SpendResult.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("IsSpend"))
                  .build();
          }
        }
     }
     return getIsSpendMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getScanShieldedTRC20NotesByIvkMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.IvkDecryptTRC20Parameters,
      org.cypher.api.GrpcAPI.DecryptNotesTRC20> METHOD_SCAN_SHIELDED_TRC20NOTES_BY_IVK = getScanShieldedTRC20NotesByIvkMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.IvkDecryptTRC20Parameters,
      org.cypher.api.GrpcAPI.DecryptNotesTRC20> getScanShieldedTRC20NotesByIvkMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.IvkDecryptTRC20Parameters,
      org.cypher.api.GrpcAPI.DecryptNotesTRC20> getScanShieldedTRC20NotesByIvkMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.IvkDecryptTRC20Parameters, org.cypher.api.GrpcAPI.DecryptNotesTRC20> getScanShieldedTRC20NotesByIvkMethod;
    if ((getScanShieldedTRC20NotesByIvkMethod = WalletSolidityGrpc.getScanShieldedTRC20NotesByIvkMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getScanShieldedTRC20NotesByIvkMethod = WalletSolidityGrpc.getScanShieldedTRC20NotesByIvkMethod) == null) {
          WalletSolidityGrpc.getScanShieldedTRC20NotesByIvkMethod = getScanShieldedTRC20NotesByIvkMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.IvkDecryptTRC20Parameters, org.cypher.api.GrpcAPI.DecryptNotesTRC20>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "ScanShieldedTRC20NotesByIvk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.IvkDecryptTRC20Parameters.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.DecryptNotesTRC20.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("ScanShieldedTRC20NotesByIvk"))
                  .build();
          }
        }
     }
     return getScanShieldedTRC20NotesByIvkMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getScanShieldedTRC20NotesByOvkMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.OvkDecryptTRC20Parameters,
      org.cypher.api.GrpcAPI.DecryptNotesTRC20> METHOD_SCAN_SHIELDED_TRC20NOTES_BY_OVK = getScanShieldedTRC20NotesByOvkMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.OvkDecryptTRC20Parameters,
      org.cypher.api.GrpcAPI.DecryptNotesTRC20> getScanShieldedTRC20NotesByOvkMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.OvkDecryptTRC20Parameters,
      org.cypher.api.GrpcAPI.DecryptNotesTRC20> getScanShieldedTRC20NotesByOvkMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.OvkDecryptTRC20Parameters, org.cypher.api.GrpcAPI.DecryptNotesTRC20> getScanShieldedTRC20NotesByOvkMethod;
    if ((getScanShieldedTRC20NotesByOvkMethod = WalletSolidityGrpc.getScanShieldedTRC20NotesByOvkMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getScanShieldedTRC20NotesByOvkMethod = WalletSolidityGrpc.getScanShieldedTRC20NotesByOvkMethod) == null) {
          WalletSolidityGrpc.getScanShieldedTRC20NotesByOvkMethod = getScanShieldedTRC20NotesByOvkMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.OvkDecryptTRC20Parameters, org.cypher.api.GrpcAPI.DecryptNotesTRC20>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "ScanShieldedTRC20NotesByOvk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.OvkDecryptTRC20Parameters.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.DecryptNotesTRC20.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("ScanShieldedTRC20NotesByOvk"))
                  .build();
          }
        }
     }
     return getScanShieldedTRC20NotesByOvkMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getIsShieldedTRC20ContractNoteSpentMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NfTRC20Parameters,
      org.cypher.api.GrpcAPI.NullifierResult> METHOD_IS_SHIELDED_TRC20CONTRACT_NOTE_SPENT = getIsShieldedTRC20ContractNoteSpentMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NfTRC20Parameters,
      org.cypher.api.GrpcAPI.NullifierResult> getIsShieldedTRC20ContractNoteSpentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NfTRC20Parameters,
      org.cypher.api.GrpcAPI.NullifierResult> getIsShieldedTRC20ContractNoteSpentMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NfTRC20Parameters, org.cypher.api.GrpcAPI.NullifierResult> getIsShieldedTRC20ContractNoteSpentMethod;
    if ((getIsShieldedTRC20ContractNoteSpentMethod = WalletSolidityGrpc.getIsShieldedTRC20ContractNoteSpentMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getIsShieldedTRC20ContractNoteSpentMethod = WalletSolidityGrpc.getIsShieldedTRC20ContractNoteSpentMethod) == null) {
          WalletSolidityGrpc.getIsShieldedTRC20ContractNoteSpentMethod = getIsShieldedTRC20ContractNoteSpentMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.NfTRC20Parameters, org.cypher.api.GrpcAPI.NullifierResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "IsShieldedTRC20ContractNoteSpent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.NfTRC20Parameters.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.NullifierResult.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("IsShieldedTRC20ContractNoteSpent"))
                  .build();
          }
        }
     }
     return getIsShieldedTRC20ContractNoteSpentMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetRewardInfoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.api.GrpcAPI.NumberMessage> METHOD_GET_REWARD_INFO = getGetRewardInfoMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.api.GrpcAPI.NumberMessage> getGetRewardInfoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.api.GrpcAPI.NumberMessage> getGetRewardInfoMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.api.GrpcAPI.NumberMessage> getGetRewardInfoMethod;
    if ((getGetRewardInfoMethod = WalletSolidityGrpc.getGetRewardInfoMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetRewardInfoMethod = WalletSolidityGrpc.getGetRewardInfoMethod) == null) {
          WalletSolidityGrpc.getGetRewardInfoMethod = getGetRewardInfoMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.api.GrpcAPI.NumberMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetRewardInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.BytesMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.NumberMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetRewardInfo"))
                  .build();
          }
        }
     }
     return getGetRewardInfoMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetBrokerageInfoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.api.GrpcAPI.NumberMessage> METHOD_GET_BROKERAGE_INFO = getGetBrokerageInfoMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.api.GrpcAPI.NumberMessage> getGetBrokerageInfoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.api.GrpcAPI.NumberMessage> getGetBrokerageInfoMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.api.GrpcAPI.NumberMessage> getGetBrokerageInfoMethod;
    if ((getGetBrokerageInfoMethod = WalletSolidityGrpc.getGetBrokerageInfoMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetBrokerageInfoMethod = WalletSolidityGrpc.getGetBrokerageInfoMethod) == null) {
          WalletSolidityGrpc.getGetBrokerageInfoMethod = getGetBrokerageInfoMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.api.GrpcAPI.NumberMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetBrokerageInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.BytesMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.NumberMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetBrokerageInfo"))
                  .build();
          }
        }
     }
     return getGetBrokerageInfoMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTriggerConstantContractMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.protos.contract.SmartContractOuterClass.TriggerSmartContract,
      org.cypher.api.GrpcAPI.TransactionExtention> METHOD_TRIGGER_CONSTANT_CONTRACT = getTriggerConstantContractMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.protos.contract.SmartContractOuterClass.TriggerSmartContract,
      org.cypher.api.GrpcAPI.TransactionExtention> getTriggerConstantContractMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.protos.contract.SmartContractOuterClass.TriggerSmartContract,
      org.cypher.api.GrpcAPI.TransactionExtention> getTriggerConstantContractMethod() {
    io.grpc.MethodDescriptor<org.cypher.protos.contract.SmartContractOuterClass.TriggerSmartContract, org.cypher.api.GrpcAPI.TransactionExtention> getTriggerConstantContractMethod;
    if ((getTriggerConstantContractMethod = WalletSolidityGrpc.getTriggerConstantContractMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getTriggerConstantContractMethod = WalletSolidityGrpc.getTriggerConstantContractMethod) == null) {
          WalletSolidityGrpc.getTriggerConstantContractMethod = getTriggerConstantContractMethod = 
              io.grpc.MethodDescriptor.<org.cypher.protos.contract.SmartContractOuterClass.TriggerSmartContract, org.cypher.api.GrpcAPI.TransactionExtention>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "TriggerConstantContract"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.contract.SmartContractOuterClass.TriggerSmartContract.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.TransactionExtention.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("TriggerConstantContract"))
                  .build();
          }
        }
     }
     return getTriggerConstantContractMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTransactionInfoByBlockNumMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage,
      org.cypher.api.GrpcAPI.TransactionInfoList> METHOD_GET_TRANSACTION_INFO_BY_BLOCK_NUM = getGetTransactionInfoByBlockNumMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage,
      org.cypher.api.GrpcAPI.TransactionInfoList> getGetTransactionInfoByBlockNumMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage,
      org.cypher.api.GrpcAPI.TransactionInfoList> getGetTransactionInfoByBlockNumMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.NumberMessage, org.cypher.api.GrpcAPI.TransactionInfoList> getGetTransactionInfoByBlockNumMethod;
    if ((getGetTransactionInfoByBlockNumMethod = WalletSolidityGrpc.getGetTransactionInfoByBlockNumMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetTransactionInfoByBlockNumMethod = WalletSolidityGrpc.getGetTransactionInfoByBlockNumMethod) == null) {
          WalletSolidityGrpc.getGetTransactionInfoByBlockNumMethod = getGetTransactionInfoByBlockNumMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.NumberMessage, org.cypher.api.GrpcAPI.TransactionInfoList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetTransactionInfoByBlockNum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.NumberMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.TransactionInfoList.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetTransactionInfoByBlockNum"))
                  .build();
          }
        }
     }
     return getGetTransactionInfoByBlockNumMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMarketOrderByIdMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.MarketOrder> METHOD_GET_MARKET_ORDER_BY_ID = getGetMarketOrderByIdMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.MarketOrder> getGetMarketOrderByIdMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.MarketOrder> getGetMarketOrderByIdMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.Protocol.MarketOrder> getGetMarketOrderByIdMethod;
    if ((getGetMarketOrderByIdMethod = WalletSolidityGrpc.getGetMarketOrderByIdMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetMarketOrderByIdMethod = WalletSolidityGrpc.getGetMarketOrderByIdMethod) == null) {
          WalletSolidityGrpc.getGetMarketOrderByIdMethod = getGetMarketOrderByIdMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.Protocol.MarketOrder>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetMarketOrderById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.BytesMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.MarketOrder.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetMarketOrderById"))
                  .build();
          }
        }
     }
     return getGetMarketOrderByIdMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMarketOrderByAccountMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.MarketOrderList> METHOD_GET_MARKET_ORDER_BY_ACCOUNT = getGetMarketOrderByAccountMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.MarketOrderList> getGetMarketOrderByAccountMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage,
      org.cypher.protos.Protocol.MarketOrderList> getGetMarketOrderByAccountMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.Protocol.MarketOrderList> getGetMarketOrderByAccountMethod;
    if ((getGetMarketOrderByAccountMethod = WalletSolidityGrpc.getGetMarketOrderByAccountMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetMarketOrderByAccountMethod = WalletSolidityGrpc.getGetMarketOrderByAccountMethod) == null) {
          WalletSolidityGrpc.getGetMarketOrderByAccountMethod = getGetMarketOrderByAccountMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.BytesMessage, org.cypher.protos.Protocol.MarketOrderList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetMarketOrderByAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.BytesMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.MarketOrderList.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetMarketOrderByAccount"))
                  .build();
          }
        }
     }
     return getGetMarketOrderByAccountMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMarketPriceByPairMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.protos.Protocol.MarketOrderPair,
      org.cypher.protos.Protocol.MarketPriceList> METHOD_GET_MARKET_PRICE_BY_PAIR = getGetMarketPriceByPairMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.protos.Protocol.MarketOrderPair,
      org.cypher.protos.Protocol.MarketPriceList> getGetMarketPriceByPairMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.protos.Protocol.MarketOrderPair,
      org.cypher.protos.Protocol.MarketPriceList> getGetMarketPriceByPairMethod() {
    io.grpc.MethodDescriptor<org.cypher.protos.Protocol.MarketOrderPair, org.cypher.protos.Protocol.MarketPriceList> getGetMarketPriceByPairMethod;
    if ((getGetMarketPriceByPairMethod = WalletSolidityGrpc.getGetMarketPriceByPairMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetMarketPriceByPairMethod = WalletSolidityGrpc.getGetMarketPriceByPairMethod) == null) {
          WalletSolidityGrpc.getGetMarketPriceByPairMethod = getGetMarketPriceByPairMethod = 
              io.grpc.MethodDescriptor.<org.cypher.protos.Protocol.MarketOrderPair, org.cypher.protos.Protocol.MarketPriceList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetMarketPriceByPair"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.MarketOrderPair.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.MarketPriceList.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetMarketPriceByPair"))
                  .build();
          }
        }
     }
     return getGetMarketPriceByPairMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMarketOrderListByPairMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.protos.Protocol.MarketOrderPair,
      org.cypher.protos.Protocol.MarketOrderList> METHOD_GET_MARKET_ORDER_LIST_BY_PAIR = getGetMarketOrderListByPairMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.protos.Protocol.MarketOrderPair,
      org.cypher.protos.Protocol.MarketOrderList> getGetMarketOrderListByPairMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.protos.Protocol.MarketOrderPair,
      org.cypher.protos.Protocol.MarketOrderList> getGetMarketOrderListByPairMethod() {
    io.grpc.MethodDescriptor<org.cypher.protos.Protocol.MarketOrderPair, org.cypher.protos.Protocol.MarketOrderList> getGetMarketOrderListByPairMethod;
    if ((getGetMarketOrderListByPairMethod = WalletSolidityGrpc.getGetMarketOrderListByPairMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetMarketOrderListByPairMethod = WalletSolidityGrpc.getGetMarketOrderListByPairMethod) == null) {
          WalletSolidityGrpc.getGetMarketOrderListByPairMethod = getGetMarketOrderListByPairMethod = 
              io.grpc.MethodDescriptor.<org.cypher.protos.Protocol.MarketOrderPair, org.cypher.protos.Protocol.MarketOrderList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetMarketOrderListByPair"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.MarketOrderPair.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.MarketOrderList.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetMarketOrderListByPair"))
                  .build();
          }
        }
     }
     return getGetMarketOrderListByPairMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMarketPairListMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.protos.Protocol.MarketOrderPairList> METHOD_GET_MARKET_PAIR_LIST = getGetMarketPairListMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.protos.Protocol.MarketOrderPairList> getGetMarketPairListMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.protos.Protocol.MarketOrderPairList> getGetMarketPairListMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.protos.Protocol.MarketOrderPairList> getGetMarketPairListMethod;
    if ((getGetMarketPairListMethod = WalletSolidityGrpc.getGetMarketPairListMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetMarketPairListMethod = WalletSolidityGrpc.getGetMarketPairListMethod) == null) {
          WalletSolidityGrpc.getGetMarketPairListMethod = getGetMarketPairListMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.protos.Protocol.MarketOrderPairList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetMarketPairList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.EmptyMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.protos.Protocol.MarketOrderPairList.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetMarketPairList"))
                  .build();
          }
        }
     }
     return getGetMarketPairListMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetBurnCypMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.NumberMessage> METHOD_GET_BURN_CYP = getGetBurnCypMethod();

  private static volatile io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.NumberMessage> getGetBurnCypMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage,
      org.cypher.api.GrpcAPI.NumberMessage> getGetBurnCypMethod() {
    io.grpc.MethodDescriptor<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.api.GrpcAPI.NumberMessage> getGetBurnCypMethod;
    if ((getGetBurnCypMethod = WalletSolidityGrpc.getGetBurnCypMethod) == null) {
      synchronized (WalletSolidityGrpc.class) {
        if ((getGetBurnCypMethod = WalletSolidityGrpc.getGetBurnCypMethod) == null) {
          WalletSolidityGrpc.getGetBurnCypMethod = getGetBurnCypMethod = 
              io.grpc.MethodDescriptor.<org.cypher.api.GrpcAPI.EmptyMessage, org.cypher.api.GrpcAPI.NumberMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "protocol.WalletSolidity", "GetBurnCyp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.EmptyMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.cypher.api.GrpcAPI.NumberMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new WalletSolidityMethodDescriptorSupplier("GetBurnCyp"))
                  .build();
          }
        }
     }
     return getGetBurnCypMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WalletSolidityStub newStub(io.grpc.Channel channel) {
    return new WalletSolidityStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WalletSolidityBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WalletSolidityBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WalletSolidityFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WalletSolidityFutureStub(channel);
  }

  /**
   */
  public static abstract class WalletSolidityImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAccount(org.cypher.protos.Protocol.Account request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Account> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountMethod(), responseObserver);
    }

    /**
     */
    public void getAccountById(org.cypher.protos.Protocol.Account request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Account> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountByIdMethod(), responseObserver);
    }

    /**
     */
    public void listWitnesses(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.WitnessList> responseObserver) {
      asyncUnimplementedUnaryCall(getListWitnessesMethod(), responseObserver);
    }

    /**
     */
    public void getAssetIssueList(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.AssetIssueList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAssetIssueListMethod(), responseObserver);
    }

    /**
     */
    public void getPaginatedAssetIssueList(org.cypher.api.GrpcAPI.PaginatedMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.AssetIssueList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPaginatedAssetIssueListMethod(), responseObserver);
    }

    /**
     */
    public void getAssetIssueByName(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAssetIssueByNameMethod(), responseObserver);
    }

    /**
     */
    public void getAssetIssueListByName(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.AssetIssueList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAssetIssueListByNameMethod(), responseObserver);
    }

    /**
     */
    public void getAssetIssueById(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAssetIssueByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     *Please use GetNowBlock2 instead of this function.
     * </pre>
     */
    public void getNowBlock(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Block> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNowBlockMethod(), responseObserver);
    }

    /**
     * <pre>
     *Use this function instead of GetNowBlock.
     * </pre>
     */
    public void getNowBlock2(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.BlockExtention> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNowBlock2Method(), responseObserver);
    }

    /**
     * <pre>
     *Please use GetBlockByNum2 instead of this function.
     * </pre>
     */
    public void getBlockByNum(org.cypher.api.GrpcAPI.NumberMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Block> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBlockByNumMethod(), responseObserver);
    }

    /**
     * <pre>
     *Use this function instead of GetBlockByNum.
     * </pre>
     */
    public void getBlockByNum2(org.cypher.api.GrpcAPI.NumberMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.BlockExtention> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBlockByNum2Method(), responseObserver);
    }

    /**
     */
    public void getTransactionCountByBlockNum(org.cypher.api.GrpcAPI.NumberMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NumberMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransactionCountByBlockNumMethod(), responseObserver);
    }

    /**
     */
    public void getDelegatedResource(org.cypher.api.GrpcAPI.DelegatedResourceMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DelegatedResourceList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDelegatedResourceMethod(), responseObserver);
    }

    /**
     */
    public void getDelegatedResourceAccountIndex(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.DelegatedResourceAccountIndex> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDelegatedResourceAccountIndexMethod(), responseObserver);
    }

    /**
     */
    public void getExchangeById(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Exchange> responseObserver) {
      asyncUnimplementedUnaryCall(getGetExchangeByIdMethod(), responseObserver);
    }

    /**
     */
    public void listExchanges(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.ExchangeList> responseObserver) {
      asyncUnimplementedUnaryCall(getListExchangesMethod(), responseObserver);
    }

    /**
     */
    public void getTransactionById(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Transaction> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransactionByIdMethod(), responseObserver);
    }

    /**
     */
    public void getTransactionInfoById(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.TransactionInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransactionInfoByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     *Warning: do not invoke this interface provided by others.
     * </pre>
     */
    public void generateAddress(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.AddressPrKeyPairMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateAddressMethod(), responseObserver);
    }

    /**
     */
    public void getMerkleTreeVoucherInfo(org.cypher.protos.contract.ShieldContract.OutputPointInfo request,
        io.grpc.stub.StreamObserver<org.cypher.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMerkleTreeVoucherInfoMethod(), responseObserver);
    }

    /**
     */
    public void scanNoteByIvk(org.cypher.api.GrpcAPI.IvkDecryptParameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotes> responseObserver) {
      asyncUnimplementedUnaryCall(getScanNoteByIvkMethod(), responseObserver);
    }

    /**
     */
    public void scanAndMarkNoteByIvk(org.cypher.api.GrpcAPI.IvkDecryptAndMarkParameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotesMarked> responseObserver) {
      asyncUnimplementedUnaryCall(getScanAndMarkNoteByIvkMethod(), responseObserver);
    }

    /**
     */
    public void scanNoteByOvk(org.cypher.api.GrpcAPI.OvkDecryptParameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotes> responseObserver) {
      asyncUnimplementedUnaryCall(getScanNoteByOvkMethod(), responseObserver);
    }

    /**
     */
    public void isSpend(org.cypher.api.GrpcAPI.NoteParameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.SpendResult> responseObserver) {
      asyncUnimplementedUnaryCall(getIsSpendMethod(), responseObserver);
    }

    /**
     */
    public void scanShieldedTRC20NotesByIvk(org.cypher.api.GrpcAPI.IvkDecryptTRC20Parameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotesTRC20> responseObserver) {
      asyncUnimplementedUnaryCall(getScanShieldedTRC20NotesByIvkMethod(), responseObserver);
    }

    /**
     */
    public void scanShieldedTRC20NotesByOvk(org.cypher.api.GrpcAPI.OvkDecryptTRC20Parameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotesTRC20> responseObserver) {
      asyncUnimplementedUnaryCall(getScanShieldedTRC20NotesByOvkMethod(), responseObserver);
    }

    /**
     */
    public void isShieldedTRC20ContractNoteSpent(org.cypher.api.GrpcAPI.NfTRC20Parameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NullifierResult> responseObserver) {
      asyncUnimplementedUnaryCall(getIsShieldedTRC20ContractNoteSpentMethod(), responseObserver);
    }

    /**
     */
    public void getRewardInfo(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NumberMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRewardInfoMethod(), responseObserver);
    }

    /**
     */
    public void getBrokerageInfo(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NumberMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBrokerageInfoMethod(), responseObserver);
    }

    /**
     */
    public void triggerConstantContract(org.cypher.protos.contract.SmartContractOuterClass.TriggerSmartContract request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.TransactionExtention> responseObserver) {
      asyncUnimplementedUnaryCall(getTriggerConstantContractMethod(), responseObserver);
    }

    /**
     */
    public void getTransactionInfoByBlockNum(org.cypher.api.GrpcAPI.NumberMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.TransactionInfoList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransactionInfoByBlockNumMethod(), responseObserver);
    }

    /**
     */
    public void getMarketOrderById(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketOrder> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMarketOrderByIdMethod(), responseObserver);
    }

    /**
     */
    public void getMarketOrderByAccount(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketOrderList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMarketOrderByAccountMethod(), responseObserver);
    }

    /**
     */
    public void getMarketPriceByPair(org.cypher.protos.Protocol.MarketOrderPair request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketPriceList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMarketPriceByPairMethod(), responseObserver);
    }

    /**
     */
    public void getMarketOrderListByPair(org.cypher.protos.Protocol.MarketOrderPair request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketOrderList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMarketOrderListByPairMethod(), responseObserver);
    }

    /**
     */
    public void getMarketPairList(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketOrderPairList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMarketPairListMethod(), responseObserver);
    }

    /**
     */
    public void getBurnCyp(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NumberMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBurnCypMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAccountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.protos.Protocol.Account,
                org.cypher.protos.Protocol.Account>(
                  this, METHODID_GET_ACCOUNT)))
          .addMethod(
            getGetAccountByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.protos.Protocol.Account,
                org.cypher.protos.Protocol.Account>(
                  this, METHODID_GET_ACCOUNT_BY_ID)))
          .addMethod(
            getListWitnessesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.EmptyMessage,
                org.cypher.api.GrpcAPI.WitnessList>(
                  this, METHODID_LIST_WITNESSES)))
          .addMethod(
            getGetAssetIssueListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.EmptyMessage,
                org.cypher.api.GrpcAPI.AssetIssueList>(
                  this, METHODID_GET_ASSET_ISSUE_LIST)))
          .addMethod(
            getGetPaginatedAssetIssueListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.PaginatedMessage,
                org.cypher.api.GrpcAPI.AssetIssueList>(
                  this, METHODID_GET_PAGINATED_ASSET_ISSUE_LIST)))
          .addMethod(
            getGetAssetIssueByNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.BytesMessage,
                org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract>(
                  this, METHODID_GET_ASSET_ISSUE_BY_NAME)))
          .addMethod(
            getGetAssetIssueListByNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.BytesMessage,
                org.cypher.api.GrpcAPI.AssetIssueList>(
                  this, METHODID_GET_ASSET_ISSUE_LIST_BY_NAME)))
          .addMethod(
            getGetAssetIssueByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.BytesMessage,
                org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract>(
                  this, METHODID_GET_ASSET_ISSUE_BY_ID)))
          .addMethod(
            getGetNowBlockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.EmptyMessage,
                org.cypher.protos.Protocol.Block>(
                  this, METHODID_GET_NOW_BLOCK)))
          .addMethod(
            getGetNowBlock2Method(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.EmptyMessage,
                org.cypher.api.GrpcAPI.BlockExtention>(
                  this, METHODID_GET_NOW_BLOCK2)))
          .addMethod(
            getGetBlockByNumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.NumberMessage,
                org.cypher.protos.Protocol.Block>(
                  this, METHODID_GET_BLOCK_BY_NUM)))
          .addMethod(
            getGetBlockByNum2Method(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.NumberMessage,
                org.cypher.api.GrpcAPI.BlockExtention>(
                  this, METHODID_GET_BLOCK_BY_NUM2)))
          .addMethod(
            getGetTransactionCountByBlockNumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.NumberMessage,
                org.cypher.api.GrpcAPI.NumberMessage>(
                  this, METHODID_GET_TRANSACTION_COUNT_BY_BLOCK_NUM)))
          .addMethod(
            getGetDelegatedResourceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.DelegatedResourceMessage,
                org.cypher.api.GrpcAPI.DelegatedResourceList>(
                  this, METHODID_GET_DELEGATED_RESOURCE)))
          .addMethod(
            getGetDelegatedResourceAccountIndexMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.BytesMessage,
                org.cypher.protos.Protocol.DelegatedResourceAccountIndex>(
                  this, METHODID_GET_DELEGATED_RESOURCE_ACCOUNT_INDEX)))
          .addMethod(
            getGetExchangeByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.BytesMessage,
                org.cypher.protos.Protocol.Exchange>(
                  this, METHODID_GET_EXCHANGE_BY_ID)))
          .addMethod(
            getListExchangesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.EmptyMessage,
                org.cypher.api.GrpcAPI.ExchangeList>(
                  this, METHODID_LIST_EXCHANGES)))
          .addMethod(
            getGetTransactionByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.BytesMessage,
                org.cypher.protos.Protocol.Transaction>(
                  this, METHODID_GET_TRANSACTION_BY_ID)))
          .addMethod(
            getGetTransactionInfoByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.BytesMessage,
                org.cypher.protos.Protocol.TransactionInfo>(
                  this, METHODID_GET_TRANSACTION_INFO_BY_ID)))
          .addMethod(
            getGenerateAddressMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.EmptyMessage,
                org.cypher.api.GrpcAPI.AddressPrKeyPairMessage>(
                  this, METHODID_GENERATE_ADDRESS)))
          .addMethod(
            getGetMerkleTreeVoucherInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.protos.contract.ShieldContract.OutputPointInfo,
                org.cypher.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo>(
                  this, METHODID_GET_MERKLE_TREE_VOUCHER_INFO)))
          .addMethod(
            getScanNoteByIvkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.IvkDecryptParameters,
                org.cypher.api.GrpcAPI.DecryptNotes>(
                  this, METHODID_SCAN_NOTE_BY_IVK)))
          .addMethod(
            getScanAndMarkNoteByIvkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.IvkDecryptAndMarkParameters,
                org.cypher.api.GrpcAPI.DecryptNotesMarked>(
                  this, METHODID_SCAN_AND_MARK_NOTE_BY_IVK)))
          .addMethod(
            getScanNoteByOvkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.OvkDecryptParameters,
                org.cypher.api.GrpcAPI.DecryptNotes>(
                  this, METHODID_SCAN_NOTE_BY_OVK)))
          .addMethod(
            getIsSpendMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.NoteParameters,
                org.cypher.api.GrpcAPI.SpendResult>(
                  this, METHODID_IS_SPEND)))
          .addMethod(
            getScanShieldedTRC20NotesByIvkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.IvkDecryptTRC20Parameters,
                org.cypher.api.GrpcAPI.DecryptNotesTRC20>(
                  this, METHODID_SCAN_SHIELDED_TRC20NOTES_BY_IVK)))
          .addMethod(
            getScanShieldedTRC20NotesByOvkMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.OvkDecryptTRC20Parameters,
                org.cypher.api.GrpcAPI.DecryptNotesTRC20>(
                  this, METHODID_SCAN_SHIELDED_TRC20NOTES_BY_OVK)))
          .addMethod(
            getIsShieldedTRC20ContractNoteSpentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.NfTRC20Parameters,
                org.cypher.api.GrpcAPI.NullifierResult>(
                  this, METHODID_IS_SHIELDED_TRC20CONTRACT_NOTE_SPENT)))
          .addMethod(
            getGetRewardInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.BytesMessage,
                org.cypher.api.GrpcAPI.NumberMessage>(
                  this, METHODID_GET_REWARD_INFO)))
          .addMethod(
            getGetBrokerageInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.BytesMessage,
                org.cypher.api.GrpcAPI.NumberMessage>(
                  this, METHODID_GET_BROKERAGE_INFO)))
          .addMethod(
            getTriggerConstantContractMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.protos.contract.SmartContractOuterClass.TriggerSmartContract,
                org.cypher.api.GrpcAPI.TransactionExtention>(
                  this, METHODID_TRIGGER_CONSTANT_CONTRACT)))
          .addMethod(
            getGetTransactionInfoByBlockNumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.NumberMessage,
                org.cypher.api.GrpcAPI.TransactionInfoList>(
                  this, METHODID_GET_TRANSACTION_INFO_BY_BLOCK_NUM)))
          .addMethod(
            getGetMarketOrderByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.BytesMessage,
                org.cypher.protos.Protocol.MarketOrder>(
                  this, METHODID_GET_MARKET_ORDER_BY_ID)))
          .addMethod(
            getGetMarketOrderByAccountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.BytesMessage,
                org.cypher.protos.Protocol.MarketOrderList>(
                  this, METHODID_GET_MARKET_ORDER_BY_ACCOUNT)))
          .addMethod(
            getGetMarketPriceByPairMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.protos.Protocol.MarketOrderPair,
                org.cypher.protos.Protocol.MarketPriceList>(
                  this, METHODID_GET_MARKET_PRICE_BY_PAIR)))
          .addMethod(
            getGetMarketOrderListByPairMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.protos.Protocol.MarketOrderPair,
                org.cypher.protos.Protocol.MarketOrderList>(
                  this, METHODID_GET_MARKET_ORDER_LIST_BY_PAIR)))
          .addMethod(
            getGetMarketPairListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.EmptyMessage,
                org.cypher.protos.Protocol.MarketOrderPairList>(
                  this, METHODID_GET_MARKET_PAIR_LIST)))
          .addMethod(
            getGetBurnCypMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.cypher.api.GrpcAPI.EmptyMessage,
                org.cypher.api.GrpcAPI.NumberMessage>(
                  this, METHODID_GET_BURN_CYP)))
          .build();
    }
  }

  /**
   */
  public static final class WalletSolidityStub extends io.grpc.stub.AbstractStub<WalletSolidityStub> {
    private WalletSolidityStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WalletSolidityStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletSolidityStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WalletSolidityStub(channel, callOptions);
    }

    /**
     */
    public void getAccount(org.cypher.protos.Protocol.Account request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Account> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccountById(org.cypher.protos.Protocol.Account request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Account> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listWitnesses(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.WitnessList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListWitnessesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAssetIssueList(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.AssetIssueList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAssetIssueListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPaginatedAssetIssueList(org.cypher.api.GrpcAPI.PaginatedMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.AssetIssueList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPaginatedAssetIssueListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAssetIssueByName(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAssetIssueByNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAssetIssueListByName(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.AssetIssueList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAssetIssueListByNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAssetIssueById(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAssetIssueByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Please use GetNowBlock2 instead of this function.
     * </pre>
     */
    public void getNowBlock(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Block> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNowBlockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Use this function instead of GetNowBlock.
     * </pre>
     */
    public void getNowBlock2(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.BlockExtention> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNowBlock2Method(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Please use GetBlockByNum2 instead of this function.
     * </pre>
     */
    public void getBlockByNum(org.cypher.api.GrpcAPI.NumberMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Block> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBlockByNumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Use this function instead of GetBlockByNum.
     * </pre>
     */
    public void getBlockByNum2(org.cypher.api.GrpcAPI.NumberMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.BlockExtention> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBlockByNum2Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTransactionCountByBlockNum(org.cypher.api.GrpcAPI.NumberMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NumberMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTransactionCountByBlockNumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDelegatedResource(org.cypher.api.GrpcAPI.DelegatedResourceMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DelegatedResourceList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDelegatedResourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDelegatedResourceAccountIndex(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.DelegatedResourceAccountIndex> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDelegatedResourceAccountIndexMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getExchangeById(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Exchange> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetExchangeByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listExchanges(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.ExchangeList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListExchangesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTransactionById(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Transaction> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTransactionByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTransactionInfoById(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.TransactionInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTransactionInfoByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Warning: do not invoke this interface provided by others.
     * </pre>
     */
    public void generateAddress(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.AddressPrKeyPairMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGenerateAddressMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMerkleTreeVoucherInfo(org.cypher.protos.contract.ShieldContract.OutputPointInfo request,
        io.grpc.stub.StreamObserver<org.cypher.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMerkleTreeVoucherInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void scanNoteByIvk(org.cypher.api.GrpcAPI.IvkDecryptParameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getScanNoteByIvkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void scanAndMarkNoteByIvk(org.cypher.api.GrpcAPI.IvkDecryptAndMarkParameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotesMarked> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getScanAndMarkNoteByIvkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void scanNoteByOvk(org.cypher.api.GrpcAPI.OvkDecryptParameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getScanNoteByOvkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isSpend(org.cypher.api.GrpcAPI.NoteParameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.SpendResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsSpendMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void scanShieldedTRC20NotesByIvk(org.cypher.api.GrpcAPI.IvkDecryptTRC20Parameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotesTRC20> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getScanShieldedTRC20NotesByIvkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void scanShieldedTRC20NotesByOvk(org.cypher.api.GrpcAPI.OvkDecryptTRC20Parameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotesTRC20> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getScanShieldedTRC20NotesByOvkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isShieldedTRC20ContractNoteSpent(org.cypher.api.GrpcAPI.NfTRC20Parameters request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NullifierResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsShieldedTRC20ContractNoteSpentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRewardInfo(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NumberMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRewardInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBrokerageInfo(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NumberMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBrokerageInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void triggerConstantContract(org.cypher.protos.contract.SmartContractOuterClass.TriggerSmartContract request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.TransactionExtention> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTriggerConstantContractMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTransactionInfoByBlockNum(org.cypher.api.GrpcAPI.NumberMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.TransactionInfoList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTransactionInfoByBlockNumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMarketOrderById(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketOrder> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMarketOrderByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMarketOrderByAccount(org.cypher.api.GrpcAPI.BytesMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketOrderList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMarketOrderByAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMarketPriceByPair(org.cypher.protos.Protocol.MarketOrderPair request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketPriceList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMarketPriceByPairMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMarketOrderListByPair(org.cypher.protos.Protocol.MarketOrderPair request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketOrderList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMarketOrderListByPairMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMarketPairList(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketOrderPairList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMarketPairListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBurnCyp(org.cypher.api.GrpcAPI.EmptyMessage request,
        io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NumberMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBurnCypMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WalletSolidityBlockingStub extends io.grpc.stub.AbstractStub<WalletSolidityBlockingStub> {
    private WalletSolidityBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WalletSolidityBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletSolidityBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WalletSolidityBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.cypher.protos.Protocol.Account getAccount(org.cypher.protos.Protocol.Account request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.protos.Protocol.Account getAccountById(org.cypher.protos.Protocol.Account request) {
      return blockingUnaryCall(
          getChannel(), getGetAccountByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.WitnessList listWitnesses(org.cypher.api.GrpcAPI.EmptyMessage request) {
      return blockingUnaryCall(
          getChannel(), getListWitnessesMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.AssetIssueList getAssetIssueList(org.cypher.api.GrpcAPI.EmptyMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetAssetIssueListMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.AssetIssueList getPaginatedAssetIssueList(org.cypher.api.GrpcAPI.PaginatedMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetPaginatedAssetIssueListMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract getAssetIssueByName(org.cypher.api.GrpcAPI.BytesMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetAssetIssueByNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.AssetIssueList getAssetIssueListByName(org.cypher.api.GrpcAPI.BytesMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetAssetIssueListByNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract getAssetIssueById(org.cypher.api.GrpcAPI.BytesMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetAssetIssueByIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Please use GetNowBlock2 instead of this function.
     * </pre>
     */
    public org.cypher.protos.Protocol.Block getNowBlock(org.cypher.api.GrpcAPI.EmptyMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetNowBlockMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Use this function instead of GetNowBlock.
     * </pre>
     */
    public org.cypher.api.GrpcAPI.BlockExtention getNowBlock2(org.cypher.api.GrpcAPI.EmptyMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetNowBlock2Method(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Please use GetBlockByNum2 instead of this function.
     * </pre>
     */
    public org.cypher.protos.Protocol.Block getBlockByNum(org.cypher.api.GrpcAPI.NumberMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetBlockByNumMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Use this function instead of GetBlockByNum.
     * </pre>
     */
    public org.cypher.api.GrpcAPI.BlockExtention getBlockByNum2(org.cypher.api.GrpcAPI.NumberMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetBlockByNum2Method(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.NumberMessage getTransactionCountByBlockNum(org.cypher.api.GrpcAPI.NumberMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetTransactionCountByBlockNumMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.DelegatedResourceList getDelegatedResource(org.cypher.api.GrpcAPI.DelegatedResourceMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetDelegatedResourceMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.protos.Protocol.DelegatedResourceAccountIndex getDelegatedResourceAccountIndex(org.cypher.api.GrpcAPI.BytesMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetDelegatedResourceAccountIndexMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.protos.Protocol.Exchange getExchangeById(org.cypher.api.GrpcAPI.BytesMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetExchangeByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.ExchangeList listExchanges(org.cypher.api.GrpcAPI.EmptyMessage request) {
      return blockingUnaryCall(
          getChannel(), getListExchangesMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.protos.Protocol.Transaction getTransactionById(org.cypher.api.GrpcAPI.BytesMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetTransactionByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.protos.Protocol.TransactionInfo getTransactionInfoById(org.cypher.api.GrpcAPI.BytesMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetTransactionInfoByIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Warning: do not invoke this interface provided by others.
     * </pre>
     */
    public org.cypher.api.GrpcAPI.AddressPrKeyPairMessage generateAddress(org.cypher.api.GrpcAPI.EmptyMessage request) {
      return blockingUnaryCall(
          getChannel(), getGenerateAddressMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo getMerkleTreeVoucherInfo(org.cypher.protos.contract.ShieldContract.OutputPointInfo request) {
      return blockingUnaryCall(
          getChannel(), getGetMerkleTreeVoucherInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.DecryptNotes scanNoteByIvk(org.cypher.api.GrpcAPI.IvkDecryptParameters request) {
      return blockingUnaryCall(
          getChannel(), getScanNoteByIvkMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.DecryptNotesMarked scanAndMarkNoteByIvk(org.cypher.api.GrpcAPI.IvkDecryptAndMarkParameters request) {
      return blockingUnaryCall(
          getChannel(), getScanAndMarkNoteByIvkMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.DecryptNotes scanNoteByOvk(org.cypher.api.GrpcAPI.OvkDecryptParameters request) {
      return blockingUnaryCall(
          getChannel(), getScanNoteByOvkMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.SpendResult isSpend(org.cypher.api.GrpcAPI.NoteParameters request) {
      return blockingUnaryCall(
          getChannel(), getIsSpendMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.DecryptNotesTRC20 scanShieldedTRC20NotesByIvk(org.cypher.api.GrpcAPI.IvkDecryptTRC20Parameters request) {
      return blockingUnaryCall(
          getChannel(), getScanShieldedTRC20NotesByIvkMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.DecryptNotesTRC20 scanShieldedTRC20NotesByOvk(org.cypher.api.GrpcAPI.OvkDecryptTRC20Parameters request) {
      return blockingUnaryCall(
          getChannel(), getScanShieldedTRC20NotesByOvkMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.NullifierResult isShieldedTRC20ContractNoteSpent(org.cypher.api.GrpcAPI.NfTRC20Parameters request) {
      return blockingUnaryCall(
          getChannel(), getIsShieldedTRC20ContractNoteSpentMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.NumberMessage getRewardInfo(org.cypher.api.GrpcAPI.BytesMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetRewardInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.NumberMessage getBrokerageInfo(org.cypher.api.GrpcAPI.BytesMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetBrokerageInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.TransactionExtention triggerConstantContract(org.cypher.protos.contract.SmartContractOuterClass.TriggerSmartContract request) {
      return blockingUnaryCall(
          getChannel(), getTriggerConstantContractMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.TransactionInfoList getTransactionInfoByBlockNum(org.cypher.api.GrpcAPI.NumberMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetTransactionInfoByBlockNumMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.protos.Protocol.MarketOrder getMarketOrderById(org.cypher.api.GrpcAPI.BytesMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetMarketOrderByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.protos.Protocol.MarketOrderList getMarketOrderByAccount(org.cypher.api.GrpcAPI.BytesMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetMarketOrderByAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.protos.Protocol.MarketPriceList getMarketPriceByPair(org.cypher.protos.Protocol.MarketOrderPair request) {
      return blockingUnaryCall(
          getChannel(), getGetMarketPriceByPairMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.protos.Protocol.MarketOrderList getMarketOrderListByPair(org.cypher.protos.Protocol.MarketOrderPair request) {
      return blockingUnaryCall(
          getChannel(), getGetMarketOrderListByPairMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.protos.Protocol.MarketOrderPairList getMarketPairList(org.cypher.api.GrpcAPI.EmptyMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetMarketPairListMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.cypher.api.GrpcAPI.NumberMessage getBurnCyp(org.cypher.api.GrpcAPI.EmptyMessage request) {
      return blockingUnaryCall(
          getChannel(), getGetBurnCypMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WalletSolidityFutureStub extends io.grpc.stub.AbstractStub<WalletSolidityFutureStub> {
    private WalletSolidityFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WalletSolidityFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WalletSolidityFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WalletSolidityFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.Protocol.Account> getAccount(
        org.cypher.protos.Protocol.Account request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.Protocol.Account> getAccountById(
        org.cypher.protos.Protocol.Account request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.WitnessList> listWitnesses(
        org.cypher.api.GrpcAPI.EmptyMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getListWitnessesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.AssetIssueList> getAssetIssueList(
        org.cypher.api.GrpcAPI.EmptyMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAssetIssueListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.AssetIssueList> getPaginatedAssetIssueList(
        org.cypher.api.GrpcAPI.PaginatedMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPaginatedAssetIssueListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> getAssetIssueByName(
        org.cypher.api.GrpcAPI.BytesMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAssetIssueByNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.AssetIssueList> getAssetIssueListByName(
        org.cypher.api.GrpcAPI.BytesMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAssetIssueListByNameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract> getAssetIssueById(
        org.cypher.api.GrpcAPI.BytesMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAssetIssueByIdMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Please use GetNowBlock2 instead of this function.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.Protocol.Block> getNowBlock(
        org.cypher.api.GrpcAPI.EmptyMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNowBlockMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Use this function instead of GetNowBlock.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.BlockExtention> getNowBlock2(
        org.cypher.api.GrpcAPI.EmptyMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNowBlock2Method(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Please use GetBlockByNum2 instead of this function.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.Protocol.Block> getBlockByNum(
        org.cypher.api.GrpcAPI.NumberMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBlockByNumMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Use this function instead of GetBlockByNum.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.BlockExtention> getBlockByNum2(
        org.cypher.api.GrpcAPI.NumberMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBlockByNum2Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.NumberMessage> getTransactionCountByBlockNum(
        org.cypher.api.GrpcAPI.NumberMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTransactionCountByBlockNumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.DelegatedResourceList> getDelegatedResource(
        org.cypher.api.GrpcAPI.DelegatedResourceMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDelegatedResourceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.Protocol.DelegatedResourceAccountIndex> getDelegatedResourceAccountIndex(
        org.cypher.api.GrpcAPI.BytesMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDelegatedResourceAccountIndexMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.Protocol.Exchange> getExchangeById(
        org.cypher.api.GrpcAPI.BytesMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetExchangeByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.ExchangeList> listExchanges(
        org.cypher.api.GrpcAPI.EmptyMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getListExchangesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.Protocol.Transaction> getTransactionById(
        org.cypher.api.GrpcAPI.BytesMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTransactionByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.Protocol.TransactionInfo> getTransactionInfoById(
        org.cypher.api.GrpcAPI.BytesMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTransactionInfoByIdMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Warning: do not invoke this interface provided by others.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.AddressPrKeyPairMessage> generateAddress(
        org.cypher.api.GrpcAPI.EmptyMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGenerateAddressMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo> getMerkleTreeVoucherInfo(
        org.cypher.protos.contract.ShieldContract.OutputPointInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMerkleTreeVoucherInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.DecryptNotes> scanNoteByIvk(
        org.cypher.api.GrpcAPI.IvkDecryptParameters request) {
      return futureUnaryCall(
          getChannel().newCall(getScanNoteByIvkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.DecryptNotesMarked> scanAndMarkNoteByIvk(
        org.cypher.api.GrpcAPI.IvkDecryptAndMarkParameters request) {
      return futureUnaryCall(
          getChannel().newCall(getScanAndMarkNoteByIvkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.DecryptNotes> scanNoteByOvk(
        org.cypher.api.GrpcAPI.OvkDecryptParameters request) {
      return futureUnaryCall(
          getChannel().newCall(getScanNoteByOvkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.SpendResult> isSpend(
        org.cypher.api.GrpcAPI.NoteParameters request) {
      return futureUnaryCall(
          getChannel().newCall(getIsSpendMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.DecryptNotesTRC20> scanShieldedTRC20NotesByIvk(
        org.cypher.api.GrpcAPI.IvkDecryptTRC20Parameters request) {
      return futureUnaryCall(
          getChannel().newCall(getScanShieldedTRC20NotesByIvkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.DecryptNotesTRC20> scanShieldedTRC20NotesByOvk(
        org.cypher.api.GrpcAPI.OvkDecryptTRC20Parameters request) {
      return futureUnaryCall(
          getChannel().newCall(getScanShieldedTRC20NotesByOvkMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.NullifierResult> isShieldedTRC20ContractNoteSpent(
        org.cypher.api.GrpcAPI.NfTRC20Parameters request) {
      return futureUnaryCall(
          getChannel().newCall(getIsShieldedTRC20ContractNoteSpentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.NumberMessage> getRewardInfo(
        org.cypher.api.GrpcAPI.BytesMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRewardInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.NumberMessage> getBrokerageInfo(
        org.cypher.api.GrpcAPI.BytesMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBrokerageInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.TransactionExtention> triggerConstantContract(
        org.cypher.protos.contract.SmartContractOuterClass.TriggerSmartContract request) {
      return futureUnaryCall(
          getChannel().newCall(getTriggerConstantContractMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.TransactionInfoList> getTransactionInfoByBlockNum(
        org.cypher.api.GrpcAPI.NumberMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTransactionInfoByBlockNumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.Protocol.MarketOrder> getMarketOrderById(
        org.cypher.api.GrpcAPI.BytesMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMarketOrderByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.Protocol.MarketOrderList> getMarketOrderByAccount(
        org.cypher.api.GrpcAPI.BytesMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMarketOrderByAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.Protocol.MarketPriceList> getMarketPriceByPair(
        org.cypher.protos.Protocol.MarketOrderPair request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMarketPriceByPairMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.Protocol.MarketOrderList> getMarketOrderListByPair(
        org.cypher.protos.Protocol.MarketOrderPair request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMarketOrderListByPairMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.protos.Protocol.MarketOrderPairList> getMarketPairList(
        org.cypher.api.GrpcAPI.EmptyMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMarketPairListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.cypher.api.GrpcAPI.NumberMessage> getBurnCyp(
        org.cypher.api.GrpcAPI.EmptyMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBurnCypMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT = 0;
  private static final int METHODID_GET_ACCOUNT_BY_ID = 1;
  private static final int METHODID_LIST_WITNESSES = 2;
  private static final int METHODID_GET_ASSET_ISSUE_LIST = 3;
  private static final int METHODID_GET_PAGINATED_ASSET_ISSUE_LIST = 4;
  private static final int METHODID_GET_ASSET_ISSUE_BY_NAME = 5;
  private static final int METHODID_GET_ASSET_ISSUE_LIST_BY_NAME = 6;
  private static final int METHODID_GET_ASSET_ISSUE_BY_ID = 7;
  private static final int METHODID_GET_NOW_BLOCK = 8;
  private static final int METHODID_GET_NOW_BLOCK2 = 9;
  private static final int METHODID_GET_BLOCK_BY_NUM = 10;
  private static final int METHODID_GET_BLOCK_BY_NUM2 = 11;
  private static final int METHODID_GET_TRANSACTION_COUNT_BY_BLOCK_NUM = 12;
  private static final int METHODID_GET_DELEGATED_RESOURCE = 13;
  private static final int METHODID_GET_DELEGATED_RESOURCE_ACCOUNT_INDEX = 14;
  private static final int METHODID_GET_EXCHANGE_BY_ID = 15;
  private static final int METHODID_LIST_EXCHANGES = 16;
  private static final int METHODID_GET_TRANSACTION_BY_ID = 17;
  private static final int METHODID_GET_TRANSACTION_INFO_BY_ID = 18;
  private static final int METHODID_GENERATE_ADDRESS = 19;
  private static final int METHODID_GET_MERKLE_TREE_VOUCHER_INFO = 20;
  private static final int METHODID_SCAN_NOTE_BY_IVK = 21;
  private static final int METHODID_SCAN_AND_MARK_NOTE_BY_IVK = 22;
  private static final int METHODID_SCAN_NOTE_BY_OVK = 23;
  private static final int METHODID_IS_SPEND = 24;
  private static final int METHODID_SCAN_SHIELDED_TRC20NOTES_BY_IVK = 25;
  private static final int METHODID_SCAN_SHIELDED_TRC20NOTES_BY_OVK = 26;
  private static final int METHODID_IS_SHIELDED_TRC20CONTRACT_NOTE_SPENT = 27;
  private static final int METHODID_GET_REWARD_INFO = 28;
  private static final int METHODID_GET_BROKERAGE_INFO = 29;
  private static final int METHODID_TRIGGER_CONSTANT_CONTRACT = 30;
  private static final int METHODID_GET_TRANSACTION_INFO_BY_BLOCK_NUM = 31;
  private static final int METHODID_GET_MARKET_ORDER_BY_ID = 32;
  private static final int METHODID_GET_MARKET_ORDER_BY_ACCOUNT = 33;
  private static final int METHODID_GET_MARKET_PRICE_BY_PAIR = 34;
  private static final int METHODID_GET_MARKET_ORDER_LIST_BY_PAIR = 35;
  private static final int METHODID_GET_MARKET_PAIR_LIST = 36;
  private static final int METHODID_GET_BURN_CYP = 37;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WalletSolidityImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WalletSolidityImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ACCOUNT:
          serviceImpl.getAccount((org.cypher.protos.Protocol.Account) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Account>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT_BY_ID:
          serviceImpl.getAccountById((org.cypher.protos.Protocol.Account) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Account>) responseObserver);
          break;
        case METHODID_LIST_WITNESSES:
          serviceImpl.listWitnesses((org.cypher.api.GrpcAPI.EmptyMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.WitnessList>) responseObserver);
          break;
        case METHODID_GET_ASSET_ISSUE_LIST:
          serviceImpl.getAssetIssueList((org.cypher.api.GrpcAPI.EmptyMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.AssetIssueList>) responseObserver);
          break;
        case METHODID_GET_PAGINATED_ASSET_ISSUE_LIST:
          serviceImpl.getPaginatedAssetIssueList((org.cypher.api.GrpcAPI.PaginatedMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.AssetIssueList>) responseObserver);
          break;
        case METHODID_GET_ASSET_ISSUE_BY_NAME:
          serviceImpl.getAssetIssueByName((org.cypher.api.GrpcAPI.BytesMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract>) responseObserver);
          break;
        case METHODID_GET_ASSET_ISSUE_LIST_BY_NAME:
          serviceImpl.getAssetIssueListByName((org.cypher.api.GrpcAPI.BytesMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.AssetIssueList>) responseObserver);
          break;
        case METHODID_GET_ASSET_ISSUE_BY_ID:
          serviceImpl.getAssetIssueById((org.cypher.api.GrpcAPI.BytesMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.contract.AssetIssueContractOuterClass.AssetIssueContract>) responseObserver);
          break;
        case METHODID_GET_NOW_BLOCK:
          serviceImpl.getNowBlock((org.cypher.api.GrpcAPI.EmptyMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Block>) responseObserver);
          break;
        case METHODID_GET_NOW_BLOCK2:
          serviceImpl.getNowBlock2((org.cypher.api.GrpcAPI.EmptyMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.BlockExtention>) responseObserver);
          break;
        case METHODID_GET_BLOCK_BY_NUM:
          serviceImpl.getBlockByNum((org.cypher.api.GrpcAPI.NumberMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Block>) responseObserver);
          break;
        case METHODID_GET_BLOCK_BY_NUM2:
          serviceImpl.getBlockByNum2((org.cypher.api.GrpcAPI.NumberMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.BlockExtention>) responseObserver);
          break;
        case METHODID_GET_TRANSACTION_COUNT_BY_BLOCK_NUM:
          serviceImpl.getTransactionCountByBlockNum((org.cypher.api.GrpcAPI.NumberMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NumberMessage>) responseObserver);
          break;
        case METHODID_GET_DELEGATED_RESOURCE:
          serviceImpl.getDelegatedResource((org.cypher.api.GrpcAPI.DelegatedResourceMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DelegatedResourceList>) responseObserver);
          break;
        case METHODID_GET_DELEGATED_RESOURCE_ACCOUNT_INDEX:
          serviceImpl.getDelegatedResourceAccountIndex((org.cypher.api.GrpcAPI.BytesMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.DelegatedResourceAccountIndex>) responseObserver);
          break;
        case METHODID_GET_EXCHANGE_BY_ID:
          serviceImpl.getExchangeById((org.cypher.api.GrpcAPI.BytesMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Exchange>) responseObserver);
          break;
        case METHODID_LIST_EXCHANGES:
          serviceImpl.listExchanges((org.cypher.api.GrpcAPI.EmptyMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.ExchangeList>) responseObserver);
          break;
        case METHODID_GET_TRANSACTION_BY_ID:
          serviceImpl.getTransactionById((org.cypher.api.GrpcAPI.BytesMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.Transaction>) responseObserver);
          break;
        case METHODID_GET_TRANSACTION_INFO_BY_ID:
          serviceImpl.getTransactionInfoById((org.cypher.api.GrpcAPI.BytesMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.TransactionInfo>) responseObserver);
          break;
        case METHODID_GENERATE_ADDRESS:
          serviceImpl.generateAddress((org.cypher.api.GrpcAPI.EmptyMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.AddressPrKeyPairMessage>) responseObserver);
          break;
        case METHODID_GET_MERKLE_TREE_VOUCHER_INFO:
          serviceImpl.getMerkleTreeVoucherInfo((org.cypher.protos.contract.ShieldContract.OutputPointInfo) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.contract.ShieldContract.IncrementalMerkleVoucherInfo>) responseObserver);
          break;
        case METHODID_SCAN_NOTE_BY_IVK:
          serviceImpl.scanNoteByIvk((org.cypher.api.GrpcAPI.IvkDecryptParameters) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotes>) responseObserver);
          break;
        case METHODID_SCAN_AND_MARK_NOTE_BY_IVK:
          serviceImpl.scanAndMarkNoteByIvk((org.cypher.api.GrpcAPI.IvkDecryptAndMarkParameters) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotesMarked>) responseObserver);
          break;
        case METHODID_SCAN_NOTE_BY_OVK:
          serviceImpl.scanNoteByOvk((org.cypher.api.GrpcAPI.OvkDecryptParameters) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotes>) responseObserver);
          break;
        case METHODID_IS_SPEND:
          serviceImpl.isSpend((org.cypher.api.GrpcAPI.NoteParameters) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.SpendResult>) responseObserver);
          break;
        case METHODID_SCAN_SHIELDED_TRC20NOTES_BY_IVK:
          serviceImpl.scanShieldedTRC20NotesByIvk((org.cypher.api.GrpcAPI.IvkDecryptTRC20Parameters) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotesTRC20>) responseObserver);
          break;
        case METHODID_SCAN_SHIELDED_TRC20NOTES_BY_OVK:
          serviceImpl.scanShieldedTRC20NotesByOvk((org.cypher.api.GrpcAPI.OvkDecryptTRC20Parameters) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.DecryptNotesTRC20>) responseObserver);
          break;
        case METHODID_IS_SHIELDED_TRC20CONTRACT_NOTE_SPENT:
          serviceImpl.isShieldedTRC20ContractNoteSpent((org.cypher.api.GrpcAPI.NfTRC20Parameters) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NullifierResult>) responseObserver);
          break;
        case METHODID_GET_REWARD_INFO:
          serviceImpl.getRewardInfo((org.cypher.api.GrpcAPI.BytesMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NumberMessage>) responseObserver);
          break;
        case METHODID_GET_BROKERAGE_INFO:
          serviceImpl.getBrokerageInfo((org.cypher.api.GrpcAPI.BytesMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NumberMessage>) responseObserver);
          break;
        case METHODID_TRIGGER_CONSTANT_CONTRACT:
          serviceImpl.triggerConstantContract((org.cypher.protos.contract.SmartContractOuterClass.TriggerSmartContract) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.TransactionExtention>) responseObserver);
          break;
        case METHODID_GET_TRANSACTION_INFO_BY_BLOCK_NUM:
          serviceImpl.getTransactionInfoByBlockNum((org.cypher.api.GrpcAPI.NumberMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.TransactionInfoList>) responseObserver);
          break;
        case METHODID_GET_MARKET_ORDER_BY_ID:
          serviceImpl.getMarketOrderById((org.cypher.api.GrpcAPI.BytesMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketOrder>) responseObserver);
          break;
        case METHODID_GET_MARKET_ORDER_BY_ACCOUNT:
          serviceImpl.getMarketOrderByAccount((org.cypher.api.GrpcAPI.BytesMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketOrderList>) responseObserver);
          break;
        case METHODID_GET_MARKET_PRICE_BY_PAIR:
          serviceImpl.getMarketPriceByPair((org.cypher.protos.Protocol.MarketOrderPair) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketPriceList>) responseObserver);
          break;
        case METHODID_GET_MARKET_ORDER_LIST_BY_PAIR:
          serviceImpl.getMarketOrderListByPair((org.cypher.protos.Protocol.MarketOrderPair) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketOrderList>) responseObserver);
          break;
        case METHODID_GET_MARKET_PAIR_LIST:
          serviceImpl.getMarketPairList((org.cypher.api.GrpcAPI.EmptyMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.protos.Protocol.MarketOrderPairList>) responseObserver);
          break;
        case METHODID_GET_BURN_CYP:
          serviceImpl.getBurnCyp((org.cypher.api.GrpcAPI.EmptyMessage) request,
              (io.grpc.stub.StreamObserver<org.cypher.api.GrpcAPI.NumberMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class WalletSolidityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WalletSolidityBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.cypher.api.GrpcAPI.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WalletSolidity");
    }
  }

  private static final class WalletSolidityFileDescriptorSupplier
      extends WalletSolidityBaseDescriptorSupplier {
    WalletSolidityFileDescriptorSupplier() {}
  }

  private static final class WalletSolidityMethodDescriptorSupplier
      extends WalletSolidityBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WalletSolidityMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WalletSolidityGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WalletSolidityFileDescriptorSupplier())
              .addMethod(getGetAccountMethod())
              .addMethod(getGetAccountByIdMethod())
              .addMethod(getListWitnessesMethod())
              .addMethod(getGetAssetIssueListMethod())
              .addMethod(getGetPaginatedAssetIssueListMethod())
              .addMethod(getGetAssetIssueByNameMethod())
              .addMethod(getGetAssetIssueListByNameMethod())
              .addMethod(getGetAssetIssueByIdMethod())
              .addMethod(getGetNowBlockMethod())
              .addMethod(getGetNowBlock2Method())
              .addMethod(getGetBlockByNumMethod())
              .addMethod(getGetBlockByNum2Method())
              .addMethod(getGetTransactionCountByBlockNumMethod())
              .addMethod(getGetDelegatedResourceMethod())
              .addMethod(getGetDelegatedResourceAccountIndexMethod())
              .addMethod(getGetExchangeByIdMethod())
              .addMethod(getListExchangesMethod())
              .addMethod(getGetTransactionByIdMethod())
              .addMethod(getGetTransactionInfoByIdMethod())
              .addMethod(getGenerateAddressMethod())
              .addMethod(getGetMerkleTreeVoucherInfoMethod())
              .addMethod(getScanNoteByIvkMethod())
              .addMethod(getScanAndMarkNoteByIvkMethod())
              .addMethod(getScanNoteByOvkMethod())
              .addMethod(getIsSpendMethod())
              .addMethod(getScanShieldedTRC20NotesByIvkMethod())
              .addMethod(getScanShieldedTRC20NotesByOvkMethod())
              .addMethod(getIsShieldedTRC20ContractNoteSpentMethod())
              .addMethod(getGetRewardInfoMethod())
              .addMethod(getGetBrokerageInfoMethod())
              .addMethod(getTriggerConstantContractMethod())
              .addMethod(getGetTransactionInfoByBlockNumMethod())
              .addMethod(getGetMarketOrderByIdMethod())
              .addMethod(getGetMarketOrderByAccountMethod())
              .addMethod(getGetMarketPriceByPairMethod())
              .addMethod(getGetMarketOrderListByPairMethod())
              .addMethod(getGetMarketPairListMethod())
              .addMethod(getGetBurnCypMethod())
              .build();
        }
      }
    }
    return result;
  }
}
