FROM openjdk
WORKDIR usr/lib

ENV MONGO_DATABASE="customer_service"
ENV MONGO_URL="mongodb://localhost:27017/customer_service"

ADD ./target/customerService-0.0.1-SNAPSHOT.jar /usr/lib/customerService-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","customerService-0.0.1-SNAPSHOT.jar"]