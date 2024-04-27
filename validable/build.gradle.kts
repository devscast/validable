plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
    id("org.jetbrains.dokka") version "1.9.20"
    id("org.jetbrains.kotlinx.binary-compatibility-validator") version "0.14.0"
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.5"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    namespace = "tech.devscast.validable"
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.0")
    implementation(platform("androidx.compose:compose-bom:2024.04.01"))
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.compose.ui:ui")
    testImplementation("junit:junit:4.13.2")
    dokkaPlugin("org.jetbrains.dokka:android-documentation-plugin:1.9.20")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "tech.devscast"
            artifactId = "validable"
            version = "1.3.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
