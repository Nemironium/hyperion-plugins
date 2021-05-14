import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${PluginVersions.androidGradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersions.kotlin}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }

    group = Build.group
    version = Build.versionName

    ext {
        val localProperties = gradleLocalProperties(rootDir)
        localProperties.forEach { name, value ->
            set(name as String, value)
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}