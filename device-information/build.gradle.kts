import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

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

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").java.srcDirs)
}

publishing {
    publications {
        create<MavenPublication>(Build.DeviceInformation.libraryName) {
            artifact("$buildDir/outputs/aar/${Build.DeviceInformation.artifact}-release.aar")
            artifact(sourcesJar)
            groupId = Build.group
            artifactId = Build.DeviceInformation.artifact
            version = Build.versionName
            pom.withXml {
                asNode().apply {
                    appendNode("name", Build.DeviceInformation.libraryName)
                    appendNode("description", Build.DeviceInformation.libraryDescription)
                    appendNode("url", Build.siteUrl)
                    appendNode("licenses").appendNode("license").apply {
                        appendNode("name", Build.licenseName)
                        appendNode("url", Build.licenseUrl)
                    }
                    appendNode("developers").appendNode("developer").apply {
                        appendNode("id", Build.developer)
                        appendNode("name", Build.developer)
                        appendNode("email", Build.developerEmail)
                    }
                    appendNode("scm").apply {
                        appendNode("connection", Build.gitUrl)
                        appendNode("developerConnection", Build.gitUrl)
                        appendNode("url", Build.siteUrl)
                    }
                    appendNode("dependencies").apply {
                        configurations.implementation.allDependencies.forEach {
                            if (it.name != "unspecified") {
                                appendNode("dependency").apply {
                                    appendNode("groupId", it.group)
                                    appendNode("artifactId", it.name)
                                    appendNode("version", it.version)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

bintray {
    user = gradleLocalProperties(rootDir).getProperty("bintray.user")
    key = gradleLocalProperties(rootDir).getProperty("bintray.apikey")
    setPublications(Build.DeviceInformation.libraryName)

    pkg.apply {
        repo = Build.bintrayRepo
        name = Build.DeviceInformation.artifact
        description = Build.DeviceInformation.libraryDescription
        websiteUrl = Build.siteUrl
        vcsUrl = Build.gitUrl
        issueTrackerUrl = Build.issueTrackerUrl
        setLicenses(Build.license)
        setLabels("android", "hyperion")
        publish = true
        publicDownloadNumbers = true

        version.apply {
            name = Build.DeviceInformation.libraryName
            desc = Build.DeviceInformation.libraryDescription
            gpg.apply {
                sign = true
                passphrase = gradleLocalProperties(rootDir).getProperty("bintray.gpg.password")
            }
        }
    }
}