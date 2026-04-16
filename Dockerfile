FROM openjdk:17-jdk-slim
WORKDIR /app
COPY src /app/src
RUN javac -d /app/out $(find /app/src -name "*.java")
EXPOSE 8080
CMD ["java", "-cp", "/app/out", "com.example.order.OrderServiceTestRunner"]
