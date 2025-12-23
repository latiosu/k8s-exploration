FROM eclipse-temurin:25-jre-alpine-3.23

RUN apk add entr

WORKDIR /app
ADD dependencies/ ./
ADD spring-boot-loader/ ./
ADD snapshot-dependencies/ ./
ADD application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]