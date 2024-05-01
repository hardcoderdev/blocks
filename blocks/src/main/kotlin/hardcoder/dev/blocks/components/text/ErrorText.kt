package hardcoder.dev.blocks.components.text

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
fun ErrorText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        color = MaterialTheme.colorScheme.error,
        text = text,
        imageVector = Icons.Default.Error,
        iconTint = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.titleSmall,
    )
}

@ElementPreview
@Composable
private fun ErrorTextPreview() {
    BlocksThemePreview {
        ErrorText(text = stringResource(id = R.string.placeholder_one_line_label))
    }
}