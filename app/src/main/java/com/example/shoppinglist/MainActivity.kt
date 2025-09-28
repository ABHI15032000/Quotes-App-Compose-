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
            delay(10000)
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
        QuoteListScreen(data = DataManager.data) { }
    }else{
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}



//
//
//@Composable
//fun MyApp(modifier: Modifier = Modifier) {
//
//    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
//
//    Surface(modifier, color = MaterialTheme.colorScheme.background) {
//        if (shouldShowOnboarding) {
//            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
//        } else {
//            Greetings()
//        }
//    }
//}
//
//@Composable
//fun OnboardingScreen(
//    onContinueClicked: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//
//    Column(
//        modifier = modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Welcome to the Basics Codelab!")
//        Button(
//            modifier = Modifier.padding(vertical = 24.dp),
//            onClick = onContinueClicked
//        ) {
//            Text("Continue")
//        }
//
//    }
//}
//
//@Composable
//private fun Greetings(
//    modifier: Modifier = Modifier,
//    names: List<String> = List(10){"$it"}
//) {
//    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
//        items(items=names){ name ->
//            Greeting(name)
//        }
//    }
//}
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Card(
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.primary
//        ),
//        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        CardContent(name)
//    }
//}
//@Composable
//private fun CardContent(name: String) {
//    var expanded by rememberSaveable { mutableStateOf(false) }
//
//    Row(
//        modifier = Modifier
//            .padding(12.dp)
//            .animateContentSize(
//                animationSpec = spring(
//                    dampingRatio = Spring.DampingRatioMediumBouncy,
//                    stiffness = Spring.StiffnessLow
//                )
//            )
//    ) {
//        Column(
//            modifier = Modifier
//                .weight(1f)
//                .padding(12.dp)
//        ) {
//            Text(text = "Hello, ")
//            Text(
//                text = name, style = MaterialTheme.typography.headlineMedium.copy(
//                    fontWeight = FontWeight.ExtraBold
//                )
//            )
//            if (expanded) {
//                Text(
//                    text = ("Composem ipsum color sit lazy, " +
//                            "padding theme elit, sed do bouncy. ").repeat(4),
//                )
//            }
//        }
//        IconButton(onClick = { expanded = !expanded }) {
//            Icon(
//                imageVector = if (expanded) Icons.Filled.ArrowDropDown else Icons.Filled.KeyboardArrowUp,
//                contentDescription = if (expanded) {
//                    stringResource(R.string.show_less)
//                } else {
//                    stringResource(R.string.show_more)
//                }
//            )
//        }
//    }
//}

//@Preview(showBackground = true, widthDp = 320, heightDp = 320)
//@Composable
//fun OnboardingPreview() {
//    ShoppingListTheme {
//        OnBoardingScreen()
//    }
//}


//    @Composable
//    fun BoxWithCoroutine() {
//        var username by remember { mutableStateOf("") }
//        var result by remember { mutableStateOf("") }
//        Column {
//            Text(text = "Enter Your Name")
//            TextField(
//                value = username,
//                onValueChange = { username = it },
//                label = { Text("You name") },
//                singleLine = true
//            )
//            Button(onClick = {
//                var value = (1..2).random()
//                if(value == 1){
//                    result = "You are Qualified"
//                }else{
//                    result = "Sorry :("
//                }
//            }) {
//                Text(text = "Check you UPSC CSE 2026 Result")
//            }
//
//            Text(text = result)
//        }
//    }


