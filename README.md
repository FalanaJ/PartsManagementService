# Project: PartsManagementService

"Simply microservice for parts management"
Microservice that stores information about the number of parts in the warehouse. 

## Contents

1. [Description](#description)
2. [Functions](#functions)
3. [Technology](#technology)
4. [Instalation](#instalation)
5. [Configuration](#configuration)
6. [Tests](#tests)
7. [Licence](#licence)

## Description

The microservice was written in Java and Spring Boot.  The microservice will display a REST API that allows you to: add parts to the warehouse, retrieve parts from the warehouse, and change the number of parts.  

The warehouse status is saved to the Postgres database.

The microservice logs the most important information. Logging is configured exclusively to a file. 

The microservice contains unit tests to check its functionality.

## Functions

- add parts to the warehouse
- delete parts from the warehouse
- change the number of parts

## Technology

List of technologies used in the project:
- Java 17
- Spring Boot
- PostgreSQL / H2 Database
- Mockito
- Lombok

## Instalation

Instructions on how to install and run the project locally.

1. **Clone repo**:
   ```bash
   git clone https://github.com/[username]/PartsManagementService.git
   
## Licence

 MIT License
Copyright (c) 2025 FalanaJ
