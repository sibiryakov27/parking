# Parking
Test project for [sigma](https://sigma-it.ru/) company.
##  🚀 Getting Started
This section provides a high-level quick start guide
### Prerequisites
- [Java](https://www.oracle.com/java/technologies/) 11
- [Maven](https://maven.apache.org/) 3.8.6
- [H2](http://www.h2database.com/html/main.html) 2.1.214 or higher
- [IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/)

**Step 1. Configure DB**

This application uses in-memory database H2, so you shouldn't do anything specific to configure DB. All settings are 
settled in application properties. Also you can find SQL scripts at resources/db/migration folder.

**Step 2. Build app**

>mvn clean install

**Step 3. Run**

_Idea_:
- create SpringBoot configuration
- run

### Testing
You can use swagger (http://localhost:8080/swagger-ui/index.html) or postman for testing.