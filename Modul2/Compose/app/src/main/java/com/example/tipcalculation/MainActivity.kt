package com.example.tipcalculation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions
import java.text.NumberFormat
import kotlin.math.ceil
import androidx.compose.ui.tooling.preview.Preview as Preview1
import androidx.compose.material.icons.Icons

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipCalculatorApp() {
    var amountInput by remember { mutableStateOf("") }
    var tipPercent by remember { mutableDoubleStateOf(0.18) }
    var roundUp by remember { mutableStateOf(true) }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    var tip = amount * tipPercent
    if (roundUp) tip = ceil(tip)

    val formattedTip = "$" + String.format("%.2f", tip)
    val percentageOptions = listOf(0.15, 0.18, 0.20)
    val expanded = remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)) {

        Text(text = "Calculate Tip", style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = amountInput,
            onValueChange = { amountInput = it },
            label = { Text("Bill Amount") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        ExposedDropdownMenuBox(
            expanded = expanded.value,
            onExpandedChange = { expanded.value = !expanded.value }
        ) {
            OutlinedTextField(
                readOnly = true,
                value = "${(tipPercent * 100).toInt()}%",
                onValueChange = {},
                label = { Text("Tip Percentage") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded.value)
                },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false }
            ) {
                percentageOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text("${(option * 100).toInt()}%") },
                        onClick = {
                            tipPercent = option
                            expanded.value = false
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Round up tip?")
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = roundUp,
                onCheckedChange = { roundUp = it }
            )
        }

        Spacer(Modifier.height(32.dp))

        Text(
            text = "Tip Amount:",
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = formattedTip,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview1(showBackground = true)
@Composable
fun TipCalculatorAppPreview() {
    TipCalculatorApp()
}