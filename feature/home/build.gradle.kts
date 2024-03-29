plugins {
    id("com.trend.library")
}

android {
    namespace = "com.oluwafemi.trend.feature.home"
}

dependencies {
    implementation(libs.androidx.core.ktx)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
}