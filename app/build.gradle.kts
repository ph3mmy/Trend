@file:Suppress("UnstableApiUsage")

plugins {
    id("com.trend.application")
    id("com.trend.compose.application")
    id("com.trend.jacoco.application")
    id("jacoco")
}

android {
    namespace = "com.oluwafemi.trend"
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material)

    compileOnly(libs.lint.api)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.testManifest)
}
