package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {

        Scaffold(
          modifier = Modifier.fillMaxSize(),

          ) { padding ->
          GreetingImage(
            name = "Raihan",
            from = "Firdaus",
            modifier = Modifier
              .fillMaxSize()
              .padding(padding)
              .background(color = Color.White)
          )
        }

      }
    }
  }
}

@Composable
fun ComposeArticle() {
  val srcImage = painterResource(R.drawable.bg_compose_background)
  Column(
    modifier = Modifier
      .fillMaxSize()
      .statusBarsPadding()
  ) {
    Image(
      painter = srcImage,
      contentDescription = null,
      modifier = Modifier.fillMaxWidth(),
      contentScale = ContentScale.Fit
    )
    Text(
      text = "Jetpack Compose tutorial",
      fontSize = 24.sp,
      modifier = Modifier.padding(16.dp)
    )
    Text(
      text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
      modifier = Modifier.padding(start = 16.dp, end = 16.dp),
      textAlign = TextAlign.Justify
    )
    Text(
      text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
      modifier = Modifier.padding(16.dp),
      textAlign = TextAlign.Justify
    )
  }
}

@Composable
fun ComposeQuadrant () {
  val items: List<Map<String, Any>> = listOf(
    mapOf(
      "title" to "Text composable",
      "description" to "Displays text and follows the recommended Material Design guidelines.",
      "color" to Color(0xFFEADDFF)
    ),
    mapOf(
      "title" to "Image composable",
      "description" to "Creates a composable that lays out and draws a given Painter class object.",
      "color" to Color(0xFFD0BCFF)
    ),
    mapOf(
      "title" to "Row composable",
      "description" to "A layout composable that places its children in a horizontal sequence.",
      "color" to Color(0xFFB69DF8)
    ),
    mapOf(
      "title" to "Column composable",
      "description" to "A layout composable that places its children in a vertical sequence.",
      "color" to Color(0xFFF6EDFF)
    ),
  )

  LazyVerticalGrid(
    columns = GridCells.Adaptive(minSize = 128.dp),
    contentPadding = PaddingValues(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    items(items.size) { index ->
      val item = items[index]
      val title = item["title"] as String
      val description = item["description"] as String
      val bgColor = item["color"] as Color

      Column(
        modifier = Modifier
          .background(bgColor)
          .padding(16.dp)
          .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = title,
          fontWeight = FontWeight.Bold,
          modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
          text = description,
          textAlign = TextAlign.Justify
        )
      }
    }
  }
}

@Composable
fun Greeting(
  name: String,
  sender: String,
  modifier: Modifier = Modifier
) {
  Box(
    modifier = modifier
      .fillMaxSize()
      .padding(20.dp)
  ) {
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = "Happy Birthday $name",
        textAlign = TextAlign.Center,
        fontSize = 70.sp,
        lineHeight = 70.sp,
        color = Color.Red
      )
      Text(
        text = "From $sender",
        fontSize = 30.sp,
        modifier = Modifier
          .fillMaxWidth()
          .padding(10.dp),
        textAlign = TextAlign.End,
        color = Color.Red
      )
    }
  }
}


@Composable
fun GreetingImage(
  name: String,
  from: String,
  modifier: Modifier = Modifier
) {
  Box(modifier = modifier) {
    Image(
      painter = painterResource(R.drawable.androidparty),
      contentDescription = null,
      modifier = Modifier.fillMaxSize(),
      contentScale = ContentScale.Crop
    )
    Greeting(
      name = name,
      sender = from,
      modifier = Modifier.fillMaxSize()
    )
  }
}


@Preview
@Composable
fun GreetingImagePreview() {
  GreetingImage(
    name = "Raihan",
    from = "Firdaus",
    modifier = Modifier.fillMaxSize()
  )
}

//@Preview(showBackground = false)
//@Composable
//fun GreetingPreview() {
//  MyApplicationTheme {
//    Greeting(name = "Bahlil", sender = "Raihan")
//  }
//}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeArticlePreview() {
  ComposeArticle()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeQuadrantPreview() {
  ComposeQuadrant()
}

