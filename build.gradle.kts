group = "com.nortal"
version = "1.0"
description = "spock-restassured-allure"

plugins {
    groovy
    id("io.qameta.allure") version "2.11.2"
}

repositories {
    mavenCentral()
}
dependencies {
    implementation("org.apache.groovy:groovy-all:4.0.15")
    implementation("io.qameta.allure:allure-spock2:2.24.0")
    implementation("io.qameta.allure:allure-rest-assured:2.24.0")
    implementation("org.spockframework:spock-core:2.3-groovy-4.0")
    implementation("io.rest-assured:rest-assured:5.3.2")
    implementation("com.codeborne:selenide:6.19.0")
    implementation("io.qameta.allure:allure-selenide:2.24.0")
}

allure {
    version.set("2.24.0")
    adapter {
        // AspectJ Weaver is fine, but make sure the latest available version is used
        aspectjWeaver.set(true)
        aspectjVersion.set("1.9.19")

        // in order to disable dependencySubstitution (spi-off classifier)
        autoconfigureListeners.set(true)

        // disable auto-configuring dependencies
        autoconfigure.set(false)
        afterEvaluate {
            frameworks.forEach { adapter -> adapter.enabled.set(false) }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}