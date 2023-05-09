import com.oluwafemi.trend.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

class TrendHiltPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        applyPlugin(target)
        applyDependencies(target)
        applyExtensions(target)
    }

    private fun applyExtensions(project: Project) {
        project.extensions.getByType<KaptExtension>().apply {
            correctErrorTypes = true
        }
    }

    private fun applyDependencies(project: Project) {
        with(project) {
            dependencies.apply {
                add("implementation", libs.hilt.android)
                add("kapt", libs.hilt.compiler)
                add("kaptAndroidTest", libs.hilt.compiler)
            }
        }
    }

    private fun applyPlugin(project: Project) {
        project.pluginManager.apply {
            apply("com.google.dagger.hilt.android")
            apply("org.jetbrains.kotlin.kapt")
        }
    }
}