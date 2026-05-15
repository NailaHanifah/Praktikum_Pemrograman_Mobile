package com.example.doubledice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceApp()
        }
    }
}

@Composable
fun DiceApp() {
    var dice1 by remember { mutableIntStateOf(R.drawable.dice_0) }
    var dice2 by remember { mutableIntStateOf(R.drawable.dice_0) }
    var resultText by remember { mutableStateOf("") }

    val diceImages = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Row {
            Image(painter = painterResource(id = dice1), contentDescription = null, modifier = Modifier.size(100.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Image(painter = painterResource(id = dice2), contentDescription = null, modifier = Modifier.size(100.dp))
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            dice1 = diceImages.random()
            dice2 = diceImages.random()
            resultText = if (dice1 == dice2) "Selamat, anda dapat dadu double!" else "Anda belum beruntung!"
        }) {
            Text("Roll")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = resultText, fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DiceAppPreview() {
    DiceApp()
}
