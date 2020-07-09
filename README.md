[![Build Status](https://travis-ci.org/undeadgrishnackh/tictactoe.svg?branch=master)](https://travis-ci.org/undeadgrishnackh/tictactoe)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=undeadgrishnackh_tictactoe&metric=alert_status)](https://sonarcloud.io/dashboard?id=undeadgrishnackh_tictactoe)
[![Coverage Status][coverageimg]][coveragelink]
[![CodeScene System Mastery](https://codescene.io/projects/8578/status-badges/system-mastery)](https://codescene.io/projects/8578)
[![Known Vulnerabilities](https://snyk.io/test/github/undeadgrishnackh/minesweeper/badge.svg)](https://snyk.io/test/github/undeadgrishnackh/tictactoe/)
[![BCH compliance](https://bettercodehub.com/edge/badge/undeadgrishnackh/tictactoe?branch=master)](https://bettercodehub.com/)

![TIC TAC TOE][tictactoeimg]

# Test Drive Development Training with a Tic Tac Toe Kata

This repository is designed to show to a **Test Driven Development** classroom how to use a Kata to spike and improve on: 
* Agile and Scrum
* eXtreme Programming (Test Driven Development, Pair Programming, Code review, etc)
* coverage obsession VS real code quality 
* devops practices and technologies
This repo is focused on the development part as enabler to show to the audience that a modern software development is based on: SCRUM , XP, DevOps, not because I need to say it to save my devops job, but because they are all related and linked together! DevOps is impossible without XP; in that case will lose the CI! Scrum is quite useless in estimate very complex and scaled project without the XP practices to take under control the technical debt with the continuous refactoring!   

## Whats next...
[This](https://github.com/undeadgrishnackh/tictactoeInfrastructure) repository is the part 2 of the training and is designed to describe the devops practice of the infrastructure as code. It provides everything is necessary to install the full devops infrastructure in local plus all the details about it. The repository is also part of the separate devops training about Infrastructure as Code and TDD on containers, cloud and server-less architecture.

### Agile Product Design
First of all the kata is designed to show to a development team how to manage a product backlog in full compliance of the SCRUM's role and responsibilities matrix. I designed, as product owner, a [Trello board](https://trello.com/b/UP1IMBzH/tictactoe-kata) to replicate, as best as I can in Trello, a typical XP team's wall:
* Discovery and Spike: Space dedicated to team and PO to discover on business and technical side what is necessary to improve the details of a user story to become DoR (Definition of Ready) compliant;
* Product Backlog + DoR Compliant: US in refinement phase until the team will be able to move to DoR Compliant;
* Sprint Backlog (TODO-WIP-ToBeTested-Tested-DONE): space where the classroom move the user stories during the workshop
* Customer Candidate Release: what the PO wanna show to the customer at the end of the workshop.

_Addendum_: In the directory **Agile** I uploaded some User Stories in PDF format to use in the classroom to:
* simulate a real board attaching them on the wall;
* use it in a pair programming session to show how Driver and Navigator must play their roles. 

### Project - IDE, test framework, remote pair programming, etc.
The kata is provided in a maven project, developed with IntelliJ using JUnit5, JACoCo, Spring. The pom is tuned to resolve some issue Junit5/IntelliJ/Spring. 

### Remote Pair Programming
The project is also provided with the setup necessary to simulate a remote pair programming session via [floobits platform](https://floobits.com/michele.br/tictactoe).

The project is developed to show two different devops approaches:
### DEVOPS ENVIRONMENTS
* E2E devops team
* Pure SaaS Cloud

#### E2E devops team
In that scenario the team manage the code, build (CB), test(CI), deploy/delivery (CD) on a IaC (Infrastructure as Code) platform that owned and maintained by them. [This](https://github.com/undeadgrishnackh/tictactoeInfrastructure) repository, as said above, is the jump start to create all what you need.

#### Pure SaaS Cloud
This environment instead is based on a pure SaaS architecture where the team delegate the project automation, CB, CI, CD in TravisCI: 
* defined via a .travis.yml pipeline on this [Automation Server](https://travis-ci.org/undeadgrishnackh/tictactoe)
* that after the build and CI analyze with [SonarCloud](https://sonarcloud.io/dashboard?id=com.undeadgrishnackh%3Atictactoe) the coverage KPI
* and with [CoverALLs](https://coveralls.io/github/undeadgrishnackh/tictactoe?branch=master) update the gitHub badges with the code "quality"
* at the end the _deployment_ is provided on [Heroku](https://damp-inlet-50606.herokuapp.com/areYouAlive)

# ConclusionS:
At the end of the training I wanna provide to the classroom the advice that to be a very [Software Craftsman](https://www.amazon.co.uk/dp/0134052501) isn't enough to master all the 12 XP practices with the devops automation obsession. Isn't enough to cover 95% more on the code base. Isn't enough, because to be a very Software Craftsman we need to be obsessed from the developers skills and the relative code base quality. 
To follow this path we need to understand that SCRUM, XP and DevOps are all linked together and that the code base has to be analyze all the time like it's a [crime scene](https://www.amazon.co.uk/Your-Code-Crime-Scene-Bottlenecks/dp/1680500384/ref=sr_1_1?s=books&ie=UTF8&qid=1521322425&sr=1-1&keywords=code+crime+scene). With the continuous refactoring we need to identify where our code could be better in readability, simplicity, decoupling, etc. so that our code quality will be good enough to keep a real sustainable pace that will make happy our customer! 
For this reason I'm used to close my classroom with this metaphor:
"If with our code we're creating a powerful motorbike, the code coverage provide us the maximum speed of it. Reach 99% coverage doesn't mean that if we'll have an accident the motorbike will be with enough quality to protect us to survive."
My tic tac toe for this reason is intentionally designed to be like a [TT island motorbike](https://www.youtube.com/watch?v=0xr1m9m8Puk); 95%+ coverage but without the necessary quality to say that it's "safety". I injected, with some tricks avoiding the refactoring and the code review, near 50% RedHotSpot ;)

![HotSpot](https://raw.githubusercontent.com/undeadgrishnackh/tictactoe/master/pics/hotspot.png)
but the coverage and the tech debt in sonarqube are super good

![Coverage](https://raw.githubusercontent.com/undeadgrishnackh/tictactoe/master/pics/coverage.png)
For this reason, as last brain effort before the salute, we have to save ["7 minutes and 26 seconds"](https://vimeo.com/79106557) to understand why without this triple link all our agile maturity is nothing.

#### My thanks
Ad the end of this repository, I wanna share with you my thanks to: 
* [Sandro Mancuso](https://twitter.com/sandromancuso?lang=en) to provide me the know-how to understand that my code obsession for the kata wasn't only for my dependency to the martial art, but was and is the natural way as an individual has to train to become from adept to master in every work, even more in software development where the technology is in continue evolution.
* [J. B. Rainsberger](https://twitter.com/jbrains?lang=en) for the astonishing video "7 minutes and 26 seconds" about XP and the "Fundamental Theorem of Agile Software Development" that I use all the time to close all my AGILE/XP/TDD training. And BTW we need to meet again in Bratislava for a good beer and to discuss that devops without XP is a bullshit ;) 
* [Adam Tornhill](https://twitter.com/adamtornhill?lang=en) to provide me the best books and relative tool to show to my classrooms that quality is more the only the coverage KPI! Yes the TT island motorbike video also help, but at the end it isn't able to show to the people the red hot spot :D 

If you liked this repo and the format of the training and you wanna improve your team practices in Agile, XP and DevOps, I'm available for consultancy. Ping me on my [twitter](https://twitter.com/MicheleBrissoni).

[coverageimg]: https://coveralls.io/repos/github/undeadgrishnackh/tictactoe/badge.svg?branch=master
[coveragelink]: https://coveralls.io/github/undeadgrishnackh/tictactoe?branch=master
[tictactoeimg]: http://is4.mzstatic.com/image/thumb/Purple111/v4/4f/70/d4/4f70d4cd-d270-f4ce-028d-17648632197b/source/175x175bb.jpg
