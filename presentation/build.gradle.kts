plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.spring.dependency-management")
}

java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
    implementation(project(":businessPeople"))
    implementation(project(":useCasePeople"))

    // spring modules
    implementation("org.springframework.boot:spring-boot-starter-webflux:2.7.5")
    implementation("org.springframework.boot:spring-boot-starter-data-rest:2.7.5")

    // tools
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // view
    implementation( "org.jetbrains.kotlinx:kotlinx-html-jvm:0.8.0")

    // tests
    testCompileOnly("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.5")
    testImplementation("io.projectreactor:reactor-test:3.4.24")
}