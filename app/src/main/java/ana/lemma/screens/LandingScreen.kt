package ana.lemma.screens

import ana.lemma.R
import ana.lemma.R.string.mid_text
import ana.lemma.R.string.next
import ana.lemma.R.string.title
import ana.lemma.R.string.welcome_landing
import ana.lemma.components.ButtonComponent
import ana.lemma.components.NormalTextComponent
import ana.lemma.nav.AidWayAppRouter
import ana.lemma.nav.Screen
import ana.lemma.ui.theme.Primary
import ana.lemma.ui.theme.Secondary
import ana.lemma.ui.theme.SubTextColor
import ana.lemma.ui.theme.TextColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LandingScreen() {

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Primary)) {
            NormalTextComponent(value = stringResource(id = welcome_landing), size = 50.sp, color = TextColor, height = 10.dp)
            NormalTextComponent(value = stringResource(id = title), size = 50.sp, color = Secondary, height = 60.dp)
            Spacer(modifier = Modifier.height(120.dp))
            NormalTextComponent(value = stringResource(id = mid_text), size = 25.sp, color = SubTextColor , height = 30.dp)
            
            Image(painter = painterResource(id = R.drawable.landing_ambulance)
                , contentDescription = stringResource(id = R.string.landing_ambulance))
            
            Spacer(modifier = Modifier.height(50.dp))
            ButtonComponent(value = stringResource(id = next),
                onButtonClick = {
                    AidWayAppRouter.navigateTo(Screen.EntryScreen)
                })
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfLandingScreen() {
    LandingScreen()
}