# Store Management API

This project provides a RESTful API for managing store customers, orders, and sales-related data.

## Introduction

Store Management API is a Spring Boot application designed to facilitate the management of customers, orders, and sales data for a store. It leverages Spring MVC for RESTful endpoints and JPA/Hibernate for data persistence.

## Features

- Retrieve all registered customers: `GET http://localhost:8080/api/customers/registered`
- Retrieve orders by customer ID: `GET http://localhost:8080/api/customer-orders/customer/{customerId}`
- Retrieve orders for the current day: `GET http://localhost:8080/api/orders/current-day`
- Retrieve the total sale amount for the current day: `GET http://localhost:8080/api/sale/total-amount-current-day`
- Retrieve the day with the maximum sales within a time range: `GET http://localhost:8080/max-sale-day?startDate={startDate}&endDate={endDate}`

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 8 or later installed
- Apache Maven installed
- MySQL database installed and running

## Getting Started with Spring Tool Suite (STS)

To set up and run the Store Management API project in Spring Tool Suite (STS), follow these steps:

1. **Clone the Repository**:

    ```bash
    git clone https://github.com/ashraf4343/Store_management_API.git
    ```

2. **Import the Project into Spring Tool Suite**:

    - Open Spring Tool Suite.
    - Click on File > Import.
    - Choose Existing Maven Projects.
    - Navigate to the directory where you cloned the repository and select the project folder.
    - Click Finish to import the project.

3. **Configure Database Connection**:

    - Open the `application.properties` file located in the `src/main/resources` directory.
    - Update the following properties with your MySQL database configurations:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/store_shop
    spring.datasource.username=<your_username>
    spring.datasource.password=<your_password>
    ```

4. **Build and Run the Application**:

    - Right-click on the project in STS.
    - Choose Run As > Spring Boot App.

5. **Access the API**:

    Once the application is running, you can use any RESTful client (such as Postman) to interact with the API endpoints.

## Dependencies

This project uses the following dependencies managed via Apache Maven:

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- MySQL Connector Java

You can find the dependencies listed in the `pom.xml` file.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add feature'`).
5. Push to the branch (`git push origin feature`).
6. Create a new Pull Request.
