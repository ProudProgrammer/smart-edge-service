# Smart Platform - Edge Service
Orchestrator service for Smart Platform
### Spring profiles
```
For production: -Dspring.profiles.active=prod
For development in local: default, so no need to set profile
```
### Maven profiles
```
Without tests: mvn clean install -Pfast
With docker image creation: mvn clean install -Pdocker
Without tests and with docker image creation: mvn clean install -Pfast,docker
```
### Dependencies
- https://github.com/ProudProgrammer/smart-logging-filter
- https://github.com/ProudProgrammer/smart-lottery-service-client
### Build
```
Manually:
$ git clone https://github.com/ProudProgrammer/smart-logging-filter.git
$ mvn clean install
$ git clone https://github.com/ProudProgrammer/smart-lottery-service-client.git
$ mvn clean install
$ git clone https://github.com/ProudProgrammer/smart-edge-service.git
$ mvn clean install

With start script:
$ git clone https://github.com/ProudProgrammer/smart-tools.git
$ ./start.sh

See readme: https://github.com/ProudProgrammer/smart-tools/blob/master/README.md
Use helper of start script: $ ./start.sh -h
```
### Modular architecture of Edge Service
![Modular Architecture](https://raw.githubusercontent.com/ProudProgrammer/smart-tools/master/plantuml/modular-architecture-edge-service.png)
### System architecture of Smart Platform
Applied software development techniques:
- Microservice Architecture
- API Gateway Pattern

![System Architecture](https://raw.githubusercontent.com/ProudProgrammer/smart-tools/master/plantuml/system-architecture.png)
