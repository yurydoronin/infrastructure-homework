plugins {
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.jpa")
}

java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
    implementation(project(":businessPeople"))
    implementation(project(":useCasePeople"))

    implementation("javax.persistence:javax.persistence-api:2.2")
    implementation("org.apache.logging.log4j:log4j-core:2.19.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.4")

    // tests
    testCompileOnly("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}