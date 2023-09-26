package ana.lemma.app

import ana.lemma.nav.AidWayAppRouter
import ana.lemma.nav.Screen
import ana.lemma.screens.EntryScreen
import ana.lemma.screens.LandingScreen
import ana.lemma.ui.theme.Primary
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OneWayAidApp() {
    Surface(modifier = Modifier.fillMaxSize(),
            color = Primary
        ) {
        Crossfade(targetState = AidWayAppRouter.currentScreen, label = "boot-crossfade") { currentState ->
            when (currentState.value) {
                is Screen.LandingScreen -> {
                    LandingScreen()
                }
                is Screen.EntryScreen -> {
                    EntryScreen()
                }
            }
            
        }
    }
}