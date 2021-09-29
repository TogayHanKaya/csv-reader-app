package com.thk.feature_reader

import com.thk.csvreader.core.feature.KodeinModuleProvider
import com.thk.feature_reader.data.dataModule
import com.thk.feature_reader.domain.domainModule
import com.thk.feature_reader.presentation.presentationModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Reader"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}