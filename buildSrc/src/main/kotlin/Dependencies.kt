object Build {
    const val tools = "30.0.2"
    const val compileSdk = 30
    const val targetSdk = 30
    const val minSdk = 21
    const val versionCode = 4 // TODO : make function for this
    const val versionName = "0.3.1"
    const val group = "me.nemiron.hyperion"

    object Publishing {
        const val publicationDescription = "Set of useful Hyperion plugins"
        const val license = "MIT"
        const val licenseName = "The MIT License"
        const val licenseUrl = "https://opensource.org/licenses/MIT"
        const val developerId = "Nemiron"
        const val developerName = "Pavel Aleksandrov"
        const val developerEmail = "nemiron@outlook.com"
        const val siteUrl = "https://github.com/Nemironium/hyperion-plugins"
        const val gitUrl = "https://github.com/Nemironium/hyperion-plugins.git"
    }
}

object PluginVersions {
    const val kotlin = "1.5.0"
    const val androidGradle = "4.2.0"
}

object Libs {
    private const val hyperionVersion = "0.9.31"
    private const val okHttpVersion = "4.9.0"
    private const val autoServiceVersion = "1.0-rc7"
    private const val deviceNamesVersion = "2.0.0"
    private const val lynxVersion = "1.1.0"
    private const val coreKtxVersion = "1.3.2"
    private const val appCompatVersion = "1.2.0"
    private const val materialVersion = "1.2.1"
    private const val constraintLayoutVersion = "2.0.1"
    private const val chuckerVersion = "3.4.0"

    const val hyperionCore = "com.willowtreeapps.hyperion:hyperion-core:$hyperionVersion"
    const val hyperionPlugin = "com.willowtreeapps.hyperion:hyperion-plugin:$hyperionVersion"

    const val autoService = "com.google.auto.service:auto-service:$autoServiceVersion"

    const val deviceNames = "com.jaredrummler:android-device-names:$deviceNamesVersion"

    const val lynx = "com.github.pedrovgs:lynx:$lynxVersion"

    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"

    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    const val material = "com.google.android.material:material:$materialVersion"

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"

    const val chuckerDebug =  "com.github.chuckerteam.chucker:library:$chuckerVersion"
    const val chuckerRelease = "com.github.chuckerteam.chucker:library-no-op:$chuckerVersion"
}
