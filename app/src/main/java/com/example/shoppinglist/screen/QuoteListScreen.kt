package com.example.shoppinglist.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import models.Quote

@Composable
fun QuoteListScreen(data: List<Quote>, onClick: (quote: Quote) -> Unit) {

    Column {
        Text(
            "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 24.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.bodyMedium,
            fontFamily = FontFamily.Serif
        )
        QuoteList(data,onClick)
    }
}