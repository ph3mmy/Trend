plugins {
    `kotlin-dsl`
}

java{
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("TrendApplicationPlugin") {
            id = "com.trend.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("TrendAndroidLibraryPlugin") {
            id = "com.trend.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("ComposePlugin") {
            id = "com.trend.compose"
            implementationClass = "TrendComposePlugin"
        }
        register("TrendJacocoApplicationPlugin") {
            id = "com.trend.jacoco.application"
            implementationClass = "TrendJacocoPlugin"
        }
    }
}