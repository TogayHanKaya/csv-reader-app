package com.thk.plugin.configure

import com.thk.ext.implementation
import com.thk.plugin.internal.applicationExtension
import com.thk.plugin.internal.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidApplication() = applicationExtension.run {
    plugins.apply("kotlin-android")

    defaultConfig {
        applicationId = "com.thk.csvreader"
        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()
        versionCode = 1
        versionName = "1.0.0"
        resourceConfigurations + listOf("en")
    }

    buildTypes {
        release {
            isDebuggable = false
            multiDexEnabled = false
            isMinifyEnabled = true
            proguardFiles(
                "proguard-rules.pro",
                getDefaultProguardFile("proguard-android-optimize.txt")
            )
        }

        debug {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"

            isMinifyEnabled = false
            multiDexEnabled = true
        }
    }

    dependencies {
        implementation(libs.kotlin)
    }
}
