package com.example.shoppinglist.ui.theme

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.shoppinglist.Pages
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import models.Quote

object DataManager {
    var data: List<Quote> = emptyList()
    var currentPage by mutableStateOf(Pages.LISTING)
    var isDataLoaded by mutableStateOf(false)
    var currentQuote: Quote? = null

    fun loadAssetsFromFile(context: Context) {
        val json = context.assets.open("quotes.json")
            .bufferedReader()
            .use { it.readText() }

        val type = object : TypeToken<List<Quote>>() {}.type
        data = Gson().fromJson(json, type)
        isDataLoaded = true
    }

    fun switchPages(quote: Quote?){
        if(currentPage== Pages.LISTING){
            currentQuote = quote
            currentPage = Pages.DETAIL
        }else{
            currentPage = Pages.LISTING
        }
    }
}