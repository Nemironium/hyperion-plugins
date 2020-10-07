import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.PluginDependenciesSpecScope
import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec

fun LibraryExtension.androidLibraryConfig() {
    compileSdkVersion(Build.compileSdk)
    buildToolsVersion(Build.tools)

    defaultConfig {
        minSdkVersion(Build.minSdk)
        targetSdkVersion(Build.targetSdk)

        versionName = Build.name
        versionCode = Build.code
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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
}


