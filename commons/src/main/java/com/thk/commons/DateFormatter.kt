package com.thk.commons

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun String.formatAsDate(receivedFormat: String, desiredFormat: String) : String {
    val receivedFormatter = DateTimeFormatter.ofPattern(receivedFormat)
    val desiredFormatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern(desiredFormat)
    val date = LocalDate.parse(this, receivedFormatter)
    return date.format(desiredFormatter)
}