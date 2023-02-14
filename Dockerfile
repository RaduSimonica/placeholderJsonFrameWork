# syntax=docker/dockerfile:1

FROM maven:3.8.7-amazoncorretto-19
COPY . /tests
WORKDIR /tests
