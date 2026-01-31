package hardcoder.dev.blocks.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
fun Title(
    modifier: Modifier = Modifier,
    textDecoration: TextDecoration? = null,
    text: String,
) {
    Text(
        text = text,
        modifier = modifier,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.titleLarge.copy(
            textDecoration = textDecoration
        ),
    )
}

@ElementPreview
@Composable
private fun TitlePreview() {
    BlocksThemePreview {
        Title(text = stringResource(id = R.string.placeholder_one_line_label))
    }
}