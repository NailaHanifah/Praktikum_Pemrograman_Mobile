package com.example.tipcalculation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import kotlin.math.ceil

class XmlActivity : AppCompatActivity() {

    private lateinit var costEditText: EditText
    private lateinit var tipResult: TextView
    private lateinit var tipOptions: RadioGroup
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var roundUpSwitch: Switch
    private lateinit var switchToCompose: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml)

        // Inisialisasi view
        costEditText = findViewById(R.id.costOfServiceEditText)
        tipResult = findViewById(R.id.tipResult)
        tipOptions = findViewById(R.id.tipOptions)
        roundUpSwitch = findViewById(R.id.roundUpSwitch)

        // Hitung tip saat user menekan enter
        costEditText.setOnEditorActionListener { _, _, _ ->
            calculateTip()
            true
        }
    }

    private fun calculateTip() {
        val cost = costEditText.text.toString().toDoubleOrNull()
        if (cost == null) {
            tipResult.text = ""
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
