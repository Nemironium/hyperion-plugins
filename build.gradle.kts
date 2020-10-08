import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${PluginVersions.androidGradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersions.kotlin}")
        classpath("com.jfrog.bintray.gradle.gradle.kts:gradle-bintray-plugin:${PluginVersions.bintrayGradle}")
        classpath("com.github.dcendents:android-maven-gradle-plugin:${PluginVersions.mavenGradle}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }

    group = Build.group
    version = Build.versionName

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
