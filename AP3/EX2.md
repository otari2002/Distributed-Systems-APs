# Kafka Setup and Testing with Confluent

This guide walks you through the process of setting up Kafka on your local machine using Confluent. We'll start by launching the Kafka broker, creating a topic, and testing the setup using Kafka's console producer and consumer.

---

## Prerequisites

Make sure you have installed the [Confluent CLI](https://docs.confluent.io/confluent-cli/current/install.html) and configured it on your local machine.

---

## Start the Kafka Broker

1. Start Kafka using the Confluent CLI:
   ```bash
   confluent local kafka start
This runs both the broker and controller in a single process.

<img width="591" alt="Capture d’écran 2024-10-07 095148" src="https://github.com/user-attachments/assets/1811d3ad-e01d-4bf7-a0e6-e5df01019318">

<img width="597" alt="Capture d’écran 2024-10-07 104421" src="https://github.com/user-attachments/assets/863c01bb-0baf-4dff-9098-5c16f82b23d9">

## Create a Topic and write messages
1. Create a topic called quickstart : 
    ```bash
    confluent local kafka topic create quickstart
2. Write messages to the quickstart topic using the Confluent CLI :
    ```bash
    confluent local kafka topic produce quickstart
<img width="757" alt="Capture d’écran 2024-10-07 110555" src="https://github.com/user-attachments/assets/9c1d08af-7570-437f-9830-50022a5a7444">

## Stop the Kafka broker
Once you’ve finished you can shut down Kafka:
<img width="647" alt="Capture d’écran 2024-10-07 110646" src="https://github.com/user-attachments/assets/1e2127ac-8d6c-4bba-82a5-edbc9959ea12">