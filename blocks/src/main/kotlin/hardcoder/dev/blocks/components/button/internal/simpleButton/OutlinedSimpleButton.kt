package hardcoder.dev.blocks.components.button.internal.simpleButton

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview
import androidx.compose.material3.Text as MaterialText

@Composable
internal fun OutlinedSimpleButton(
    onClick: () -> Unit,
    isEnabled: Boolean,
    modifier: Modifier = Modifier,
    @StringRes labelResId: Int,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = isEnabled,
    ) {
        MaterialText(
            text = stringResource(id = labelResId),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@ElementPreview
@Composable
internal fun OutlinedSimpleButtonPreview() {
    BlocksThemePreview {
        OutlinedSimpleButton(
            onClick = { /* no-op */ },
            isEnabled = true,
            labelResId = R.string.placeholder_one_line_label,
        )
    }
}