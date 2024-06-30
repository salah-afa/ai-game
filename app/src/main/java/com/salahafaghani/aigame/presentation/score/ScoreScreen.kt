package com.salahafaghani.aigame.presentation.score

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.salahafaghani.aigame.common.Constant
import com.salahafaghani.aigame.presentation.nav.Routes
import com.salahafaghani.aigame.ui.theme.AIMathGameTheme

@Composable
fun ScoreScreen(navController: NavController, score: Int) {

    Scaffold { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            Text(
                text = "Your Score",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "$score/${Constant.NUMBER_OF_QUESTIONS}",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(50.dp))

            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("BACK", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL)
@Composable
fun WelcomePreview() {
    AIMathGameTheme {
        Scaffold { _ ->
            ScoreScreen(rememberNavController(), 5)
        }
    }
}