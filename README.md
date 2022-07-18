# Birthday Greeting Kata
- [Birthday Greeting Kata](#birthday-greeting-kata)
  - [Environment](#environment)
  - [Preparing MongoDB via Docker (Optional)](#preparing-mongodb-via-docker-optional)
  - [Running the Application](#running-the-application)
  - [Building the Application](#building-the-application)
  - [Invoke the Greeting API](#invoke-the-greeting-api)

## Environment
- JDK 11
- MongoDB 5
- Docker (Optional)

## Preparing MongoDB via Docker (Optional)
```
docker run --name userdb-mongo \
-e MONGO_INITDB_ROOT_USERNAME=root \
-e MONGO_INITDB_ROOT_PASSWORD=root \
-e MONGO_INITDB_DATABASE=userdb \
-p 27017:27017 \
-v /$(pwd)/db/init.js:/docker-entrypoint-initdb.d/init.js \
-d mongo:5
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

