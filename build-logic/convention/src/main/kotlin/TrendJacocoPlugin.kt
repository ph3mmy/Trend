import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.oluwafemi.trend.configureJacoco
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class TrendJacocoPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.gradle.jacoco")
                apply("com.android.application")
            }
            // TODO: configure Jacoco for "LibraryAndroidComponentsExtension"
            val appExtension = extensions.getByType<ApplicationAndroidComponentsExtension>()
            configureJacoco(appExtension)
        }
    }
}