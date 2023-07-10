package com.pidzama.comicsdreamsapp.util

import androidx.room.TypeConverter

class DatabaseTypeConverter {

    @TypeConverter
    fun convertListToString(list: List<String>): String {
        return list.joinToString(separator = ",")
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(",")
    }

}