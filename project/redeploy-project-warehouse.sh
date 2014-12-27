#!/bin/bash

mvn clean install -P dev -pl project-core tomcat7:redeploy
