ARG COMPILE_IMAGE="maven:3.8.4-openjdk-17-slim"

FROM ${COMPILE_IMAGE} as maven_build

WORKDIR /app

COPY . /app

RUN mvn clean install -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/redis-0.0.1-SNAPSHOT.jar"]