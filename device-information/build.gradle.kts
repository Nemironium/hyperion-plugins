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

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>(project.name) {
                groupId = Build.group
                artifactId = project.name
                version = Build.versionName

                val sourcesJar by tasks.creating(Jar::class) {
                    archiveClassifier.set("sources")
                    from(android.sourceSets.getByName("main").java.srcDirs)
                }

                artifact(tasks["bundleReleaseAar"])
                artifact(sourcesJar)

                pom {
                    name.set(project.name)
                    description.set(Build.Publishing.publicationDescription)
                    url.set(Build.Publishing.siteUrl)

                    licenses {
                        license {
                            name.set(Build.Publishing.licenseName)
                            url.set(Build.Publishing.licenseUrl)
                        }
                    }

                    developers {
                        developer {
                            id.set(Build.Publishing.developerId)
                            name.set(Build.Publishing.developerName)
                            email.set(Build.Publishing.developerEmail)
                        }
                    }

                    scm {
                        connection.set(Build.Publishing.gitUrl)
                        developerConnection.set(Build.Publishing.gitUrl)
                        url.set(Build.Publishing.siteUrl)
                    }

                    // Because is no way to insert dependencies via dsl
                    withXml {
                        asNode().appendNode("dependencies").apply {
                            configurations.implementation.get().allDependencies.forEach(::appendDependency)
                        }
                    }
                }
            }
        }
        repositories {
            maven {
                name = "sonatype"
                url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2")

                credentials {
                    username = gradleLocalProperties(rootDir).getProperty("ossrhUsername")
                    password = gradleLocalProperties(rootDir).getProperty("ossrhPassword")
                }
            }
        }
    }

    signing {
        sign(publishing.publications[project.name])
    }
}