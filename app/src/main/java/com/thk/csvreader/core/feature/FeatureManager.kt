package com.thk.csvreader.core.feature

object FeatureManager {

    val kodeinModules = arrayOf("module")
        .map { "com.thk.feature_reader.FeatureKodeinModule" }
        .map {
            try {
                Class.forName(it).kotlin.objectInstance as KodeinModuleProvider
            } catch (e: ClassNotFoundException) {
                throw ClassNotFoundException("Kodein module class not found $it")
            }
        }
        .map { it.kodeinModule }
}