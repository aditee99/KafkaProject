# Kafka Microservice Project

This project demonstrates a microservice architecture using Apache Kafka with Spring Apache Kafka for seamless communication between services. The system consists of two services:

1. **DeliveryBoy Service**: Publishes location updates to a Kafka topic.
2. **EndUser Service**: Consumes location updates from the Kafka topic.

---

## Project Structure

### DeliveryBoy Service

This service is responsible for publishing location updates to a Kafka topic. It includes the following components:

- **KafkaConfig**: Configures Kafka producer settings.
- **KafkaService**: Handles the business logic for sending messages to the Kafka topic.
- **KafkaController**: Exposes REST APIs for external systems to publish location updates.

**Endpoint:**
```http
POST http://localhost:8080/location/update
```
The endpoint accepts location data and publishes it to the Kafka topic.

### EndUser Service

This service consumes the location updates from the Kafka topic. It listens for messages and processes them accordingly.

---

## Setup Instructions

### Prerequisites

1. Java 11 or higher
2. Apache Kafka
3. Maven or Gradle

### Steps to Run

1. **Start Kafka**:
   - Ensure Kafka is installed and running on your system.
   - Start the Kafka broker and Zookeeper services.

2. **Build and Run DeliveryBoy Service**:
   - Navigate to the `deliveryboy` service directory.
   - Build the project:
     ```bash
     mvn clean install
     ```
   - Run the service:
     ```bash
     java -jar target/deliveryboy-0.0.1-SNAPSHOT.jar
     ```

3. **Build and Run EndUser Service**:
   - Navigate to the `enduser` service directory.
   - Build the project:
     ```bash
     mvn clean install
     ```
   - Run the service:
     ```bash
     java -jar target/enduser-0.0.1-SNAPSHOT.jar
     ```

4. **Test the Setup**:
   - Use a REST client (e.g., Postman) to send a POST request to the DeliveryBoy service:
     ```http
     POST http://localhost:8080/location/update
     Content-Type: application/json
     ```
   - Verify that the EndUser service logs the received location updates.

---

## Kafka Configuration

### Kafka Topics
- **Topic Name**: `location-update-topic`

### DeliveryBoy Service Configuration
- **Producer Properties**: Configured in the `KafkaConfig` class.
  ```properties
  bootstrap.servers=localhost:9092
  key.serializer=org.apache.kafka.common.serialization.StringSerializer
  value.serializer=org.apache.kafka.common.serialization.StringSerializer
  ```

### EndUser Service Configuration
- **Consumer Properties**: Configured in the `KafkaConfig` class.
  ```properties
  bootstrap.servers=localhost:9092
  group.id=group-1
  key.deserializer=org.apache.kafka.common.serialization.StringDeserializer
  value.deserializer=org.apache.kafka.common.serialization.StringDeserializer
  ```

---

## Technology Stack

- **Programming Language**: Java
- **Framework**: Spring Boot, Spring Kafka
- **Messaging Platform**: Apache Kafka
- **Build Tool**: Maven

---

## Future Enhancements

1. Add a database to persist location updates.
2. Implement error handling and retry mechanisms for Kafka consumers.
3. Introduce additional services to process and analyze location data.

---

## Acknowledgement
Youtube: Learn Code With Durgesh
- YouTube: [Learn Code With Durgesh](https://www.youtube.com/watch?v=ei6fK9StzMM)

## ScreenShots

Consumer Service:

![ConsumerService](https://github.com/user-attachments/assets/8a5f3cd1-6bc4-49c8-8444-d255bc172e00)

Consumer in cmd:

![ConsumerCmd](https://github.com/user-attachments/assets/f1cac942-e762-4f04-a57d-ee7f5acce711)

Postman Response:

![PostmanResponse](https://github.com/user-attachments/assets/a52cebc3-03ff-4075-8ee1-21441f85e751)

