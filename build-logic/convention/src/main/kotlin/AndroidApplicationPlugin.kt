@file:Suppress("UnstableApiUsage")

import com.android.build.api.dsl.ApplicationExtension
import com.oluwafemi.trend.configureKotlinAndroid
import com.oluwafemi.trend.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyPlugins()
            applyAndroid()
        }
    }

    private fun Project.applyPlugins() {
        with(pluginManager) {
            apply("com.android.application")
            apply("org.jetbrains.kotlin.android")
        }
    }

    private fun Project.applyAndroid() {
        extensions.configure<ApplicationExtension> {
            configureKotlinAndroid(this)

            compileSdk = libs.versions.sdkCompile.get().toInt()
            defaultConfig.apply {
                applicationId = "com.oluwafemi.trend"
                minSdk = libs.versions.sdkMin.get().toInt()
                targetSdk = libs.versions.sdkTarget.get().toInt()
                versionCode = libs.versions.versionCode.get().toInt()
                versionName = libs.versions.versionName.get()
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                vectorDrawables { useSupportLibrary = true }

                buildTypes {
                    debug {
                        enableUnitTestCoverage = true
                    }
                    release {
                        isMinifyEnabled = false
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                    }
                }
                packaging {
                    resources {
                        excludes.add("/META-INF/{AL2.0,LGPL2.1}")
                    }
                }
            }
        }
    }
}