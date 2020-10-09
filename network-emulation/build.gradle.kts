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

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").java.srcDirs)
}

publishing {
    publications {
        create<MavenPublication>(Build.NetworkEmulation.libraryName) {
            artifact("$buildDir/outputs/aar/${Build.NetworkEmulation.artifact}-release.aar")
            artifact(sourcesJar)
            groupId = Build.group
            artifactId = Build.NetworkEmulation.artifact
            version = Build.versionName
            pom.withXml {
                asNode().apply {
                    appendNode("name", Build.NetworkEmulation.libraryName)
                    appendNode("description", Build.NetworkEmulation.libraryDescription)
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
                }
            }
        }
    }
}

bintray {
    user = com.android.build.gradle.internal.cxx.configure.gradleLocalProperties(rootDir).getProperty("bintray.user")
    key = com.android.build.gradle.internal.cxx.configure.gradleLocalProperties(rootDir).getProperty("bintray.apikey")
    setPublications(Build.NetworkEmulation.libraryName)

    pkg.apply {
        repo = Build.bintrayRepo
        name = Build.NetworkEmulation.artifact
        description = Build.NetworkEmulation.libraryDescription
        websiteUrl = Build.siteUrl
        vcsUrl = Build.gitUrl
        issueTrackerUrl = Build.issueTrackerUrl
        setLicenses(Build.license)
        setLabels("android", "hyperion")
        publish = true
        publicDownloadNumbers = true

        version.apply {
            name = Build.NetworkEmulation.libraryName
            desc = Build.NetworkEmulation.libraryDescription
            gpg.apply {
                sign = true
                passphrase = com.android.build.gradle.internal.cxx.configure.gradleLocalProperties(
                    rootDir
                ).getProperty("bintray.gpg.password")
            }
        }
    }
}
