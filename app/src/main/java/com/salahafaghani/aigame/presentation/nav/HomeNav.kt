package com.salahafaghani.aigame.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.salahafaghani.aigame.domain.model.GameLevel
import com.salahafaghani.aigame.domain.model.GameSubject
import com.salahafaghani.aigame.presentation.game.GameScreen
import com.salahafaghani.aigame.presentation.score.ScoreScreen
import com.salahafaghani.aigame.presentation.welcome.WelcomeScreen
import kotlinx.serialization.Serializable

@Composable
fun HomeNav() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.WelcomeScreenRoute
    ) {
        composable<Routes.WelcomeScreenRoute> {
            WelcomeScreen(navController = navController)
        }
        composable<Routes.GameScreenRoute> {
            val args = it.toRoute<Routes.GameScreenRoute>()
            GameScreen(navController = navController, subject = GameSubject.parse(args.subject), level = GameLevel.parse(args.level))
        }
        composable<Routes.ScoreScreenRoute> {
            ScoreScreen(navController = navController, score = it.toRoute<Routes.ScoreScreenRoute>().score)
        }
    }
}

@Serializable
sealed class Routes {
    @Serializable
    object WelcomeScreenRoute

    @Serializable
    data class GameScreenRoute(val subject: String, val level: Int)

    @Serializable
    data class ScoreScreenRoute(val score: Int)
}
