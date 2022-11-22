plugins {
    id("org.springframework.boot") version "2.7.2"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {

    implementation(project(":presentation"))
    implementation(project(":persistence"))
    implementation(project(":useCasePeople"))
    implementation(project(":businessPeople"))
    implementation(project(":quoteGarden"))
    implementation(project(":avatarsDicebear"))

    // spring modules
    implementation("org.springframework.boot:spring-boot-starter-webflux:2.7.5")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.5")
    implementation("org.springframework.boot:spring-boot-starter-data-rest:2.7.5")

    // dev tools
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // persistence
    implementation("org.postgresql:postgresql")
    implementation("org.liquibase:liquibase-core")

    // tests
    testCompileOnly("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.5")
    testImplementation("io.projectreactor:reactor-test")
}

allOpen {
    annotations(
        "javax.persistence.Entity",
        "javax.persistence.Embeddable",
        "javax.persistence.MappedSuperclass"
    )
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootJar {
    archiveFileName.set("${project.name}-${archiveVersion.get()}.jar")
}

