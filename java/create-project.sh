#!/bin/bash
mvn archetype:generate \
	-DgroupId=org.ksautter \
	-DartifactId=student-engagement-app \
	-DarchetypeArtifactId=maven-archetype-quickstart \
	-DinteractiveMode=false
