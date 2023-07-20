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