package ana.lemma.components

import ana.lemma.ui.theme.Accent
import ana.lemma.ui.theme.Secondary
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonComponent(value: String, onButtonClick: () -> Unit) {
    Button(onClick = { onButtonClick.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RectangleShape
    ) {

        Box(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .heightIn()
            .background(
                brush = Brush.horizontalGradient(listOf(Accent, Secondary, Accent)),
            ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = value,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}