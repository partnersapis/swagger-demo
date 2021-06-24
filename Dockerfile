FROM java:8
VOLUME /tmp
EXPOSE 9002
ADD target/Item-0.0.1-SNAPSHOT.jar item-0.0.1.jar
ENTRYPOINT ["java","-jar","item-0.0.1.jar"]