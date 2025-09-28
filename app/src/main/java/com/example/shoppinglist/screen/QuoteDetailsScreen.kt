package com.example.shoppinglist.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import models.Quote


@Composable
 fun QuoteDetail(quote: Quote) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color.Red,
                        Color.LightGray
                    )
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp, 24.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.Info,
                    colorFilter = ColorFilter.tint(Color.Blue),
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)
                )

                Text(
                    quote.text,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily.Monospace
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    quote.author,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Thin,
                    fontFamily = FontFamily.Cursive
                )
            }
        }
    }
}
