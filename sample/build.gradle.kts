plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = Build.tools

    defaultConfig {
        minSdkVersion(Build.minSdk)
        targetSdkVersion(Build.targetSdk)
        applicationId = "me.nemiron.hyperion.sample"
        versionCode = Build.code
        versionName = Build.name
    }

    buildTypes {
        named("debug") {
            isMinifyEnabled = false
        }
        named("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/java", "src/main/kotlin")
    }
}

dependencies {
    implementation(Libs.coreKtx)
    implementation(Libs.appCompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)

    implementation(Libs.okHttp)
    implementation(Libs.hyperionCore)
    implementation(Libs.hyperionPlugin)

    implementation(project(":network-emulation"))
    implementation(project(":device-information"))
}