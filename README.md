## Customer Microservice

Spring Boot Service to enable customers manage their profile

## Overview  

Basic Customer operations to manage profile for web and mobile use.
Start your server as an simple spring boot application  
Change default port value in application.properties

## fantastic-customer
Customer APIs to create, View, Update and Delete

You can view the api documentation in swagger-ui by pointing to
http://localhost:8080/Sazi/customer/1.0/swagger-ui.html

Use the below key to Autorize
Key: jwt-key
Value: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2F6aS5vcmcvY2xhaW1zL3JvbGUiOlsiSW50ZXJuYWwvc3Vic2NyaWJlciIsIkludGVybmFsL2NyZWF0b3IiLCJJbnRlcm5hbC9wdWJsaXNoZXIiLCJJbnRlcm5hbC9ldmVyeW9uZSIsImFkbWluIl0sImh0dHA6Ly9zYXppLm9yZy9jbGFpbXMvc3Vic2NyaWJlciI6ImFkbWluIiwic3ViIjoiMTIzNDU2Nzg5MCIsIm5hbWUiOiJBcnVsIEhhcnJ5IiwiaWF0IjoxNTE2MjM5MDIyfQ.Q1rjD5sAXy10jxiV2wIk0jkWjSHSHHaF9O3IPMl_XgQ

## Steps to run

Find sources in - https://github.com/harryarul/fantastic-customer

To Run Locally

git clone https://github.com/harryarul/fantastic-customer.git
cd fantastic-customer
mvn eclipse:eclipse
mvn clean install
Import project in Eclipse
Run Spring Boot Application

## Expected Deliverables

1. API Contract Definition - customer-swagger.yaml
2. High level Integration design document - CustomerMicroservice.pdf
3. Spring Security Implemented
	The service contains the role(s) that it allows in the applicaiton.properties
	From the incoming request header the JWT token id decoded to find and match the role.
4. Used Spring boot Microservice framework
5. Code checked in at - https://github.com/harryarul/fantastic-customer
6. This file.
	
 

