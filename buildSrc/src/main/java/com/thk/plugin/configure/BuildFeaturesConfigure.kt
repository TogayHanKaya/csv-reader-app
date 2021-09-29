package com.thk.plugin.configure

import com.android.build.api.dsl.CommonExtension
import com.thk.plugin.HappyXPluginExtension
import org.gradle.api.Project

fun CommonExtension<*, *, *, *>.configureBuildFeatures(
    project: Project,
    pluginExtension: HappyXPluginExtension
) {
    buildFeatures {
        viewBinding = pluginExtension.viewBinding
        buildConfig = pluginExtension.buildConfigGeneration
    }

    if (pluginExtension.kotlinParcelize) {
        project.plugins.apply("kotlin-parcelize")
    }
}