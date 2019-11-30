#!/bin/bash
sudo cp /home/ksautter/src/sea/java/student-engagement-app/target/student-engagement-app-1.0-SNAPSHOT.war /var/lib/tomcat9/webapps
sudo tail -f "/var/log/tomcat9/catalina.$(date +%F).log"
