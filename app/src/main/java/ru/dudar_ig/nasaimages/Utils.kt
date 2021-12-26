package ru.dudar.nasaimage

import java.text.SimpleDateFormat
import java.util.*

object Utils {

        fun getDateStr(): String {
            val date = Date()
            val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            return formatter.format(date)
    }
}