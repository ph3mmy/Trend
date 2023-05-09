@file:Suppress("UnstableApiUsage")

import com.android.build.api.dsl.LibraryExtension
import com.oluwafemi.trend.configureKotlinAndroid
import com.oluwafemi.trend.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyPlugins()
            applyAndroid()
        }
    }
}

private fun Project.applyAndroid() {
    extensions.getByType<LibraryExtension>().apply {
        configureKotlinAndroid(this)

        compileSdk = libs.versions.sdkCompile.get().toInt()
        defaultConfig {
            minSdk = libs.versions.sdkMin.get().toInt()
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            consumerProguardFiles("consumer-rules.pro")
        }

        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }
}

private fun Project.applyPlugins() {
    with(pluginManager) {
        apply("com.android.library")
        apply("org.jetbrains.kotlin.android")
    }
}
