# Spring Cloud Config Server and Client Example

This project demonstrates the usage of Spring Cloud Config Server and Client to manage configurations centrally and distribute them to multiple client applications using Spring Cloud Bus for communication and dynamic configuration refresh.

## Overview

The project consists of two Spring Boot applications:

1. **Producer Config Server**: This application acts as the central configuration server. It serves configurations to client applications and communicates changes using Spring Cloud Bus.
   
2. **Consumer 1 (Client)**: This application fetches its configurations from the Producer Config Server. It listens for configuration changes and refreshes its context dynamically without requiring a restart.

## Technologies Used

- Java 17
- Spring Boot 2.7.2
- Spring Cloud 2021.0.3
- Maven

## Prerequisites

- Java JDK 17 or later installed
- Maven installed
- RabbitMQ server running locally (for Spring Cloud Bus communication)

## Getting Started

### Run RabbitMQ Server:

Make sure RabbitMQ server is running locally. If not, you can download and install it from [RabbitMQ website](https://www.rabbitmq.com/download.html) or use Docker.

### Run Producer Config Server:

```bash
cd producer-config-server
mvn spring-boot:run
```

### Run Consumer 1 (Client):

```bash
cd ../consumer_1
mvn spring-boot:run
```

### Access Endpoints:

- Producer Config Server: [http://localhost:8888](http://localhost:8888)
- Consumer 1 (Client): [http://localhost:8001](http://localhost:8001)

## Configuration

### Producer Config Server

- **application.yml**: Configures the server port and sets up Spring Cloud Bus destination for communication.
- **bootstrap.yml**: Configures the native profile for serving configurations from the classpath.
- **consumer.yaml**: Example configuration file served by the server.

### Consumer 1 (Client)

- **application.yml**: Configures the server port and sets up Spring Cloud Bus destination for communication.
- **bootstrap.yml**: Imports configurations from the Config Server.
- **ConfigurationsStatusViewer.java**: Component that listens for changes and logs the updated configuration.

## Refreshing Client Configuration

To refresh the configuration of the client, you can use the Spring Boot Actuator endpoint provided by Spring Cloud Bus. After making changes to the configurations on the Config Server, perform the following steps:

1. Make sure the Producer Config Server and Consumer 1 (Client) applications are running.

2. Send a POST request to the `/actuator/bus-refresh` endpoint of the Consumer 1 application:

```bash
curl -X POST http://localhost:8001/actuator/bus-refresh
```

This will trigger a refresh of the client's configuration. You should see the updated configuration reflected in the logs of the Consumer 1 application.

## Contributing

Contributions are welcome! If you find any issues or want to contribute enhancements, feel free to open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
