@file:Suppress("UnstableApiUsage")

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.oluwafemi.trend.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.findByType

class TrendComposePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyDependencies()
            applyExtensions()
        }
    }

    private fun Project.applyDependencies() {
        dependencies {
            val bom = libs.androidx.compose.bom.get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
        }
    }

    private fun Project.applyExtensions() {
        extensions.findByType<ApplicationExtension>()?.apply {
            applyCommonExtensions(this@applyExtensions)
        }
        extensions.findByType<LibraryExtension>()?.apply {
            applyCommonExtensions(this@applyExtensions)
        }
    }

    private fun CommonExtension<*, *, *, *>.applyCommonExtensions(project: Project) {

        this.apply {
            buildFeatures {
                compose = true
            }

            composeOptions {
                kotlinCompilerExtensionVersion = project.libs.versions.composeCompiler.get()
            }

        }

    }
}