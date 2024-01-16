# Maven

## Running tests
```shell
./mvnw clean test
```

## Generating Allure report
**NB! [On Windows this will leak the report serving processes](https://github.com/allure-framework/allure-java/issues/836)**

```shell
./mvnw allure:serve
```

# Gradle

## Running tests
```shell
./gradlew clean test
```

## Generating Allure report
**NB! Allure needs to be available from the commandline**

```shell
allure serve build/allure-results
```

## Autotest TODO
1. Run tests in Docker
2. Generate report from test results
    * either serve the report
    * or generate an HTML
3. Open report in a browser
4. Diff with the expected image:
   * either Applitools Eyes
   * or expected images in repository (keep in mind dynamic parts)
5. GitHub Actions pipeline