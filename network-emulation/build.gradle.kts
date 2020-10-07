plugins {
    commonLibraryPlugins()
}

android {
    androidLibraryConfig()
    resourcePrefix = "hne"
}

dependencies {
    commonLibraryDependencies()
    implementation(Libs.okHttp)
}