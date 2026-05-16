package com.example.tipcalculation

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var costEditText: EditText
    private lateinit var tipResult: TextView
    private lateinit var tipOptions: RadioGroup
    private lateinit var roundUpSwitch: Switch
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml)

        costEditText = findViewById(R.id.costOfServiceEditText)
        tipResult = findViewById(R.id.tipResult)
        tipOptions = findViewById(R.id.tipOptions)
        roundUpSwitch = findViewById(R.id.roundUpSwitch)
        calculateButton = findViewById(R.id.calculateButton)

        // Listener tombol Calculate
        calculateButton.setOnClickListener {
            calculateTip()
        }

        // Listener keyboard Done
        costEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                calculateTip()
                true
            } else {
                false
            }
        }
    }

    private fun calculateTip() {
        val cost = costEditText.text.toString().toDoubleOrNull()
        if (cost == null || cost == 0.0) {
            tipResult.text = getString(R.string.tip_default)
            return
        }

        val tipPercentage = when (tipOptions.checkedRadioButtonId) {
            R.id.optionTwenty -> 0.20
            R.id.optionEighteen -> 0.18
            R.id.optionFifteen -> 0.15
            else -> 0.15
        }

        var tip = cost * tipPercentage
        if (roundUpSwitch.isChecked) {
            tip = ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}