import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    commonLibraryPlugins()
}

android {
    androidLibraryConfig()
    resourcePrefix = "hch"
}

dependencies {
    commonLibraryDependencies()
    debugImplementation(Libs.chuckerDebug)
    releaseImplementation(Libs.chuckerRelease)
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").java.srcDirs)
}

publishing {
    publications {
        create<MavenPublication>(Build.Chucker.libraryName) {
            artifact("$buildDir/outputs/aar/${Build.Chucker.artifact}-release.aar")
            artifact(sourcesJar)
            groupId = Build.group
            artifactId = Build.Chucker.artifact
            version = Build.versionName

            pom.withXml {
                asNode().apply {
                    appendNode("name", Build.Chucker.libraryName)
                    appendNode("description", Build.Chucker.libraryDescription)
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
    setPublications(Build.Chucker.libraryName)

    pkg.apply {
        repo = Build.bintrayRepo
        name = Build.Chucker.artifact
        description = Build.Chucker.libraryDescription
        websiteUrl = Build.siteUrl
        vcsUrl = Build.gitUrl
        issueTrackerUrl = Build.issueTrackerUrl
        setLicenses(Build.license)
        setLabels("android", "hyperion")
        publish = true
        publicDownloadNumbers = true

        version.apply {
            name = Build.Chucker.libraryName
            desc = Build.Chucker.libraryDescription
            gpg.apply {
                sign = true
                passphrase = gradleLocalProperties(rootDir).getProperty("bintray.gpg.password")
            }
        }
    }
}