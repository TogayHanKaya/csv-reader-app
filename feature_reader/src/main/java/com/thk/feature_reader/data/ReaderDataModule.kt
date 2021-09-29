package com.thk.feature_reader.data

import com.thk.csv_parser.CsvParser
import com.thk.feature_reader.MODULE_NAME
import com.thk.feature_reader.domain.repository.ReaderRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

internal val dataModule = Kodein.Module("${MODULE_NAME}DataModule") {
    bind() from singleton { CsvParser() }
    bind<ReaderRepository>() with singleton { ReaderRepositoryImpl(instance(), instance()) }
}
