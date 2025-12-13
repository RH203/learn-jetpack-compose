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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
  MyApplicationTheme {
    Greeting(name = "Bahlil", sender = "Raihan")
  }
}