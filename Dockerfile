FROM eclipse-temurin:11-jdk-focal AS builder

COPY . /canoe
WORKDIR /canoe
RUN chmod +x mvnw
RUN chmod +x mvn/wrapper/maven-wrapper.jar
RUN chmod +x mvn/wrapper/maven-wrapper.properties
# Build the server on run
RUN ./mvnw clean install

# ===========================================================================================================
# 1. Bin stages
# ===========================================================================================================
FROM adoptopenjdk/openjdk11:alpine-jre

# Make app folders
RUN mkdir -p /app/libs

# Copy the compiled output to new image
COPY --from=builder /canoe/build/libs/azkeyvault-0.0.1-SNAPSHOT.jar /app/libs
RUN adduser -D canoe -u 10000
USER canoe
ENTRYPOINT [ "java", "-jar", "/app/libs/azkeyvault-0.0.1-SNAPSHOT.jar"]