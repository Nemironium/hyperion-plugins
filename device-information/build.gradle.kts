plugins {
    commonLibraryPlugins()
}

android {
    androidLibraryConfig()
    resourcePrefix = "hdi"
}

dependencies {
    commonLibraryDependencies()
    implementation(Libs.deviceNames)
}