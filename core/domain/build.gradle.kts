plugins {
    id("kotlin")
}

dependencies {
    implementation(libs.kotlinx.date.time)
    implementation(libs.kotlinx.coroutines.android)

    testImplementation(libs.junit4)
}