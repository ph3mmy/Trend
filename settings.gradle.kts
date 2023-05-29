@file:Suppress("UnstableApiUsage")

include(":core:model")


pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Trend"
include(":app")
include(":core:data")
include(":core:database")
include(":core:testing")
include(":core:ui")
include(":feature:home")
