# CQRS Pattern Implementation in Mobile Banking 💳🏦

![CQRS Pattern](https://img.shields.io/badge/CQRS-Pattern-blue)
![Java](https://img.shields.io/badge/Java-17%2B-red)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![Elasticsearch](https://img.shields.io/badge/Elasticsearch-8.x-brightgreen)
![Lombok](https://img.shields.io/badge/Lombok-1.x-orange)

## 📚 Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Real-Life Use Case](#real-life-use-case)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
    - [API Endpoints](#api-endpoints)
- [Code Structure](#code-structure)
- [Logging and Observability](#logging-and-observability)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## 📝 Introduction

Welcome to the **CQRS Pattern Implementation in Mobile Banking** project! This repository demonstrates how to effectively implement the **Command Query Responsibility Segregation (CQRS) Pattern** in a mobile banking application using **Java**, **Spring Boot**, **Lombok**, **SLF4J**, and **Elasticsearch**. The CQRS pattern separates read and write operations to optimize each side independently, enhancing scalability, performance, and maintainability.

## 🚀 Features

- **Separation of Concerns:** Distinct models for commands (writes) and queries (reads).
- **High Performance:** Optimized read operations using Elasticsearch for fast data retrieval.
- **Scalability:** Independent scaling of read and write services based on demand.
- **Asynchronous Processing:** Utilizes Spring Events and asynchronous methods for efficient data synchronization.
- **Enhanced Logging:** Comprehensive logging with SLF4J and Lombok for better observability.
- **Real-Life Scenario:** Simulates a mobile banking app where users can perform transactions and view account information.

## 🛠️ Technologies Used

- **Java 11+**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Data Elasticsearch**
- **Lombok**
- **SLF4J**
- **H2 Database** (for write operations)
- **Elasticsearch** (for read operations)
- **Maven/Gradle** (for build management)

## 🌐 Real-Life Use Case

Imagine a mobile banking app where customers can:

- **Perform Transactions:** Transfer funds between accounts.
- **View Account Information:** Check account balances and transaction histories.

In such an application, **read** and **write** operations have different performance and scaling requirements. The **CQRS Pattern** addresses these needs by separating these operations, allowing each to be optimized independently.

## 🏗️ Architecture


1. **Command Side (Write Model):**
    - **Handles:** Transaction creation and updating account balances.
    - **Data Store:** H2 Database (or any relational database).
    - **Transaction Service:** Processes transactions, ensures data integrity, and publishes events.

2. **Query Side (Read Model):**
    - **Handles:** Retrieving account information and transaction histories.
    - **Data Store:** Elasticsearch, optimized for fast queries and search operations.
    - **Transaction Document Service:** Updates the read model in response to events.

3. **Event Handling:**
    - **Spring Events:** Facilitate communication between command and query sides.
    - **Asynchronous Processing:** Ensures non-blocking operations for better performance.

## 📥 Getting Started

### Prerequisites

- **Java 17+** installed on your machine.
- **Maven** or **Gradle** for build management.
- **Elasticsearch** installed and running. [Download Elasticsearch](https://www.elastic.co/downloads/elasticsearch)
- **Git** installed to clone the repository.

### Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/saadzarook/cqrs.git
   cd saga-pattern-spring
