plugins {
    id("kotlin")
    id("kotlinx-serialization")
}

dependencies {
    api(libs.kotlinx.coroutines.android)
    api(libs.kotlinx.date.time)

    implementation(libs.kotlinx.serialization)

    testImplementation(libs.junit4)
}