object LibVers {
    const val spring_boot = "2.6.1"
    const val junit = "5.7.1"
    const val kotest = "5.0.2"
    const val kotest_arrow = "1.2.0"
    const val jackson = "2.13.0"
    const val arrow = "1.0.1"
    const val slf4j = "1.7.32"
    const val postgresql = "42.3.1"
    const val liquibase = "4.6.1"
    const val arch_unit = "0.22.0"
    const val testcontainers = "1.16.2"
}

object Libs {
    // Kotlin
    const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Global.kotlin_version}"
    const val arrow = "io.arrow-kt:arrow-core:${LibVers.arrow}"

    // Jackson
    const val jackson_kotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:${LibVers.jackson}"
    const val jackson_databind = "com.fasterxml.jackson.core:jackson-databind:${LibVers.jackson}"

    // Spring
    const val spring_boot_starter_web = "org.springframework.boot:spring-boot-starter-web:${LibVers.spring_boot}"
    const val spring_boot_starter_test = "org.springframework.boot:spring-boot-starter-test:${LibVers.spring_boot}"

    // Logging
    const val slf4j_api = "org.slf4j:slf4j-api:${LibVers.slf4j}"

    // Tests
    const val junit_params = "org.junit.jupiter:junit-jupiter-params:${LibVers.junit}"
    const val junit_engine = "org.junit.jupiter:junit-jupiter-engine:${LibVers.junit}"
    const val kotest_junit = "io.kotest:kotest-runner-junit5:${LibVers.kotest}"
    const val kotest_arrow = "io.kotest.extensions:kotest-assertions-arrow-jvm:${LibVers.kotest_arrow}"
    const val arch_unit = "com.tngtech.archunit:archunit-junit5:${LibVers.arch_unit}"

    // Database
    const val postgresql = "org.postgresql:postgresql:${LibVers.postgresql}"
    const val liquibase = ("org.liquibase:liquibase-core:${LibVers.liquibase}")
}

object PluginVers {
    const val kotlin = Global.kotlin_version
    const val spring_boot = LibVers.spring_boot
    const val detekt = "1.19.0"
    const val detekt_formatting = detekt
    const val spring_dependency_management = "1.0.11.RELEASE"
    const val spring_kotlin = Global.kotlin_version
    const val update_dependencies = "0.36.0"
    const val owasp_dependencies = "6.1.0"
}

object Plugins {
    const val kotlin = "org.jetbrains.kotlin.jvm"
    const val spring_boot = "org.springframework.boot"
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val detekt_formatting = "io.gitlab.arturbosch.detekt:detekt-formatting"
    const val spring_dependency_management = "io.spring.dependency-management"
    const val spring_kotlin = "org.jetbrains.kotlin.plugin.spring"
    const val update_dependencies = "com.github.ben-manes.versions"
    const val owasp_dependencies = "org.owasp.dependencycheck"
}