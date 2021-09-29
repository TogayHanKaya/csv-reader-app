package com.thk.feature_reader.presentation

import androidx.fragment.app.Fragment
import com.thk.csvreader.base.di.KotlinViewModelProvider
import com.thk.feature_reader.MODULE_NAME
import com.thk.feature_reader.presentation.list.LineListAdapter
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

internal val presentationModule = Kodein.Module("${MODULE_NAME}PresentationModule") {
    bind<ReaderViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) { ReaderViewModel(instance()) }
    }

    bind() from singleton { LineListAdapter() }
}
