# Server_SwaggUi
ServerIndexing is a project created over Stack springBoot and Spring data MongoDB. The projects provides with multiple Rest API created by 
Spring Boot Web Pack. The project provides all the basic CRUD operations to mongoDB database with user accessible REST APIs. It also provides
additional features like auto increment and muliple addition, deletion, updation over the database with one request.It also provides an
Customized Exception Response for some operations which could be modified as per the need. We add Swagg UI which is an excellent tool
for documenting of APIs call and provides a very clear and precise documentation for the project.

### Primary Goals:
1. Create a REST APIs documentation with Swagg UI in Spring Boot
## Installation
- The [reference documentation](https://editor.swagger.io/) includes detailed installation instructions as well as a comprehensive getting started guide for Swagg UI.
- The [reference documentation](https://github.com/swagger-api/swagger-codegen/wiki/server-stub-generator-howto) includes detailed instructions for how you can implement Swagg UI for your Spring Boot.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
1. Git clone the reposity with command or fork it to you repository and git clone to that repository:
```
  git clone https://github.com/vardhmanhundia/ServerIndexing_springBot.git
```
2. Open the installed file on your favourite IDE. I used [Intellij IDEA](https://www.jetbrains.com/idea/download/)
3. Install MongoDB on your laptop with [mongoDB installation](https://docs.mongodb.com/manual/tutorial) according to your Operating System.
4. Create a Directory at a place and add empty data directory inside the Directory You Created.
5. Open the terminal or CMD(windows) and open the root of the created directory.
6. Initialize the mongoDB database with this folder which will initiate the mongoDB database at default address 127.0.0.1
```
  mongod --dbpath=data --bind_ip 127.0.0.1
```
7. Create a database name **ServerDB** using mongoDB cli or [MongoDB Compass Community](https://www.mongodb.com/products/compass)
8. Run the Spring Boot Server and you would get output as below

![Server Run Output](https://github.com/vardhmanhundia/SwaggUI_ServerIndexing/blob/master/images/serverRunning.PNG)

9. You can check the rest Apis corresponding to the server with the new Swagg UI documentation which provides a clear idea about all the
APIs in the project over the links `http://localhost:9090/v2/api-docs` for basic documentation and `http://localhost:9090/swagger-ui.html#/`
for Swaggi UI post.You can see a sample image below.

![SwaggUI Output](https://github.com/vardhmanhundia/SwaggUI_ServerIndexing/blob/master/images/swaggUI.jpg)

## Further Versions
Please CheckOut the updated versions for this project
### Previous Versions
- [SpringBoot_MongoDB](https://github.com/vardhmanhundia/SpringBootMongodb_serverIndexing)
### Updated Versions
- [Server Index Dockerized](https://github.com/vardhmanhundia/ServerIndexing_Dockerized)
- [Server_Index React App](https://github.com/vardhmanhundia/serverIndex_ReactApplication)
