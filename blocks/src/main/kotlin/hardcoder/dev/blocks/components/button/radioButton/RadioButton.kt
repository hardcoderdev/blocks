package hardcoder.dev.blocks.components.button.radioButton

import androidx.compose.runtime.Composable
import hardcoder.dev.blocks.components.button.internal.radioButton.FilledRadioButton
import hardcoder.dev.blocks.components.button.internal.radioButton.FilledRadioButtonPreview
import hardcoder.dev.blocks.components.button.internal.radioButton.OutlinedRadioButton
import hardcoder.dev.blocks.components.button.internal.radioButton.OutlinedRadioButtonPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

@Composable
fun RadioButton(radioButtonConfig: RadioButtonConfig) {
    when (radioButtonConfig) {
        is RadioButtonConfig.Filled -> FilledRadioButton(
            labelResId = radioButtonConfig.labelResId,
            onClick = radioButtonConfig.onClick,
            isSelected = radioButtonConfig.isSelected,
            modifier = radioButtonConfig.modifier,
            isEnabled = radioButtonConfig.isEnabled,
        )
        is RadioButtonConfig.Outlined -> OutlinedRadioButton(
            labelResId = radioButtonConfig.labelResId,
            onClick = radioButtonConfig.onClick,
            isSelected = radioButtonConfig.isSelected,
            modifier = radioButtonConfig.modifier,
            isEnabled = radioButtonConfig.isEnabled,
        )
    }
}

@ElementPreview
@Composable
private fun FilledRadioButtonPreview() {
    FilledRadioButtonPreview()
}

@ElementPreview
@Composable
private fun OutlinedRadioButtonPreview() {
    OutlinedRadioButtonPreview()
}