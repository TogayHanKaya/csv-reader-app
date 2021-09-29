package com.thk.feature_reader.domain.repository

interface ReaderRepository {

    suspend fun getLineList(fileName: String): List<List<String>>
}