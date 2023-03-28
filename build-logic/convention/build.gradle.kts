plugins {
    `kotlin-dsl`
}

java{
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
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
    }
}