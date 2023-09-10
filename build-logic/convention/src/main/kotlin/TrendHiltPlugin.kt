import com.oluwafemi.trend.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class TrendHiltPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        applyPlugin(target)
        applyDependencies(target)
    }

    private fun applyDependencies(project: Project) {
        with(project) {
            dependencies.apply {
                add("implementation", libs.hilt.android)
                add("ksp", libs.hilt.compiler)
                add("kspAndroidTest", libs.hilt.compiler)
            }
        }
    }

    private fun applyPlugin(project: Project) {
        project.pluginManager.apply {
            apply("com.google.dagger.hilt.android")
            apply("com.google.devtools.ksp")
        }
    }
}