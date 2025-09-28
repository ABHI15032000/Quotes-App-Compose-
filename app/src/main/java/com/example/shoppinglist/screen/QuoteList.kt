package com.example.shoppinglist.screen

import QuoteListItem
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import models.Quote

@Composable
fun QuoteList(data: List<Quote>, onClick: (quote: Quote) -> Unit) {
    LazyColumn(content = {
        items(data) {
            QuoteListItem(quote = it,onClick)
        }
    })

}