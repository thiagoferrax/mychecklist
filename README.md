# mychecklist
[![Build Status](https://app.travis-ci.com/thiagoferrax/mychecklist.svg?branch=master)](https://app.travis-ci.com/thiagoferrax/mychecklist)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.company%3Amy-checklist&metric=alert_status)](https://sonarcloud.io/dashboard/index/com.company%3Amy-checklist)
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

![classDiagram](https://user-images.githubusercontent.com/43149895/132135162-8321cdcf-03f0-4810-9b61-f949539d23e7.png)

## License

MIT © [thiagoferrax](https://github.com/thiagoferrax).
