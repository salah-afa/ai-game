package com.salahafaghani.aigame.presentation.welcome.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.salahafaghani.aigame.domain.model.GameSubject

@Composable
fun QuestionSubject(
    modifier: Modifier = Modifier,
    value: GameSubject,
    onValueChange: (GameSubject) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "Choose question subject",
            style = MaterialTheme.typography.titleMedium
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = value == GameSubject.DATA_STRUCTURE,
                colors = RadioButtonColors(
                    selectedColor = MaterialTheme.colorScheme.secondary,
                    unselectedColor = MaterialTheme.colorScheme.secondary,
                    disabledSelectedColor = MaterialTheme.colorScheme.secondaryContainer,
                    disabledUnselectedColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                onClick = {
                    onValueChange(GameSubject.DATA_STRUCTURE)
                }
            )

            Text(text = "Data Structure", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.width(10.dp))

            RadioButton(
                selected = value == GameSubject.ALGORITHM,
                colors = RadioButtonColors(
                    selectedColor = MaterialTheme.colorScheme.secondary,
                    unselectedColor = MaterialTheme.colorScheme.secondary,
                    disabledSelectedColor = MaterialTheme.colorScheme.secondaryContainer,
                    disabledUnselectedColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                onClick = {
                    onValueChange(GameSubject.ALGORITHM)
                }
            )

            Text(text = "Algorithm", style = MaterialTheme.typography.bodyMedium)
        }
    }
}