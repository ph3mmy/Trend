@file:Suppress("UnstableApiUsage")

import com.android.build.api.dsl.ApplicationExtension
import com.oluwafemi.trend.compileSDK
import com.oluwafemi.trend.configureKotlinAndroid
import com.oluwafemi.trend.minSDK
import com.oluwafemi.trend.targetSDK
import com.oluwafemi.trend.versionCode
import com.oluwafemi.trend.versionName
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

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
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
        extensions.configure<ApplicationExtension> {
            configureKotlinAndroid(this)

            compileSdk = libs.compileSDK()
            defaultConfig.apply {
                applicationId = "com.oluwafemi.trend"
                minSdk = libs.minSDK()
                targetSdk = libs.targetSDK()
                versionCode = libs.versionCode()
                versionName = libs.versionName()
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
                packagingOptions {
                    resources {
                        excludes.add("/META-INF/{AL2.0,LGPL2.1}")
                    }
                }
            }
        }
    }
}