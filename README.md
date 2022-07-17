# Birthday Greeting Kata

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

