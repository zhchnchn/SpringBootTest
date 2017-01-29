#!/bin/bash

export MAVEN_OPTS='-Xdebug -Xnoagent -Djava.compiler=NONE  -Xrunjdwp:transport=dt_socket,address=8001,server=y,suspend=n'

mvn clean spring-boot:run
