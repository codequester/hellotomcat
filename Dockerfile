FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift
#FROM registry.access.redhat.com/rhel7.3
MAINTAINER Shankar Govindarajan <shgovind@redhat.com>
LABEL description="This is a sample rest app"
EXPOSE 8080
COPY ./target/hellotomcat.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
