# CLAUDE.md

## Project Overview

Template framework for automated API and UI testing using Groovy + Spock + RestAssured + Allure.
Tests run against JSONPlaceholder API (`https://jsonplaceholder.typicode.com`).

## Tech Stack

- **Language**: Groovy 4.x on Java 25
- **Test Framework**: Spock 2.3
- **API Testing**: RestAssured 5.x
- **UI Testing**: Selenide 7.14
- **Reporting**: Allure 2.33
- **Build**: Both Gradle (9.4.1) and Maven (3.9.3) via wrappers

## Build & Test Commands

```bash
# Gradle
./gradlew clean test
./gradlew allureServe          # open Allure report

# Maven
./mvnw clean test
./mvnw allure:serve            # open Allure report
```

## Project Structure

```
src/main/groovy/
  BeforeAll.groovy       # Global setup: RestAssured filters, Selenide config
  Spec.groovy            # Abstract base class (extends Specification), holds base URL
  Steps.groovy           # API step methods with @Step annotations
  Requirement.groovy     # Custom annotation combining @Story + @TmsLink

src/test/groovy/
  UsersTest.groovy       # API tests for /users endpoints
  PostsTest.groovy       # API tests for /posts endpoints
  E2ETest.groovy         # UI tests using Selenide
  src/test/resources/allure.properties  # Allure link patterns
```

## Code Style

All code must follow the project's code style defined in `.idea/codeStyles/` and `.editorconfig`, based on [spock-ij-code-style](https://github.com/iriiiina/spock-ij-code-style). Key rules:
- Indentation: tabs (size 2)
- Continuation indent: 4 spaces
- Max line length: 120 characters
- Braces: always required
- Trailing whitespace: trimmed
- Final newline: not inserted (per .editorconfig)

## Code Conventions

- All test classes extend `Spec` and use `*Test` suffix
- Spock BDD blocks: `given:` / `when:` / `then:` / `where:`
- Data-driven tests use Spock's `where:` table syntax
- RestAssured fluent chain: `given()...when()...then()`
- Allure annotations: `@Epic`, `@Feature`, `@Story`, `@Step`, `@Issue`, `@Link`
- Step methods live in `Steps.groovy` as static methods
- Groovy idioms: implicit returns, string interpolation, closure syntax

## CI

GitHub Actions (`.github/workflows/run-tests.yml`): runs on PRs to `master`, parallel Gradle + Maven jobs, JDK 25 Temurin + Chrome, reports via `dorny/test-reporter`.

## Key Patterns

- `BeforeAll` is instantiated once as a static field in `Spec` — configures RestAssured logging filters and Selenide browser settings (1920x1080, 10s timeout)
- `Spec.url` holds the base API URL used across all tests
- Custom `@Requirement` annotation composes `@Story` + `@TmsLink` for traceability
