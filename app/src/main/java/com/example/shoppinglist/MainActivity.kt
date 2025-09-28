package com.example.shoppinglist

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.ProgressBar

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoppinglist.screen.QuoteDetail
import com.example.shoppinglist.screen.QuoteListScreen
import com.example.shoppinglist.ui.theme.DataManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {

            App()
        }
    }

}

@Composable
fun App() {
    if(DataManager.isDataLoaded){
        if(DataManager.currentPage == Pages.LISTING){
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        }else{
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }

    }else{
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}


enum class Pages{
    LISTING,
    DETAIL
}