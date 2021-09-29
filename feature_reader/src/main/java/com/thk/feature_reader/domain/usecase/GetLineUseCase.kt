package com.thk.feature_reader.domain.usecase

import com.thk.feature_reader.domain.repository.ReaderRepository
import java.io.IOException

class GetLineUseCase(
    private val readerRepository: ReaderRepository
) {
    sealed class Result {
        data class Success(val data: List<List<String>>) : Result()
        data class Error(val e: Throwable) : Result()
    }

    suspend fun execute(fileName: String): Result {
        return try {
            Result.Success(readerRepository.getLineList(fileName))
        } catch (e: IOException) {
            Result.Error(e)
        }
    }
}