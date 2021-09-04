# mychecklist
[![Build Status](https://app.travis-ci.com/thiagoferrax/mychecklist.svg?branch=master)](https://app.travis-ci.com/thiagoferrax/mychecklist)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.company%3Amy-checklist&metric=alert_status)]
<a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-blue.svg"></a>

## About

Rethinking the agile-checklist and the agileDMAIC method.

## User Stories

1. As a member of a team, I want to create a checklist, so that I could share with my team and start using it to evaluate a process.

## Architecture overview

#### Project structure
```
└───my-checklist
    ├───.mvn
    │   └───wrapper
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───com
    │   │   │       └───company
    │   │   │           └───mychecklist
    │   │   │               ├───builders
    │   │   │               ├───configurations
    │   │   │               ├───models
    │   │   │               ├───repositories
    │   │   │               ├───resources
    │   │   │               │   └───exceptions
    │   │   │               └───services
    │   │   │                   └───exceptions
    │   │   └───resources
    │   └───test
    │       └───java
    │           └───com
    │               └───company
    │                   └───mychecklist
    │                       ├───resources
    │                       └───services
```
#### Class diagram (Model - Entities)

![mychecklist](https://user-images.githubusercontent.com/43149895/130370398-4ea0d9b9-8ee7-4a44-a15b-29400e0ad6cd.png)

## License

MIT © [thiagoferrax](https://github.com/thiagoferrax).
