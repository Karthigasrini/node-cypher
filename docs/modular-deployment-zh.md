# 模块化后的 java-cypher 部署方式

模块化后，命令行下的程序启动方式将不再使用 `java -jar FullNode.jar` 的方式启动，而是使用脚本的方式启动，本文内容基于 develop 分支。

*原有的启动方式依然保留，但即将废弃*。

## 下载

```
git clone git@github.com:cypherprotocol/java-cypher.git
```

## 编译

进入项目目录执行：
```
./gradlew build
```
编译成功后在 java-cypher/build/distributions 目录下生成 zip 压缩包：java-cypher-1.0.0.zip

## 解压

解压 java-cypher-1.0.0.zip
```
cd java-cypher/build/distributions
unzip -o java-cypher-1.0.0.zip
```
解压后的 java-cypher 目录中有 bin 和 lib 两个文件夹，bin 目录中存放的是可执行脚本，lib 下存放程序依赖的 jar 包。

## 启动

不同的 os 对应不同脚本，windows 即为 bat 文件，以 linux 系统为例启动 java-cypher：
```
# 默认配置文件启动
java-cypher-1.0.0/bin/FullNode
# 自定义配置文件启动, java-cypher/framework/build/resources 目录下有默认的配置文件提供选择
java-cypher-1.0.0/bin/FullNode -c config.conf
# SR 模式启动，需要加上：-w
java-cypher-1.0.0/bin/FullNode -c config.conf -w
```

## jvm参数配置

java-cypher 支持对 jvm 参数进行配置，配置文件为 bin 目录下的 java-cypher.vmoptions 文件。
```
# demo
-XX:+UseConcMarkSweepGC
-XX:+PrintGCDetails
-Xloggc:./gc.log
-XX:+PrintGCDateStamps
-XX:+CMSParallelRemarkEnabled
-XX:ReservedCodeCacheSize=256m
-XX:+CMSScavengeBeforeRemark
```