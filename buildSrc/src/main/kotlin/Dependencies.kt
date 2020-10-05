object Build {
    const val tools = "30.0.2"
    const val compileSdk = 30
    const val targetSdk = 30
    const val minSdk = 21
    const val code = 1
    const val name = "0.1"
}

object PluginVersions {
    const val kotlin = "1.4.10"
    const val androidGradle = "4.2.0-alpha10"
}

object Libs {
    private const val hyperionVersion = "0.9.29"
    private const val okHttpVersion = "4.9.0"
    private const val autoServiceVersion = "1.0-rc7"
    private const val deviceNamesVersion = "2.0.0"
    private const val coreKtxVersion = "1.3.2"
    private const val appCompatVersion = "1.2.0"
    private const val materialVersion = "1.2.1"
    private const val constraintLayoutVersion = "2.0.1"


    const val hyperionPlugin = "com.willowtreeapps.hyperion:hyperion-plugin:$hyperionVersion"
    const val hyperionCore = "com.willowtreeapps.hyperion:hyperion-core:$hyperionVersion"

    const val autoService = "com.google.auto.service:auto-service:$autoServiceVersion"

    const val deviceNames = "com.jaredrummler:android-device-names:$deviceNamesVersion"

    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"

    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    const val material = "com.google.android.material:material:$materialVersion"

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
}
