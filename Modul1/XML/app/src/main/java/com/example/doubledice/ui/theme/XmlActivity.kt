package com.example.doubledice.ui.theme

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.doubledice.R

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage1: ImageView
    private lateinit var diceImage2: ImageView
    private lateinit var resultText: TextView

    private val diceImages = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage1 = findViewById(R.id.diceImage1)
        diceImage2 = findViewById(R.id.diceImage2)
        resultText = findViewById(R.id.resultText)

        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice1 = diceImages.random()
        val dice2 = diceImages.random()

        diceImage1.setImageResource(dice1)
        diceImage2.setImageResource(dice2)

        resultText.text = if (dice1 == dice2) {
            "Selamat, anda dapat dadu double!"
        } else {
            "Anda belum beruntung!"
        }
    }
}
