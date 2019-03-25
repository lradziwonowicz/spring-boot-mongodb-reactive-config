# spring-boot-mongodb-reactive-config
A sample Spring Boot 2.1.3 app which uses a custom configuration for reactive mongodb repository.

The app uses own `AbstractReactiveMongoConfiguration` implementation to use custom configuration for Mongo URI and database name. It works and it connects to mongo on port `27018` but at the same time it uses probably auto configuration and tries to connect on default port `27017`.

I already tried to use `@EnableReactiveMongoRepositories` or to exclude `MongoAutoConfiguration.class` and `MongoDataAutoConfiguration.class`



```
2019-03-25 16:01:17.453  INFO 25728 --- [           main] org.mongodb.driver.cluster               : Cluster created with settings {hosts=[localhost:27018], mode=SINGLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms', maxWaitQueueSize=500}
2019-03-25 16:01:17.498  INFO 25728 --- [localhost:27018] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:1, serverValue:40}] to localhost:27018
2019-03-25 16:01:17.501  INFO 25728 --- [localhost:27018] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=localhost:27018, type=STANDALONE, state=CONNECTED, ok=true, version=ServerVersion{versionList=[4, 0, 5]}, minWireVersion=0, maxWireVersion=7, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=2134309}
2019-03-25 16:01:17.962  INFO 25728 --- [           main] org.mongodb.driver.cluster               : Cluster created with settings {hosts=[localhost:27017], mode=SINGLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms', maxWaitQueueSize=500}
2019-03-25 16:01:17.968  INFO 25728 --- [localhost:27017] org.mongodb.driver.cluster               : Exception in monitor thread while connecting to server localhost:27017

com.mongodb.MongoSocketOpenException: Exception opening socket
	at com.mongodb.internal.connection.SocketStream.open(SocketStream.java:67) ~[mongodb-driver-core-3.8.2.jar:na]
	at com.mongodb.internal.connection.InternalStreamConnection.open(InternalStreamConnection.java:126) ~[mongodb-driver-core-3.8.2.jar:na]
	at com.mongodb.internal.connection.DefaultServerMonitor$ServerMonitorRunnable.run(DefaultServerMonitor.java:117) ~[mongodb-driver-core-3.8.2.jar:na]
	at java.base/java.lang.Thread.run(Thread.java:834) ~[na:na]
Caused by: java.net.ConnectException: Connection refused (Connection refused)
	at java.base/java.net.PlainSocketImpl.socketConnect(Native Method) ~[na:na]
	at java.base/java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:399) ~[na:na]
	at java.base/java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:242) ~[na:na]
	at java.base/java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:224) ~[na:na]
	at java.base/java.net.SocksSocketImpl.connect(SocksSocketImpl.java:403) ~[na:na]
	at java.base/java.net.Socket.connect(Socket.java:591) ~[na:na]
	at com.mongodb.internal.connection.SocketStreamHelper.initialize(SocketStreamHelper.java:64) ~[mongodb-driver-core-3.8.2.jar:na]
	at com.mongodb.internal.connection.SocketStream.open(SocketStream.java:62) ~[mongodb-driver-core-3.8.2.jar:na]
	... 3 common frames omitted

```