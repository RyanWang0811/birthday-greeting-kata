# Birthday Greeting Kata
- [Birthday Greeting Kata](#birthday-greeting-kata)
  - [Environment](#environment)
  - [Preparing PostgreSQL via Docker (Optional)](#preparing-postgresql-via-docker-optional)
  - [Running the Application](#running-the-application)
  - [Building the Application](#building-the-application)
  - [Invoke the Greeting API](#invoke-the-greeting-api)

## Environment
- JDK 11
- PostgreSQL 13
- Docker (Optional)

## Preparing PostgreSQL via Docker (Optional)
```
docker run --name userdb \
-e POSTGRES_USER=user \
-e POSTGRES_PASSWORD=userdbpwd \
-e POSTGRES_DB=userdb \
-p 5432:5432 \
-v /$(pwd)/db/init.sql:/docker-entrypoint-initdb.d/init.sql \
-d postgres:13
```

## Running the Application
```
mvn spring-boot:run
```

## Building the Application
```
mvn clean package
```

## Invoke the Greeting API
```
curl 'localhost:8080/greeting'
```

