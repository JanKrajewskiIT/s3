#!/bin/bash
mvn liquibase:update -DwithTestData=true -P dev
