[![Build Status][travisimg]][travislink]
[![Quality Gate][qualityimg]][qualitylink]
[![Coverage Status][coverageimg]][coveragelink]

![TIC TAC TOE][tictactoeimg]

# Test Drive Development Training with a Tic Tac Toe Kata

This repository is designed to show to a **Test Driven Development** classroom, how to use a simple Kata to spike on: Agile, TDD and the latest cloud and dev ops practices and technologies.

## Agile Product Design
The kata is designed with a dedicated product backlog on a [Trello board](https://trello.com/b/UP1IMBzH/tictactoe-kata). The board is designed to replicate, as best is possible in Trello, a typical walls setup in a XP team:
* Product Owner Discovery wall: Design Board
* DevTeam wall: TechDebt and Ne Technology Discovery Board
* Product Backlog: US in refinement phanse / US in D.o.R. Compliant
* Sprint Backlog: from WIP -> Done columns
* Customer showcase: Candidate Release

_Addendum_: In the directory **Agile** I downloaded some User Stories in PDF format to use in the classroom to simulate a real board.

## Project - IDE, test framework, remote pair programming, etc.
The kata is provided in a maven project, developed with IntelliJ using JUnit5, JACoCo, etc. The pom is tuned to resolve some issue Junit5/IntelliJ. The project is provided also with the setup to work in remote pair programming with the [floobits platform](https://floobits.com/michele.br/tictactoe) .

## Project running environments
At the beginning I started this kata to drive the TDD classroom during the training and to show the base of the CI and devops trough a some docker container created and linked via a compose. Then I realized that some beginners lose the focus from the training playing with docker, postgresql, sonarqube, elk, etc. For this reason then I improved all the application devops stuff on the cloud.
In the repository I saved all the two options: LOCAL-docker & Cloud.

## LOCAL ENVIRONMENT
The project use a devops environment made over Docker into dedicated containers by a docker composition: Jenkins, SonarQube, Postgresql, ELK.
Docker containers are created by a docker-compose, and the images are managed by Kitematic and the IntelliJ Docker integration plugin.
Into the Docekr directory there's the docker-compose.yml file located into the Docker directory. To build the whole infrastructure:
> cd Docker; docker-compose build

At the end of the docker-compose build process, the local devops infrastructure will be:
* _Automation Server_: Jenkins
* _Code Analyzer_: SonarQube with dedicated Postgresql database


## CLOUD ENV
The cloud environment instead is based on a compound of free SaaS provider:
* _Automation Server_: TarvisCI
* _Code Analyzer_: SonarCloud and CoverALLs
* _Deployment_: Heroku

[travisimg]: https://travis-ci.org/undeadgrishnackh/tictactoe.svg?branch=master
[travislink]: https://travis-ci.org/undeadgrishnackh/tictactoe
[qualityimg]: https://sonarcloud.io/api/badges/gate?key=com.undeadgrishnackh:tictactoe
[qualitylink]: https://sonarcloud.io/dashboard/index/com.undeadgrishnackh:tictactoe
[coverageimg]: https://coveralls.io/repos/github/undeadgrishnackh/tictactoe/badge.svg?branch=master
[coveragelink]: https://coveralls.io/github/undeadgrishnackh/tictactoe?branch=master
[tictactoeimg]: http://is4.mzstatic.com/image/thumb/Purple111/v4/4f/70/d4/4f70d4cd-d270-f4ce-028d-17648632197b/source/175x175bb.jpg