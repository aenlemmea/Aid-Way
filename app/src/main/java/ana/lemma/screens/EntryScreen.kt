package ana.lemma.screens

import ana.lemma.R
import ana.lemma.components.HeadingTextComponent
import ana.lemma.components.TextEntryField
import ana.lemma.nav.AidWayAppRouter
import ana.lemma.nav.Screen
import ana.lemma.nav.SystemBackButtonHandler
import ana.lemma.ui.theme.Primary
import android.app.Activity
import android.content.ContentValues.TAG
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.auth.api.identity.Identity

@Composable
fun EntryScreen() {
    Surface (
        modifier = Modifier
            .fillMaxWidth()
            .background(Primary)
    ) {
        Column (Modifier.fillMaxSize().background(Primary)){
            HeadingTextComponent(value = stringResource(id = R.string.entry))
            Spacer(modifier = Modifier.height(120.dp))
            TextEntryField(label = stringResource(id = R.string.phone_entry))
        }

    }

    SystemBackButtonHandler {
        AidWayAppRouter.navigateTo(Screen.LandingScreen)
    }
}

@Preview
@Composable
fun PreviewEntryScreen() {
    EntryScreen()
}