package com.example.shoppinglist.ui.theme

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import models.Quote

object DataManager {
    var data: List<Quote> = emptyList()
    var isDataLoaded by mutableStateOf(false)

    fun loadAssetsFromFile(context: Context) {
        val json = context.assets.open("quotes.json")
            .bufferedReader()
            .use { it.readText() }

        val type = object : TypeToken<List<Quote>>() {}.type
        data = Gson().fromJson(json, type)
        isDataLoaded = true
    }
}