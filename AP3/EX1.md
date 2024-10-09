# Kafka Setup and Testing 

This guide walks you through the process of installing and testing Kafka manually on your local machine. We'll start by downloading Kafka, setting up Zookeeper and the Kafka server, and then testing the setup using Kafka's console producer and consumer.

---

## Download Kafka

1. Visit the [Apache Kafka Downloads page](https://kafka.apache.org/downloads).
2. Download the latest stable version of Kafka.

   <img width="465" alt="Capture d’écran 2024-10-07 095148" src="https://github.com/user-attachments/assets/113466ee-56ff-44cb-92a9-68f951857ddb">


## Launch Zookeeper

1. Extract the Kafka package.

2. Navigate to the Kafka directory:
   ```bash
   cd kafka_x.x.x

3. Start the Zookeeper service:
    ```bash
    bin/zookeeper-server-start.sh config/zookeeper.properties

<img width="610" alt="Capture d’écran 2024-10-07 093731" src="https://github.com/user-attachments/assets/7ab5ff77-8e1a-4ae4-ac01-6c750f5fe4dc">

## Launch Kafka-server
1. Open a new terminal window.

2. Start the Kafka broker:
    ```bash
    bin/kafka-server-start.sh config/server.properties

<img width="536" alt="Capture d’écran 2024-10-07 093924" src="https://github.com/user-attachments/assets/7964c35a-69af-43cb-9053-7c6265f84e90">

## Test with Kafka-console-producer and kafka-console-consumer
### Kafka Console Producer:
1. Open a new terminal window.

2. Create a Kafka topic:

3. Start the producer:

<img width="792" alt="Capture d’écran 2024-10-07 094328" src="https://github.com/user-attachments/assets/91cd1483-0b6b-4f79-84e7-b0f04fd8953a">

### Kafka Console Consumer:
1. Open another terminal window.

2. Start the consumer:

<img width="791" alt="Capture d’écran 2024-10-07 094712" src="https://github.com/user-attachments/assets/b7821b08-5c72-4001-b6e4-b8119eee57ed">

