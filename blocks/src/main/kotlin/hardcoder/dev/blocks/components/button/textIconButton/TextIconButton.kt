package hardcoder.dev.blocks.components.button.textIconButton

import androidx.compose.runtime.Composable
import hardcoder.dev.blocks.components.button.internal.textIconButton.FilledTextIconButton
import hardcoder.dev.blocks.components.button.internal.textIconButton.FilledTextIconButtonPreview
import hardcoder.dev.blocks.components.button.internal.textIconButton.OutlinedTextIconButton
import hardcoder.dev.blocks.components.button.internal.textIconButton.OutlinedTextIconButtonPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

@Composable
fun TextIconButton(textIconButtonConfig: TextIconButtonConfig) {
    when (textIconButtonConfig) {
        is TextIconButtonConfig.Filled -> {
            FilledTextIconButton(
                modifier = textIconButtonConfig.modifier,
                onClick = textIconButtonConfig.onClick,
                isEnabled = textIconButtonConfig.isEnabled,
                labelResId = textIconButtonConfig.labelResId,
                iconResId = textIconButtonConfig.iconResId,
                formatArgs = textIconButtonConfig.formatArgs,
                contentDescription = textIconButtonConfig.contentDescription,
            )
        }

        is TextIconButtonConfig.Outlined -> {
            OutlinedTextIconButton(
                modifier = textIconButtonConfig.modifier,
                onClick = textIconButtonConfig.onClick,
                isEnabled = textIconButtonConfig.isEnabled,
                labelResId = textIconButtonConfig.labelResId,
                iconResId = textIconButtonConfig.iconResId,
                formatArgs = textIconButtonConfig.formatArgs,
                contentDescription = textIconButtonConfig.contentDescription,
            )
        }
    }
}

@ElementPreview
@Composable
private fun FilledTextIconButtonPreview() {
    FilledTextIconButtonPreview()
}

@ElementPreview
@Composable
private fun OutlinedTextIconButtonPreview() {
    OutlinedTextIconButtonPreview()
}