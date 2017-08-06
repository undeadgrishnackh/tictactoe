#!/usr/bin/env bash
mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://localhost:32770/sonar -Dsonar.host.url=http://localhost:32770