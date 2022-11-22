rootProject.name = "people"

include(":application")
include(":businessPeople")
include(":presentation")
include(":useCasePeople")
include(":persistence")
include(":quoteGarden")
include(":avatarsDicebear")

pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/milestone") }
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.springframework.boot") {
                useModule("org.springframework.boot:spring-boot-gradle-plugin:${requested.version}")
            }
        }
    }
}