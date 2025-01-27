import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.compose)

    alias(libs.plugins.detekt)
    alias(libs.plugins.binaryCompatibiltyValidator)
    alias(libs.plugins.mavenPublish)
}

kotlin {

    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()

    js(IR){
        browser()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.ui)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

android {
    compileSdk = 35

    lint {
        targetSdk = 35
    }

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
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