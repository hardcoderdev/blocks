package hardcoder.dev.blocks.components.text.input

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import hardcoder.dev.blocks.components.text.input.internal.FilledInputText
import hardcoder.dev.blocks.components.text.input.internal.FilledInputTextPreview
import hardcoder.dev.blocks.components.text.input.internal.OutlinedInputText
import hardcoder.dev.blocks.components.text.input.internal.OutlinedInputTextPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

@Composable
fun InputText(inputTextConfig: InputTextConfig) {
    when (inputTextConfig) {
        is InputTextConfig.Filled -> FilledInputText(
            text = inputTextConfig.text,
            onTextChanged = inputTextConfig.onTextChanged,
            modifier = inputTextConfig.modifier,
            onFocusChanged = inputTextConfig.onFocusChanged,
            isEnabled = inputTextConfig.isEnabled,
            isReadOnly = inputTextConfig.isReadOnly,
            textStyle = inputTextConfig.textStyle ?: LocalTextStyle.current,
            label = inputTextConfig.label,
            placeholder = inputTextConfig.placeholder,
            supportingText = inputTextConfig.supportingText,
            leadingIcon = inputTextConfig.leadingIcon,
            trailingIcon = inputTextConfig.trailingIcon,
            prefix = inputTextConfig.prefix,
            suffix = inputTextConfig.suffix,
            visualTransformation = inputTextConfig.visualTransformation,
            keyboardActions = inputTextConfig.keyboardActions,
            keyboardOptions = inputTextConfig.keyboardOptions,
            isMultiLine = inputTextConfig.isMultiLine,
            errorTextResId = inputTextConfig.errorTextResId,
            shape = inputTextConfig.shape ?: TextFieldDefaults.shape,
            colors = inputTextConfig.colors ?: TextFieldDefaults.colors(),
            interactionSource = inputTextConfig.interactionSource ?: remember {
                MutableInteractionSource()
            },
        )

        is InputTextConfig.Outlined -> OutlinedInputText(
            text = inputTextConfig.text,
            onTextChanged = inputTextConfig.onTextChanged,
            modifier = inputTextConfig.modifier,
            onFocusChanged = inputTextConfig.onFocusChanged,
            isEnabled = inputTextConfig.isEnabled,
            isReadOnly = inputTextConfig.isReadOnly,
            textStyle = inputTextConfig.textStyle ?: LocalTextStyle.current,
            label = inputTextConfig.label,
            placeholder = inputTextConfig.placeholder,
            supportingText = inputTextConfig.supportingText,
            leadingIcon = inputTextConfig.leadingIcon,
            trailingIcon = inputTextConfig.trailingIcon,
            prefix = inputTextConfig.prefix,
            suffix = inputTextConfig.suffix,
            visualTransformation = inputTextConfig.visualTransformation,
            keyboardActions = inputTextConfig.keyboardActions,
            keyboardOptions = inputTextConfig.keyboardOptions,
            isMultiLine = inputTextConfig.isMultiLine,
            errorTextResId = inputTextConfig.errorTextResId,
            shape = inputTextConfig.shape ?: TextFieldDefaults.shape,
            colors = inputTextConfig.colors ?: TextFieldDefaults.colors(),
            interactionSource = inputTextConfig.interactionSource ?: remember {
                MutableInteractionSource()
            },
        )
    }
}

@ElementPreview
@Composable
private fun FilledInputTextPreview() {
    FilledInputTextPreview()
}

@ElementPreview
@Composable
private fun OutlinedInputTextPreview() {
    OutlinedInputTextPreview()
}