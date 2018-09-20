#!/bin/sh

#Copy the env specific file and rename into a generic one
cp ./var/clems_docs/dfc.properties.${ENV} ./var/conf/dfc.properties

#Run the application
java -Djava.security.egd=file:/dev/./urandom -jar app.jar