import com.android.build.gradle.LibraryExtension
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.`maven-publish`
import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec

fun LibraryExtension.androidLibraryConfig() {
    compileSdkVersion(Build.compileSdk)
    buildToolsVersion(Build.tools)

    defaultConfig {
        minSdkVersion(Build.minSdk)
        targetSdkVersion(Build.targetSdk)

        versionName = Build.versionName
        versionCode = Build.versionCode
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
        }
        named("debug") {
            isMinifyEnabled = false
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/java", "src/main/kotlin")
    }
}

fun DependencyHandlerScope.commonLibraryDependencies() {
    "implementation"(Libs.coreKtx)
    "implementation"(Libs.appCompat)
    "implementation"(Libs.constraintLayout)
    "implementation"(Libs.hyperionPlugin)
    "kapt"(Libs.autoService)
}

fun PluginDependenciesSpec.commonLibraryPlugins() {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    `maven-publish`
}


