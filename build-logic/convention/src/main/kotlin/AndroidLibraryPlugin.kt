@file:Suppress("UnstableApiUsage")

import com.android.build.api.dsl.LibraryExtension
import com.oluwafemi.trend.compileSDK
import com.oluwafemi.trend.configureKotlinAndroid
import com.oluwafemi.trend.minSDK
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
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
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    extensions.getByType<LibraryExtension>().apply {
        configureKotlinAndroid(this)

        compileSdk = libs.compileSDK()
        defaultConfig {
            minSdk = libs.minSDK()
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
