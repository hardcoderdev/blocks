plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.compose.compiler)
    id("maven-publish")
}

android {
    namespace = "hardcoder.dev.blocks"
    compileSdk = 35

    defaultConfig {
        minSdk = 26

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
}

kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.hardcoderdev"
            artifactId = "blocks"
            version = "0.0.1"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.activity.compose)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui)
    implementation(libs.compose.extendedIcons)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.lottie)
}