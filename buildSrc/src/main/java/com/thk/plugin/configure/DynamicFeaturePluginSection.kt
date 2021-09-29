package com.thk.plugin.configure

import com.thk.ext.implementation
import com.thk.ext.main
import com.thk.plugin.internal.dynamicFeatureExtension
import com.thk.plugin.internal.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidDynamicFeature() = dynamicFeatureExtension.run {
    plugins.apply("kotlin-android")

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        compileSdk = libs.versions.compileSdk.get().toInt()
        proguardFiles("proguard-rules-dynamic-features.pro")
    }

    sourceSets {
        main {
            java.srcDirs("src/main/kotlin")
        }
    }

    dependencies {
        implementation(libs.kotlin)
    }
}