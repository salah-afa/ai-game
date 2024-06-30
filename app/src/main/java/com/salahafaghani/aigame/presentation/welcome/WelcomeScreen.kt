package com.salahafaghani.aigame.presentation.welcome

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.salahafaghani.aigame.domain.model.GameSubject
import com.salahafaghani.aigame.presentation.nav.Routes
import com.salahafaghani.aigame.presentation.welcome.component.DifficultyLevel
import com.salahafaghani.aigame.presentation.welcome.component.QuestionSubject
import com.salahafaghani.aigame.ui.theme.AIMathGameTheme

@Composable
fun WelcomeScreen(navController: NavController) {
    WelcomeScreenContent(
        onStartGame = { subject, level ->
            navController.navigate(Routes.GameScreenRoute(subject = subject, level = level))
        }
    )
}

@Composable
fun WelcomeScreenContent(
    onStartGame: (subject: String, level: Int) -> Unit
) {
    var selectedSubject by remember { mutableStateOf(GameSubject.DATA_STRUCTURE) }
    var selectedLevel by remember { mutableFloatStateOf(1f) }

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Text(
                    text = "AI Game",
                    style = MaterialTheme.typography.headlineLarge
                )

                Spacer(modifier = Modifier.height(100.dp))

                QuestionSubject(
                    modifier = Modifier.fillMaxWidth(),
                    value = selectedSubject,
                    onValueChange = { selectedSubject = it }
                )

                Spacer(modifier = Modifier.height(20.dp))

                HorizontalDivider(thickness = 2.dp, modifier = Modifier.padding(horizontal = 30.dp))

                Spacer(modifier = Modifier.height(20.dp))

                DifficultyLevel(
                    modifier = Modifier.fillMaxWidth(),
                    value = selectedLevel,
                    onValueChange = { selectedLevel = it }
                )

                Spacer(modifier = Modifier.height(100.dp))

                Button(onClick = {
                    onStartGame(selectedSubject.value, selectedLevel.toInt())
                }) {
                    Text("START", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL)
@Composable
fun WelcomePreview() {
    AIMathGameTheme {
        WelcomeScreenContent(
            onStartGame = { _, _ -> }
        )
    }
}