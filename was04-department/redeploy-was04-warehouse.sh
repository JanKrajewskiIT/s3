#!/bin/bash

mvn clean install -P dev,warehouse -pl was04-department-core tomcat7:redeploy
