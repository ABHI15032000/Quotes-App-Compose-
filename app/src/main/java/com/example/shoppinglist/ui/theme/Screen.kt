package com.example.shoppinglist.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.shoppinglist.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun BlogContent() {
    Card(
        modifier = Modifier.padding(8.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .padding(4.dp)
            )
            Column() {
                Text(text = "Programming", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Learn diff language", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Thin)
            }

        }
    }
}