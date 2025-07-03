---

# API Automation Framework - FastAPI

## Overview

This project implements a comprehensive **API automation framework** to validate all critical functionalities of a RESTful API. The framework is built with **Java 11, RestAssured, TestNG, Cucumber**, and advanced reporting using **Allure Reports**. It supports scalable, maintainable, and reusable test automation for CRUD operations, request chaining, and integrates smoothly into CI/CD pipelines like Jenkins.

---

## Table of Contents

* [Features](#features)
* [Project Structure](#project-structure)
* [Tools & Technologies](#tools--technologies)
* [Setup & Configuration](#setup--configuration)
* [How to Run Tests](#how-to-run-tests)
* [Reporting](#reporting)
* [Testing Strategy](#testing-strategy)
* [Challenges & Solutions](#challenges--solutions)
* [CI/CD Integration](#cicd-integration)
* [Future Improvements](#future-improvements)
* [Contributing](#contributing)


---

## Features

* Complete CRUD API test coverage (Create, Read, Update, Delete)
* Positive and negative test scenarios
* Request chaining: using output of one API as input to another
* Environment-specific configuration via `config.properties`
* Integration with Cucumber for BDD-style tests
* TestNG for flexible test execution
* Advanced HTML reports powered by Allure
* Ready-to-use Jenkins pipeline (Jenkinsfile)

---

## Project Structure

```
/api-automation-FastAPI
├── src
│   ├── main
│   │   └── java/com/jktech/models/           # POJOs for API payloads
│   └── test
│       ├── java/com/jktech/tests/
│       │   ├── hooks/                        # Cucumber hooks
│       │   ├── runners/                      # Cucumber TestNG runners
│       │   ├── stepdefinitions/              # Step definitions
│       │   └── utils/                        # Config readers, utilities
│       └── resources/features/               # Gherkin feature files
├── config.properties                         # API endpoint and env config
├── pom.xml                                   # Maven build config
├── Jenkinsfile                               # CI/CD pipeline script
├── target/allure-results                     # Allure raw test results
├── target/allure-report                      # Generated Allure HTML report
└── README.md                                 # Project documentation


---

## Tools & Technologies

| Tool/Library   | Purpose                                          |
| -------------- | ------------------------------------------------ |
| Java           | Programming language                             |
| RestAssured    | API testing library                              |
| TestNG         | Test orchestration                               |
| Cucumber       | BDD feature files + steps                        |
| Allure Reports | Advanced reporting                               |
| Maven          | Dependency and build management                  |
| Jenkins        | Continuous integration / deployment              |
| Git            | Source control                                   |

---

## Setup & Configuration

1. **Prerequisites:**

   * Java 11+ 
   * Maven 3.x
   * Allure CLI installed (for report generation)
   * Jenkins (optional, for CI)

2. **Clone the Repository:**

   ```bash
   git clone https://github.com/PandiAutomation/api-automation-FastAPI
   cd api-automation-FastAPI
   ```

3. **Configure API Endpoint:**
   Update the `config.properties` file:

   ```properties
   base.url=https://api.yourdomain.com
   environment=dev
   ```

4. **Install Dependencies:**

   ```bash
   mvn clean install
   ```

---

## How to Run Tests

* **Run all tests via Maven:**

  ```bash
  mvn test
  ```

* **Run tests using TestNG suite:**

  ```bash
  mvn test -DsuiteXmlFile=testng.xml
  ```

* **Run tests via IDE:**
  Run TestRunner.java as TestNG test 
  

---

## Reporting

* **Allure Reports:**
* After execution:
  allure generate target/allure-results --clean -o target/allure-report
  allure serve target/allure-results
  The report includes:

  * Passed/Failed/Skipped tests
  * Timeline, graph, and category views
  * Suite and step-level insights

## Testing Strategy

* **Comprehensive CRUD coverage**

* **Positive + negative test cases**

* **Request chaining for realistic workflows**

* **Configurable environments (dev, qa, prod):**
  
* **Status code, header, and payload assertions**
  
* **Modular step definitions and POJOs**
---

## Challenges & Solutions

| Challenge                                   | Solution                                                                    |
| ------------------------------------------- | --------------------------------------------------------------------------- |
| Dynamic request chaining                    | Shared context + utilities                                                  |
| Advanced reporting                          | Allure integration + CI publishing                                          |
| Multi-environment testing                   | config.properties based switching                                           |
| CI/CD integration                           | Jenkinsfile with build, test, and report stages                             |

---

## CI/CD Integration

* The Jenkinsfile handles:

  * Git checkout
  * Maven build + test
  * Allure report generation
  * Artifact archiving
   Example:
pipeline {
  agent any
  tools { maven 'Maven_3'; jdk 'JDK11' }
  stages {
    stage('Build') { steps { sh 'mvn clean install -DskipTests' } }
    stage('Test') { steps { sh 'mvn test' } }
    stage('Allure Report') {
      steps {
        sh 'allure generate target/allure-results --clean -o target/allure-report'
        archiveArtifacts artifacts: 'target/allure-report/**'
      }
    }
  }
}

---

## Future Improvements

* Parallel test execution
* API contract validation with Pact
* AData-driven testing (CSV / JSON)
* Slack/Email notifications

---

## Contributing

PRs and issues are welcome!

---
