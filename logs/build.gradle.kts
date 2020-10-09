import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

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

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").java.srcDirs)
}

publishing {
    publications {
        create<MavenPublication>(Build.Logs.libraryName) {
            artifact("$buildDir/outputs/aar/${Build.Logs.artifact}-release.aar")
            artifact(sourcesJar)
            groupId = Build.group
            artifactId = Build.Logs.artifact
            version = Build.versionName
            pom.withXml {
                asNode().apply {
                    appendNode("name", Build.Logs.libraryName)
                    appendNode("description", Build.Logs.libraryDescription)
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
    user = gradleLocalProperties(rootDir).getProperty("bintray.user")
    key = gradleLocalProperties(rootDir).getProperty("bintray.apikey")
    setPublications(Build.Logs.libraryName)

    pkg.apply {
        repo = Build.bintrayRepo
        name = Build.Logs.artifact
        description = Build.Logs.libraryDescription
        websiteUrl = Build.siteUrl
        vcsUrl = Build.gitUrl
        issueTrackerUrl = Build.issueTrackerUrl
        setLicenses(Build.license)
        setLabels("android", "hyperion")
        publish = true
        publicDownloadNumbers = true

        version.apply {
            name = Build.Logs.libraryName
            desc = Build.Logs.libraryDescription
            gpg.apply {
                sign = true
                passphrase = gradleLocalProperties(rootDir).getProperty("bintray.gpg.password")
            }
        }
    }
}