package hardcoder.dev.blocks.components.button.simpleButton

import androidx.compose.runtime.Composable
import hardcoder.dev.blocks.components.button.internal.simpleButton.FilledSimpleButton
import hardcoder.dev.blocks.components.button.internal.simpleButton.FilledSimpleButtonPreview
import hardcoder.dev.blocks.components.button.internal.simpleButton.OutlinedSimpleButton
import hardcoder.dev.blocks.components.button.internal.simpleButton.OutlinedSimpleButtonPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

@Composable
fun SimpleButton(simpleButtonConfig: SimpleButtonConfig) {
    when (simpleButtonConfig) {
        is SimpleButtonConfig.Filled -> {
            FilledSimpleButton(
                onClick = simpleButtonConfig.onClick,
                modifier = simpleButtonConfig.modifier,
                labelResId = simpleButtonConfig.labelResId,
                isEnabled = simpleButtonConfig.isEnabled,
            )
        }

        is SimpleButtonConfig.Outlined -> {
            OutlinedSimpleButton(
                onClick = simpleButtonConfig.onClick,
                modifier = simpleButtonConfig.modifier,
                labelResId = simpleButtonConfig.labelResId,
                isEnabled = simpleButtonConfig.isEnabled,
            )
        }
    }
}

@ElementPreview
@Composable
private fun FilledSimpleButtonPreview() {
    FilledSimpleButtonPreview()
}

@ElementPreview
@Composable
private fun OutlinedSimpleButtonPreview() {
    OutlinedSimpleButtonPreview()
}