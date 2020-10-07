plugins {
    commonLibraryPlugins()
}

android {
    androidLibraryConfig()
    resourcePrefix = "hl"
}

dependencies {
    commonLibraryDependencies()
    implementation(Libs.lynx)
}