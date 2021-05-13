object Build {
    const val tools = "30.0.2"
    const val compileSdk = 30
    const val targetSdk = 30
    const val minSdk = 21
    const val versionCode = 2 // TODO : make function for this
    const val versionName = "0.2"
    const val group = "me.nemiron.hyperion"

    const val license = "MIT"
    const val licenseName = "The MIT License"
    const val licenseUrl = "https://opensource.org/licenses/MIT"
    const val developer = "Nemiron"
    const val developerEmail = "nemiron@outlook.com"
    const val siteUrl = "https://github.com/Nemironium/hyperion-plugins"
    const val gitUrl = "https://github.com/Nemironium/hyperion-plugins.git"

    object DeviceInformation {
        const val libraryName = "Device-Information"
        const val libraryDescription = "Hyperion plugin for listing device information"
        const val artifact = "device-information"
    }

    object Logs {
        const val libraryName = "Logs"
        const val libraryDescription = "Hyperion plugin for listing device logs"
        const val artifact = "logs"
    }

    object NetworkEmulation {
        const val libraryName = "Network-Emulation"
        const val libraryDescription = "Hyperion plugin for emulating network conditions with OkHttp"
        const val artifact = "network-emulation"
    }
}

object PluginVersions {
    const val kotlin = "1.5.0"
    const val androidGradle = "4.2.0"
    const val mavenGradle = "1.4.1"
}

object Libs {
    private const val hyperionVersion = "0.9.27"
    private const val hyperionPluginVersion = "0.9.29"
    private const val okHttpVersion = "4.9.0"
    private const val autoServiceVersion = "1.0-rc7"
    private const val deviceNamesVersion = "2.0.0"
    private const val lynxVersion = "1.1.0"
    private const val coreKtxVersion = "1.3.2"
    private const val appCompatVersion = "1.2.0"
    private const val materialVersion = "1.2.1"
    private const val constraintLayoutVersion = "2.0.1"

    const val hyperionCore = "com.willowtreeapps.hyperion:hyperion-core:$hyperionVersion"
    const val hyperionPlugin = "com.willowtreeapps.hyperion:hyperion-plugin:$hyperionPluginVersion"

    const val autoService = "com.google.auto.service:auto-service:$autoServiceVersion"

    const val deviceNames = "com.jaredrummler:android-device-names:$deviceNamesVersion"

    const val lynx = "com.github.pedrovgs:lynx:$lynxVersion"

    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"

    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    const val material = "com.google.android.material:material:$materialVersion"

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
}
