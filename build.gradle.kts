import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${PluginVersions.androidGradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersions.kotlin}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
