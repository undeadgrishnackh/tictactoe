## com.undeadgrishnakch.kata.TicTacToe
----
# TDD classroom example
This repository is designed to show to a classroom how to spike Agile, TDD and the latest technologies trough a simple kata about the famous Tic Tac Toe game.

## Agile Product Design
The kata is designed with a specific product backlog on a public trello board, where I've setup the kanban wall to be a join of the normal Scrum/XP boards:
* Product Owner Discovery/Design Board
* TechDebt Discovery Board
* Product Backlog / Storied in D.o.R. Compliant / Sprint Backlog
* Sprints WIP -> Done columns
* Customer Candidate Release Features Board

The Trello board link is:
https://trello.com/b/UP1IMBzH/tictactoe-kata

## TDD Environment
The kata is developed with IntelliJ via JUnit5. The code is analyzed by the Code Analyzer and FindBugs.

## DevOps Environment
The Devops environment is builded over Docker and into dedicated containers Jenkins, SonqrQube, etc.
Docker Images are managed by Kitematic and the IntelliJ Docker plugin.

### Jenkins
Jenkins is provided as CaaS by this docker image: https://hub.docker.com/_/jenkins/
The container is mounted on a local folder volume and the docker 8080 port is bind locally on 32778.
Jenkins is configured with JDK 1.8, Maven 3.5 automatically installed from Oracle and Apache in the global configuration tool.
 
### SonarQube
SonarQube is provided as CaaS byt this docker image: https://hub.docker.com/_/sonarqube/
The docker container port 9000 is bind locally on 32770.
