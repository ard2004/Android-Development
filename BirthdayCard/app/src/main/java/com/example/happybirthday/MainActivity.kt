package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                /* A Surface is a container that represents a section of UI where you can alter the appearance, such as the background color or border.*/
               Surface(modifier = Modifier.fillMaxSize(),
                           color = MaterialTheme.colorScheme.background){
                   GreetingImage()
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String,from:String,modifier:Modifier=Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier // It is recommended to always pass modifier from child
    ) {
        Text(
            text = message,
            fontSize = 25.sp,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
        Text(
            text = from,
            fontSize = 25.sp,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(modifier: Modifier=Modifier){
    val image = painterResource(R.drawable.androidparty)
    Box(modifier=modifier) {
        Image(// Our Aim is to provide user an experience that solves a purpose, and make the user come to the app again and again
            painter = image,
            contentDescription = null, //so that Talk back skips it
            contentScale = ContentScale.Crop,// To scale the image such that maintaining aspect ratio the image's width and height is equal to or greater than the screen dimension
            alpha = 0.4F
            )
        GreetingText(message = stringResource(R.string.happy_birthday_text),from= stringResource(R.string.signature_text),modifier=Modifier.fillMaxSize()) // Hardcoded strings make it harder to translate
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingTextPreview() {
    HappyBirthdayTheme {
        GreetingImage(Modifier)//Modifiers are used to decorate or add behavior to Jetpack Compose UI elements
    }
}
/* Revision

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}
difference between
textAlign = TextAlign.Center
 .align(alignment = Alignment.End)
Quick Analogy:
Imagine a sticky note with handwriting on it:

textAlign.Center is like centering the handwriting on the sticky note.

.align(Alignment.End) is like sticking that sticky note to the right side of your monitor.
* textAlign → controls how the text looks inside the Text composable
* Modifier.align() → controls where the Text composable sits in its parent layout
* */