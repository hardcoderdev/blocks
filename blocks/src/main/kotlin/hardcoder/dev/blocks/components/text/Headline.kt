package hardcoder.dev.blocks.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
fun Headline(
    modifier: Modifier = Modifier,
    textDecoration: TextDecoration? = null,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineMedium.copy(
            textDecoration = textDecoration,
        ),
    )
}

@ElementPreview
@Composable
private fun HeadlinePreview() {
    BlocksThemePreview {
        Headline(text = stringResource(id = R.string.placeholder_one_line_label))
    }
}