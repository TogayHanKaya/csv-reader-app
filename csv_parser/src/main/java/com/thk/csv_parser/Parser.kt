package com.thk.csv_parser

interface Parser {
    fun parseCsv(rawData: String) : List<List<String>>
    fun parseCsvRow(rowData: String) : List<String>
}