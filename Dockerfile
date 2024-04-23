FROM maven:3.8.7-eclipse-temurin-19-alpine

ADD . /java-springboot
WORKDIR /java-springboot

RUN ls -l

RUN mvn clean install -DskipTests

FROM openjdk:17-alpine

COPY --from=0 "/java-springboot/target/taskmanager-*.jar" app.jar

EXPOSE 8080
# Fire up our Spring Boot app by default
CMD [ "sh", "-c", "java -jar /app.jar" ]