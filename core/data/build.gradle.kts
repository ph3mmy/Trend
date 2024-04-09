plugins {
    alias(libs.plugins.trend.library)
    alias(libs.plugins.trend.hilt)
}

android {
    namespace = "com.oluwafemi.trend.core.data"
}

dependencies {
    implementation(projects.core.database)
    implementation(projects.core.domain)

    testImplementation(libs.junit4)
    testImplementation(kotlin("test")) // extract Test to a module

    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
}