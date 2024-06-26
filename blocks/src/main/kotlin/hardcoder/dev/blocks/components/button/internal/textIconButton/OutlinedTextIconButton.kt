package hardcoder.dev.blocks.components.button.internal.textIconButton

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.text.Text
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview
import androidx.compose.material3.Icon as MaterialIcon

@Composable
internal fun OutlinedTextIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean,
    @StringRes labelResId: Int,
    formatArgs: List<Any> = emptyList(),
    @DrawableRes iconResId: Int,
    @StringRes contentDescription: Int?,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        enabled = isEnabled,
    ) {
        Text(
            text = stringResource(id = labelResId, formatArgs = formatArgs.toTypedArray()),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.W500,
            modifier = Modifier.weight(2f),
            color = MaterialTheme.colorScheme.onBackground,
        )
        MaterialIcon(
            painter = painterResource(id = iconResId),
            contentDescription = stringResource(id = contentDescription ?: labelResId),
            modifier = Modifier.weight(0.3f),
            tint = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@ElementPreview
@Composable
internal fun OutlinedTextIconButtonPreview() {
    BlocksThemePreview {
        OutlinedTextIconButton(
            onClick = { /* no-op */ },
            isEnabled = true,
            labelResId = R.string.placeholder_one_line_label,
            iconResId = R.drawable.ic_clear,
            contentDescription = null,
        )
    }
}