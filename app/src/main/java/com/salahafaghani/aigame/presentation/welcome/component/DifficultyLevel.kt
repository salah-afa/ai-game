package com.salahafaghani.aigame.presentation.welcome.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DifficultyLevel(modifier: Modifier = Modifier, value: Float, onValueChange: (Float) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "Choose difficulty level",
            style = MaterialTheme.typography.titleMedium
        )

        Slider(
            value = value,
            onValueChange = onValueChange,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 1,
            valueRange = 1f..3f,
            modifier = Modifier.width(260.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(260.dp)
        ) {
            Text(text = "entry", style = MaterialTheme.typography.bodyMedium)

            Text(text = "medium", style = MaterialTheme.typography.bodyMedium)

            Text(text = "advanced", style = MaterialTheme.typography.bodyMedium)
        }
    }
}