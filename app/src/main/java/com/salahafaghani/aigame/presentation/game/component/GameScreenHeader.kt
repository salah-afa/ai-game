package com.salahafaghani.aigame.presentation.game.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.salahafaghani.aigame.domain.model.GameLevel
import com.salahafaghani.aigame.domain.model.GameSubject

@Composable
fun GameScreenHeader(
    subject: GameSubject,
    level: GameLevel,
    onClose: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        FilledIconButton(
            onClick = {
                onClose()
            },
            modifier = Modifier
                .padding(16.dp)
                .size(24.dp)
        ) {
            Icon(Icons.Default.Close, contentDescription = "Close")
        }

        Text(
            "${subject.value} ($level)",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}