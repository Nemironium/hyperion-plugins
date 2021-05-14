plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Build.compileSdk)
    buildToolsVersion = Build.tools

    defaultConfig {
        minSdkVersion(Build.minSdk)
        targetSdkVersion(Build.targetSdk)
        applicationId = "me.nemiron.hyperion.sample"
        versionCode = Build.versionCode
        versionName = Build.versionName
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
    debugImplementation(Libs.hyperionCore)

    debugImplementation(project(":network-emulation"))
    debugImplementation(project(":device-information"))
    debugImplementation(project(":logs"))
    debugImplementation(project(":chucker"))
}