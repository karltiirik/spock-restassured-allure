# Spock+RestAssured+Allure

[![Tests](https://github.com/iriiiina/spock-restassured-allure/actions/workflows/run-tests.yml/badge.svg)](https://github.com/iriiiina/spock-restassured-allure/actions/workflows/run-tests.yml)
![Java 25](https://img.shields.io/badge/Java-25-orange)
![Groovy](https://img.shields.io/badge/Groovy-4.x-blue)
![Spock](https://img.shields.io/badge/Spock-2.3-green)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-compatible-purple)](https://www.jetbrains.com/idea/)
[![Claude](https://img.shields.io/badge/Claude-compatible-D97706?logo=claude)](CLAUDE.md)

Template framework for API and UI automated testing. It already contains all the necessary dependencies, so you can start using this stack right away.

## Technical Stack

* Language: [Groovy](https://groovy-lang.org/)
* Testing Framework: [Spock](https://spockframework.org/)
* API Testing Library: [RestAssured](https://rest-assured.io/)
* UI Testing Library: [Selenide](https://selenide.org/)
* Report: [Allure](https://allurereport.org/)
* Build Tool: [Maven](https://maven.apache.org/) or [Gradle](https://gradle.org/)

## Prerequisites

1. This project is using Java 25, so make sure to use correct Java version both locally and in IDE.
   - Setup Java version in Intellij IDEA: File -> Project Structure... -> Project Settings -> Project -> SDK -> choose 25.

2. Choose one of the build tools that you want to use and delete the other one. It doesn't affect the functionality, but it's just more clean and reliable approach to leave only functionality that is used in the project.
    - If you want to use Maven, then delete Gradle files and mentions:
        - delete `gradle/wrapper`
        - delete `build.gradle.kts`
        - delete `gradlew`
        - delete `gradlew.bat`
        - delete `settings.gradle.kts`
        - delete "Run Tests With Gradle" and "Generate Local Report With Gradle" sections in `README.md`
        - delete "# Gradle" rows in `.gitignore`
    - If you choose to use Gradle, then delete all Maven mentions:
        - delete `.mvn/wrapper`
        - delete `mvnw`
        - delete `mvnw.cmd`
        - delete "Run Tests With Maven" and "Generate Local Report With Maven" sections in `README.md`
        - delete "# Maven" rows in `.gitignore`

## Running Tests

You can use either Maven or Gradle to run the tests in this project.

### Run Tests With Maven

```shell
./mvnw clean test
```

### Run Tests With Gradle

```shell
./gradlew clean test
```

## Allure Report

### Generate Local Report With Maven

Note: On Windows, running this command may cause the report serving processes to leak. For more details, check [this issue](https://github.com/allure-framework/allure-java/issues/836).

```shell
./mvnw allure:serve
```

### Generate Local Report With Gradle

```shell
./gradlew allureServe
```

## Project Structure

```
src/main/groovy/
  BeforeAll.groovy       # Global setup: RestAssured filters, Selenide config
  Spec.groovy            # Abstract base class for all tests
  Steps.groovy           # Reusable API step methods with @Step annotations
  Requirement.groovy     # Custom annotation combining @Story + @TmsLink

src/test/groovy/
  UsersTest.groovy       # API tests for /users endpoints
  PostsTest.groovy       # API tests for /posts endpoints
  E2ETest.groovy         # End-to-end UI tests using Selenide
```

## Code Style

This project uses a shared IntelliJ IDEA code style from [spock-ij-code-style](https://github.com/iriiiina/spock-ij-code-style). The configuration is stored in `.idea/codeStyles/` and `.editorconfig`. IntelliJ IDEA will pick it up automatically.

## Claude Code Readiness

This project includes a `CLAUDE.md` file with project context for [Claude Code](https://docs.anthropic.com/en/docs/claude-code). Claude-specific local configuration files are excluded from version control via `.gitignore`.
