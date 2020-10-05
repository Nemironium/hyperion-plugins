plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    androidLibraryConfig()
    resourcePrefix = "hne"
}

dependencies {
    commonLibraryDependencies()
    implementation(Libs.okHttp)
}