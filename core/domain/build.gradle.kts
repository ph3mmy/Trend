plugins {
    id("kotlin")
    id("kotlinx-serialization")
}

dependencies {
    api(libs.kotlinx.coroutines.android)

    implementation(libs.kotlinx.serialization)
    implementation(libs.kotlinx.date.time)

    testImplementation(libs.junit4)
}