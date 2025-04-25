package com.example.homescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.homescreen.ui.theme.HomeScreenTheme

/*
* A single component having both home screen image and home screen text
* */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeScreenTheme {
                Column {
                    HomeScreen(Modifier)
                }
            }
            }
        }
    }

@Composable
fun HomeImage( modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.mama)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha=0.7f,
            modifier = modifier
                .padding(1.dp)
        )
}

@Composable
fun HomeText(modifier: Modifier = Modifier) {
    val textValue = stringResource(R.string.son_name)
    Row(verticalAlignment = Alignment.Bottom,
        modifier = Modifier.fillMaxSize() // Here used Modifier not 'modifier'
        ) { // Used Row so that filling max size and then put the text compose at bottom alignment


            Text(
                text = textValue,
                fontSize = 25.sp,
                lineHeight = 30.sp,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(10.dp, 0.dp, 10.dp, 150.dp)
            )
    }
}
@Composable
fun HomeScreen(modifier: Modifier){
    HomeScreenTheme {
        Box(Modifier){
            HomeImage(modifier)
            HomeText(modifier)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeImagePreview() {
    HomeScreenTheme {
        HomeImage(Modifier)
        HomeText(Modifier)
    }
}