#!/bin/bash

mvn clean install -P dev,warehouse -pl project-core tomcat7:redeploy
