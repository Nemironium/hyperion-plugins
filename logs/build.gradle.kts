plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    androidLibraryConfig()
    resourcePrefix = "hl"
}

dependencies {
    commonLibraryDependencies()
}