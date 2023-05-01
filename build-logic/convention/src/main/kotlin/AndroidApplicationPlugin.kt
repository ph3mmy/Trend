@file:Suppress("UnstableApiUsage")

import com.android.build.api.dsl.ApplicationExtension
import com.oluwafemi.trend.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)


                compileSdk = libs.findVersion("sdkCompile").get().toString().toInt()
                defaultConfig.apply {
                    applicationId = "com.oluwafemi.trend"
                    minSdk = libs.findVersion("sdkMin").get().toString().toInt()
                    targetSdk = libs.findVersion("sdkTarget").get().toString().toInt()
                    versionCode = libs.findVersion("versionCode").get().toString().toInt()
                    versionName = libs.findVersion("versionName").get().toString()
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
}