@file:Suppress("UnstableApiUsage")

plugins {
    id("com.trend.library")
}

android {
    namespace = "com.oluwafemi.trend.core.ui"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
}