@file:Suppress("UnstableApiUsage")

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.getByType

class TrendComposePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            val libs = this.extensions.getByType<VersionCatalogsExtension>().named("libs")
            applyDependencies(libs)
            applyExtensions(libs)
        }
    }

    private fun Project.applyDependencies(libs: VersionCatalog) {
        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
        }
    }

    private fun Project.applyExtensions(libs: VersionCatalog) {
        extensions.findByType<ApplicationExtension>()?.apply {
            applyCommonExtensions(libs)
        }
        extensions.findByType<LibraryExtension>()?.apply {
            applyCommonExtensions(libs)
        }
    }

    private fun CommonExtension<*, *, *, *>.applyCommonExtensions(libs: VersionCatalog) {

        this.apply {
            buildFeatures {
                compose = true
            }

            composeOptions {
                kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().toString()
            }

        }

    }
}