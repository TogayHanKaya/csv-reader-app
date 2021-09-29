package com.thk.feature_reader.data

import android.content.Context
import com.thk.csv_parser.CsvParser
import com.thk.feature_reader.R
import com.thk.feature_reader.domain.repository.ReaderRepository
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

class ReaderRepositoryImpl(
    private val parser: CsvParser,
    private val context: Context
) : ReaderRepository {

    override suspend fun getLineList(fileName: String): List<List<String>> {
        return parser.parseCsv(readCsvFile(context, fileName))
    }

    private fun readCsvFile(context: Context, fileName: String): String {
        File(fileName)
            .also { file ->
                try {
                    if (!file.exists()) {
                        val stringBuilder = StringBuilder()
                        context.assets.open(fileName).use { inputStream ->
                            BufferedReader(InputStreamReader(inputStream)).use { reader ->
                                var line: String? = reader.readLine()
                                while (line != null) {
                                    stringBuilder.append(line)
                                    line = reader.readLine()
                                    if (line != null) stringBuilder.append('\n')
                                }
                            }
                        }
                        return stringBuilder.toString()
                    }
                } catch (e: Exception) {
                    return e.stackTraceToString()
                }
            }
        return context.getString(R.string.error_unknown)
    }
}