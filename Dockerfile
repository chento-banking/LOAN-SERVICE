FROM openjdk:22-slim as build

MAINTAINER chento_bank

COPY ./build/libs/loan-0.0.1.jar loan-0.0.1.jar

ENTRYPOINT ["java","-jar", "/loan-0.0.1.jar"]
