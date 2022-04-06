# Small Linux distro with openjdk11 to run a Java application
FROM fabric8/java-alpine-openjdk11-jre
# I'm the maintainer
MAINTAINER gfarkas.com
# Copy the builded application into the container
COPY target/Customer-relationship-management-API-0.0.1-SNAPSHOT.jar crm.jar
# Set the entrypoint of our application
ENTRYPOINT ["java","-jar","/crm.jar"]