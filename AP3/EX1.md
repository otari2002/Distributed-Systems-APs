# Kafka Setup and Testing 

This guide walks you through the process of installing and testing Kafka manually on your local machine. We'll start by downloading Kafka, setting up Zookeeper and the Kafka server, and then testing the setup using Kafka's console producer and consumer.

---

## Download Kafka

1. Visit the [Apache Kafka Downloads page](https://kafka.apache.org/downloads).
2. Download the latest stable version of Kafka.
   
   _Add screenshot of the download process here._

## Launch Zookeeper

1. Extract the Kafka package.

2. Navigate to the Kafka directory:
   ```bash
   cd kafka_x.x.x

3. Start the Zookeeper service:
    ```bash
    bin/zookeeper-server-start.sh config/zookeeper.properties

## Launch Kafka-server
1. Open a new terminal window.

2. Start the Kafka broker:
    ```bash
    bin/kafka-server-start.sh config/server.properties

## Test with Kafka-console-producer and kafka-console-consumer
### Kafka Console Producer:
1. Open a new terminal window.

2. Create a Kafka topic:

3. Start the producer:

### Kafka Console Consumer:
1. Open another terminal window.

2. Start the consumer:


