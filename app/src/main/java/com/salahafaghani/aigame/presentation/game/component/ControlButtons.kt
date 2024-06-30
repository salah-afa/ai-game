package com.salahafaghani.aigame.presentation.game.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.salahafaghani.aigame.presentation.game.GameUiState

@Composable
fun ControlButtons(
    uiState: GameUiState,
    onPreviousQuestion: () -> Unit,
    onNextQuestion: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    ) {
        FilledIconButton(
            enabled = uiState.questionNumber > 1,
            onClick = {
                onPreviousQuestion()
            },
            modifier = Modifier
                .padding(16.dp)
                .size(50.dp)
        ) {
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Back"
            )
        }

        val animatedNextColor = animateColorAsState(
            targetValue = if (uiState.isLastQuestion) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary,
            animationSpec = tween(1000, 0, FastOutSlowInEasing),
            label = "next"
        )

        FilledIconButton(
            onClick = {
                onNextQuestion()
            },
            colors = IconButtonColors(
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = animatedNextColor.value,
                disabledContentColor = MaterialTheme.colorScheme.onSurface,
                disabledContainerColor = MaterialTheme.colorScheme.surfaceDim
            ),
            modifier = Modifier
                .padding(16.dp)
                .size(50.dp)
        ) {
            Icon(
                if (uiState.isLastQuestion) Icons.Default.Check else Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Next"
            )
        }
    }
}