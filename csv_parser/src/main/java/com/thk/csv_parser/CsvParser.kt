package com.thk.csv_parser

class CsvParser : Parser {

    override fun parseCsv(rawData: String): List<List<String>> {
        val rows = rawData.split('\n')
        val result = mutableListOf<List<String>>()
        rows.forEach {
            result.add(parseCsvRow(it))
        }

        return result
    }

    override fun parseCsvRow(rowData: String): List<String> {
        if (rowData.isEmpty()) {
            return listOf()
        }

        return rowData.split(',').map { column ->
            when(column.toIntOrNull()) {
                null -> column
                    .trim()
                    .drop(1)
                    .dropLast(1)
                else -> column
            }
        }
    }
}