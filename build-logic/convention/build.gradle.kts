plugins {
    `kotlin-dsl`
}

java{
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("trendApplicationPlugin") {
            id = "com.trend.application"
            implementationClass = "AndroidApplicationPlugin"
        }
        register("trendAndroidLibraryPlugin") {
            id = "com.trend.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("composePlugin") {
            id = "com.trend.compose"
            implementationClass = "TrendComposePlugin"
        }
        register("trendJacocoApplicationPlugin") {
            id = "com.trend.jacoco.application"
            implementationClass = "TrendJacocoPlugin"
        }
        register("trendHiltPlugin") {
            id = "com.trend.hilt"
            implementationClass = "TrendHiltPlugin"
        }
    }
}