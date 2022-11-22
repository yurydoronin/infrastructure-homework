import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
import org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED
import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

val parentProjectDir = projectDir

plugins {
    id("org.springframework.boot") version "2.7.2"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
    kotlin("jvm") version "1.7.20" apply false
    kotlin("plugin.spring") version "1.7.20" apply false
    kotlin("plugin.jpa") version "1.7.20" apply false
    id("org.owasp.dependencycheck") version "7.3.0"
    id("com.github.ben-manes.versions") version "0.43.0"
    id("io.gitlab.arturbosch.detekt") version "1.22.0-RC2"

}

allprojects {
    group = "com.stringconcat"
    version = "1.0.0"
}

subprojects {
    configurations.all {
        resolutionStrategy {
            eachDependency {
                requested.version?.contains("snapshot", true)?.let {
                    if (it) {
                        throw GradleException("Snapshot found: ${requested.name} ${requested.version}")
                    }
                }
            }
        }
    }

    apply {
        plugin("java")
        plugin(Plugins.kotlin)
        plugin(Plugins.detekt)
        plugin(Plugins.update_dependencies)
        plugin(Plugins.owasp_dependencies)
    }

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
    }


    detekt {
        config = files("$parentProjectDir/tools/detekt/detekt-config.yml")
        buildUponDefaultConfig = true
        source = files("src/main/kotlin", "src/test/kotlin")

        reports {
            html.required.set(true)
        }

        dependencies {
            detektPlugins("${Plugins.detekt_formatting}:${PluginVers.detekt_formatting}")
        }
    }

    tasks {

        val dependencyUpdate =
            named<DependencyUpdatesTask>("dependencyUpdates")

        dependencyUpdate {
            revision = "release"
            outputFormatter = "txt"
            checkForGradleUpdate = true
            outputDir = "$buildDir/reports/dependencies"
            reportfileName = "updates"
        }

        dependencyUpdate.configure {

            fun isNonStable(version: String): Boolean {
                val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
                val regex = "^[0-9,.v-]+(-r)?$".toRegex()
                val isStable = stableKeyword || regex.matches(version)
                return isStable.not()
            }

            rejectVersionIf {
                isNonStable(candidate.version) && !isNonStable(currentVersion)
            }
        }

        val failOnWarning = project.properties["allWarningsAsErrors"] != null &&
                project.properties["allWarningsAsErrors"] == "true"

        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "11"
                allWarningsAsErrors = failOnWarning
                freeCompilerArgs = listOf("-Xjvm-default=all")
            }
        }

        withType<Test> {
            useJUnitPlatform()

            maxParallelForks = 10

            testLogging {
                events(
                    PASSED,
                    FAILED,
                    SKIPPED
                )
                showStandardStreams = true
                exceptionFormat = FULL
            }
        }
    }
}
