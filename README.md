# Running tests
```shell
./mvnw clean test
```

# Generating Allure report
**NB! [On Windows this will leak the report serving processes](https://github.com/allure-framework/allure-java/issues/836)**

```shell
./mvnw allure:serve
```