FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift
#FROM registry.access.redhat.com/rhel7.3
MAINTAINER Shankar Govindarajan <shgovind@redhat.com>
LABEL description="This is a sample rest app"

#This can be set both at the build time and at the run time.
ARG ENV=local
ENV ENV="${ENV}"

EXPOSE 8080

# The below command creates a dir to simulate the clems_docs mount
RUN mkdir -p ./var/clems_docs

#The below command creates a dir to simulate the tomcat classpath
RUN mkdir -p ./var/conf
RUN chmod -R 777 ./var/conf/

#Copy all the dfc property files (from the local folder which inturn can be in bitbucker or NFS) to the clems_docs directory inside the container
COPY ./*.properties.* ./var/clems_docs/

COPY ./target/hellotomcat.jar app.jar

#Shell scripts that  copy the env specific property file and then starts the application
COPY app.sh init.sh

#Change the entry point from this to the one below ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
ENTRYPOINT ["./init.sh"]
