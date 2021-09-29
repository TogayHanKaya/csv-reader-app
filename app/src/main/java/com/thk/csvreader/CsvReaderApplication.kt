package com.thk.csvreader

import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.thk.csvreader.core.feature.FeatureManager
import com.thk.csvreader.di.appModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class CsvReaderApplication : SplitCompatApplication(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@CsvReaderApplication))
        import(appModule)
        importAll(FeatureManager.kodeinModules)
    }
}
