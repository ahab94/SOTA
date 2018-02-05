# iota.lib.scala

[![Build Status](https://travis-ci.org/ahab94/iota.lib.scala.svg?branch=master)](https://travis-ci.org/ahab94/iota.lib.scala)
[![codecov](https://codecov.io/gh/ahab94/iota.lib.scala/branch/master/graph/badge.svg)](https://codecov.io/gh/ahab94/iota.lib.scala)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

This is the Scala library for the [IOTA Core APIs](https://iota.readme.io/reference). It's a simple scala wrapper around IOTA and allows to connect to a local or a remote IOTA node easily using it's Scala API interface.

The Scala wrapper around IOTA is designed to be thread-safe and kept as simple as possible in order to be easily maintainable, accordingly with the ongoing natural evolution of IOTA’s API. It provides the flexability to choose between API backends like `OkHTTP`, `Akka HTTP` and other native `STTP` syncronous and asyncronous API Backends depending on the concurrency needs of the Application. This unlocks the world of scala for IOTA Core.

It should be noted that the Scala Library as it stands right now is an early release. There might be some unexpected results.
Please let us know [here](https://github.com/ahab94/iota.lib.scala/issues).

# Getting Started

After you've successfully installed the library dependency, it is fairly easy to get started by simply creating a new IotaClient instance.

```SCALA
  val iotaClient = new IotaClient() //This will hit http://localhost:14625
```
Connecting to your device's local node with the default settings and fetching the node info is quite easy...
```SCALA
  val iotaCore = new IotaClient(IotaClientConfig(protocol = "http", host = "localhost", port = 14265))
  val nodeInfo = iotaCore.getNodeInfo
```
