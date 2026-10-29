group = "com.nortal"
version = "1.0"
description = "spock-restassured-allure"

plugins {
    groovy
    id("io.qameta.allure") version "3.0.2"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

repositories {
    mavenCentral()
}
dependencies {
    implementation("org.apache.groovy:groovy-all:4.0.30")
    implementation("io.qameta.allure:allure-spock2:2.33.0")
    implementation("io.qameta.allure:allure-rest-assured:2.33.0")
    implementation("org.spockframework:spock-core:2.3-groovy-4.0")
    implementation("io.rest-assured:rest-assured:5.5.7")
    implementation("com.codeborne:selenide:7.14.0")
    implementation("io.qameta.allure:allure-selenide:2.33.0")
}

allure {
    version.set("2.33.0")
    adapter {
        // AspectJ Weaver is fine, but make sure the latest available version is used
        aspectjWeaver.set(true)
        aspectjVersion.set("1.9.25.1")

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
    // Suppress sun.misc.Unsafe warnings from AspectJ Weaver on Java 25+
    // Remove this flag once AspectJ drops Unsafe usage
    jvmArgs("--sun-misc-unsafe-memory-access=allow")
}