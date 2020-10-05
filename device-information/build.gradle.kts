plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    androidLibraryConfig()
    resourcePrefix = "hdi"
}

dependencies {
    commonLibraryDependencies()
    implementation(Libs.deviceNames)
}