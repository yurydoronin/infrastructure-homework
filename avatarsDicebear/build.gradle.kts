plugins {
    kotlin("jvm")
}

java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
    implementation(project(":businessPeople"))
    implementation("javax.inject:javax.inject:1")

    // tests
    testCompileOnly("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}