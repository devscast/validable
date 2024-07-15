import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("io.gitlab.arturbosch.detekt") version "1.23.6"
    id("org.jetbrains.kotlinx.binary-compatibility-validator") version "0.14.0"
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.vanniktech.maven.publish") version "0.29.0"
}

android {
    compileSdk = 34

    lint {
        targetSdk = 34
    }

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    namespace = "tech.devscast.validable"
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.compose.ui:ui:1.6.8")
    testImplementation("junit:junit:4.13.2")
}

detekt {
    parallel = true

    // Define the detekt configuration(s) you want to use.
    // Defaults to the default detekt configuration.
    config.setFrom("$rootDir/detekt/config.yml")

    // Applies the config files on top of detekt's default config file. `false` by default.
    buildUponDefaultConfig = false

    // Specifying a baseline file. All findings stored in this file in subsequent runs of detekt.
    baseline = file("$rootDir/detekt/baseline.xml")
}


mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()

    coordinates("tech.devscast", "validable", "2.0.0-alpha01")

    pom {
        name.set("Validable")
        description.set("An easy-to-use text field validator for Kotlin & Jetpack compose.")
        inceptionYear.set("2021")
        url.set("https://github.com/devscast/validable")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("yveskalume")
                name.set("Yves Kalume")
                url.set("https://github.com/yveskalume")
            }
            developer {
                id.set("bernard-ng")
                name.set("Bernard Ngandu")
                url.set("https://github.com/bernard-ng")
            }
        }

        scm {
            url.set("https://github.com/devscast/validable")
            connection.set("scm:git:git://github.com/devscast/validable.git")
            developerConnection.set("scm:git:ssh://git@github.com/devscast/validable.git")
        }
    }
}