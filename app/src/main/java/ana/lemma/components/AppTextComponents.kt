package ana.lemma.components

import ana.lemma.ui.theme.Accent
import ana.lemma.ui.theme.Secondary
import ana.lemma.ui.theme.TextColor
import android.app.Activity
import android.app.PendingIntent
import android.content.ContentValues.TAG
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest
import com.google.android.gms.auth.api.identity.Identity

@Composable
fun NormalTextComponent(value: String, size: TextUnit, color: Color, height: Dp) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = height),
        style = TextStyle(
            fontSize = size,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Normal,
        )
        , color = color
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp, top = 30.dp, end = 0.dp, bottom = 0.dp),
        style = TextStyle(
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Normal
        ), color = Secondary,
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextEntryField(label: String) {

    val phoneNumberHintIntentResultLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartIntentSenderForResult()
        ) { result ->
            try {
            } catch (e: Exception) {
                Log.e(TAG, "Phone Number Hint failed")
            }
        }

    val activity = LocalContext.current as Activity

    val getPhoneNumberHint = {
        val request: GetPhoneNumberHintIntentRequest =
            GetPhoneNumberHintIntentRequest.builder().build()
        try {
            Identity.getSignInClient(activity)
                .getPhoneNumberHintIntent(request)
                .addOnSuccessListener { result: PendingIntent ->
                    try {
                        phoneNumberHintIntentResultLauncher.launch(
                            IntentSenderRequest.Builder(result).build()
                        )
                    } catch (e: Exception) {
                        Log.e("Phone", "Launching the PendingIntent failed")
                    }
                }
                .addOnFailureListener {
                    Log.e("Phone", "Phone Number Hint failed")
                }
        } catch (e: Exception) {
            Log.e("Phone", "PhoneLoginScreen: Phone hint exception")
        }
    }


    val textValue = remember {
        mutableStateOf("")
    }

    val focusRequester = remember {
        FocusRequester()
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .focusRequester(focusRequester)
            .onFocusChanged {
                if (it.isFocused) {
                    getPhoneNumberHint()
                }
            },
        singleLine = true,
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        label = { Text(text = label,
            fontSize = 20.sp,
            ) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Secondary,
            focusedLabelColor = Accent,
            cursorColor = TextColor
        ),
        keyboardActions = KeyboardActions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        }
    )
}

@Composable
fun ClickableTextComponent(value: String) {

    val annotatedString =  buildAnnotatedString {
        withStyle(style = SpanStyle(color = Accent)) {
            pushStringAnnotation(tag = value, annotation = value)
            append(value)
        }
    }
    ClickableText(text = annotatedString, onClick = {
            offset -> annotatedString.getStringAnnotations(offset, offset)
        .firstOrNull()?.also {span ->
            Log.d("ClickAbleTextComponent", "{$span}")
            }
        }
    )
}