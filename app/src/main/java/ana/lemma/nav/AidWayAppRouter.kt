package ana.lemma.nav

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
    object LandingScreen: Screen()
    object EntryScreen: Screen()
}

object AidWayAppRouter {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.LandingScreen)

    fun navigateTo(destination: Screen) {
        currentScreen.value = destination
    }
}