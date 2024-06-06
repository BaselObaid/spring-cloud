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

1. **Clone the Repository**:

   ```bash
   git clone <repository_url>
