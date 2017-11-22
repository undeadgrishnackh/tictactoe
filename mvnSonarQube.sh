#!/usr/bin/env bash
mvn clean install test sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://localhost:9000/sonar -Dsonar.host.url=http://localhost:9000
