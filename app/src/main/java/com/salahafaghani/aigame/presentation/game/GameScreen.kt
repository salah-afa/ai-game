package com.salahafaghani.aigame.presentation.game

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.navigation.NavController
import com.salahafaghani.aigame.domain.model.GameLevel
import com.salahafaghani.aigame.domain.model.GameSubject
import com.salahafaghani.aigame.presentation.common.ErrorAlertDialog
import com.salahafaghani.aigame.presentation.common.IndefiniteProgressIndicator
import com.salahafaghani.aigame.presentation.game.component.Answers
import com.salahafaghani.aigame.presentation.game.component.ControlButtons
import com.salahafaghani.aigame.presentation.game.component.GameScreenHeader
import com.salahafaghani.aigame.presentation.nav.Routes
import com.salahafaghani.aigame.ui.theme.AIMathGameTheme

@Composable
fun GameScreen(navController: NavController, subject: GameSubject, level: GameLevel, viewModel: GameViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    LifecycleEventEffect(Lifecycle.Event.ON_CREATE) {
        println("GameScreen -> ON_CREATE")
        viewModel.getNewGame(subject, level)
    }

    GameScreenContent(
        subject = subject,
        level = level,
        uiState = uiState,
        onClose = { navController.popBackStack() },
        onSelectAnswer = { viewModel.selectAnswer(it) },
        onNextQuestion = {
            viewModel.nextQuestion(onSubmit = {
                navController.popBackStack()
                navController.navigate(Routes.ScoreScreenRoute(score = viewModel.score))
            })
        },
        onPreviousQuestion = { viewModel.previousQuestion() },
        onDismissError = { navController.popBackStack() }
    )
}

@Composable
fun GameScreenContent(
    subject: GameSubject,
    level: GameLevel,
    uiState: GameUiState,
    onClose: () -> Unit,
    onSelectAnswer: (Int) -> Unit,
    onNextQuestion: () -> Unit,
    onPreviousQuestion: () -> Unit,
    onDismissError: () -> Unit
) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (uiState.isLoading) {
                IndefiniteProgressIndicator()
            } else {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {

                    GameScreenHeader(subject = subject, level = level) {
                        onClose()
                    }

                    Text(
                        "Question ${uiState.questionNumber}",
                        style = MaterialTheme.typography.headlineLarge
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    Text(
                        uiState.currentQuestion,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Answers(
                        answers = uiState.currentAnswers,
                        selectedAnswer = uiState.currentSelectedAnswer,
                        onSelectAnswer = {
                            onSelectAnswer(it)
                        })

                    Spacer(modifier = Modifier.weight(1.0f))

                    ControlButtons(uiState = uiState, onNextQuestion = onNextQuestion, onPreviousQuestion = onPreviousQuestion)

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            if (!uiState.error.isNullOrEmpty()) {
                ErrorAlertDialog(title = "Error", message = uiState.error ?: "") {
                    onDismissError()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL)
@Composable
fun GamePreview() {
    AIMathGameTheme {
        GameScreenContent(
            subject = GameSubject.DATA_STRUCTURE,
            level = GameLevel.MEDIUM,
            uiState = GameUiState(
                currentQuestion = "Which algorithm is used to find the shortest path in a graph with non-negative edge weights?",
                currentAnswers = listOf(
                    "The process of dividing a large problem into smaller subproblems",
                    "The process of solving a problem by reducing it to smaller instances of the same problem",
                    "60",
                    "80"
                ),
                currentSelectedAnswer = 2
            ),
            onClose = {},
            onSelectAnswer = {},
            onNextQuestion = {},
            onPreviousQuestion = {}) {
            
        }
    }
}