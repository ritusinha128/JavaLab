
Deployment of Microservice using Spring Boot and Cloud Foundry:

This project aims to deploy a microservice using Spring Boot and Pivotal Cloud Foundry with a MySQL instance created. The database used is a student marks database with student, subject and marks details.

Prerequisites:

->Eclipse/STS
->Latest JDK
->Postman (for testing)
->Cloud Foundry CLI interface (CF)
->XAMPP/ MySQL (to test locally)
->Pivotal CF 

Steps:

->If you do not have Eclipse, install STS, else install STS tools from Eclipse Marketplace
-> Create a new simple Maven Project and add the following dependencies

  <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-rest</artifactId>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-annotations</artifactId>
			</dependency>

->Create the application.properties file under src/main/resources and add the MySQL and JPA settings

spring.datasource.driver = com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root

->Create the required controller,service, model and dao classes or clone this project and test it locally by running the XAMPP MySQL on localhost

Steps to deploy to cloud:

->Create executable jar/war file:
    i) On eclipse, add the <packaging> 



