
Deployment of Microservice using Spring Boot and Cloud Foundry:

This project aims to deploy a microservice using Spring Boot and Pivotal Cloud Foundry with a MySQL instance created. The database used is a student marks database with student, subject and marks details.

Prerequisites:

->Eclipse/STS
->Latest JDK
->Postman (for testing)
->Cloud Foundry CLI interface (CF)
->XAMPP/ MySQL (to test locally)
->Pivotal CF 

Steps to create project :

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

Steps for Cloud Foundry installation(windows):

i) Download the CF CLI installer for Windows.
ii) Unpack the zip file and double click the executable
iii)When prompted click Install (default settings)
iv) Test installation by typing cf in cmd

Setup PWS Console:

i) Sign up for an account  on PivotalCF and complete the required registration and authentication.
ii) Log in to your account and go to cloud console.. Follow the given steps to get an org and space. 

Steps to deploy to cloud:

->Create executable jar/war file:
    i) On eclipse, add the <packaging> jar </packaging> in the pom.xml file
     ( In the case of war packaging, we add the <packaging> war </packaging> tag and also the maven war plugin shown below:
     		<plugin>
			<artifactId>maven-war-plugin</artifactId>
			<version>2.4</version>
			<configuration>
				<warSourceDirectory>WebContent</warSourceDirectory>
				<failOnMissingWebXml>false </failOnMissingWebXml>
			</configuration>
		</plugin>
	)
	
ii) Run as mvn clean package. (On eclipse, right click on project->run as -> Maven build-> goals: clean package). The jar/war file will be stored in the target folder of the project.

iii) Install the CF CLI as shown above

iv) On the cloud console, go to marketplace and search for Mysql and select the plan as per requirement. 

v) In the maven project, create a manifest.yml file and include the following:
   


vi) Login to the CF CLI through cmd using your credentials. Enter the folder of you project. Use the command as shown 
     "cf push <app-name> -p target/<name of executable jar with extension>

v) Check the cloud console and get the required url of the project. Test 


