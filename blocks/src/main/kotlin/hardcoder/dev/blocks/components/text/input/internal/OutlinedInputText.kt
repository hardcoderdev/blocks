package hardcoder.dev.blocks.components.text.input.internal

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.icon.Icon
import hardcoder.dev.blocks.components.text.ErrorText
import hardcoder.dev.blocks.components.text.Label
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
internal fun OutlinedInputText(
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    onFocusChanged: (FocusState) -> Unit = {},
    isEnabled: Boolean = true,
    isReadOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: String? = null,
    placeholder: (@Composable () -> Unit)? = null,
    supportingText: (@Composable () -> Unit)? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    prefix: (@Composable () -> Unit)? = null,
    suffix: (@Composable () -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    isMultiLine: Boolean = false,
    minLines: Int = 1,
    errorText: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = TextFieldDefaults.shape,
    colors: TextFieldColors = TextFieldDefaults.colors(),
) {
    var focusState: FocusState? by remember { mutableStateOf(null) }
    val focusRequester = remember { FocusRequester() }

    OutlinedTextField(
        value = text,
        onValueChange = onTextChanged,
        modifier = modifier
            .focusRequester(focusRequester)
            .onFocusChanged {
                focusState = it
                onFocusChanged(it)
            },
        enabled = isEnabled,
        readOnly = isReadOnly,
        textStyle = textStyle,
        label = { Label(text = label ?: "") },
        placeholder = placeholder,
        supportingText = supportingText,
        leadingIcon = leadingIcon,
        trailingIcon = if (focusState?.hasFocus == true) trailingIcon else null,
        prefix = prefix,
        suffix = suffix,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = !isMultiLine,
        maxLines = if (isMultiLine) Int.MAX_VALUE else 1,
        minLines = minLines,
        isError = errorText != null,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors
    )

    AnimatedVisibility(
        visible = errorText != null,
        enter = fadeIn() + expandVertically(),
        exit = fadeOut() + shrinkVertically(),
    ) {
        ErrorText(
            modifier = Modifier.padding(top = 8.dp),
            text = errorText ?: ""
        )
    }
}

@ElementPreview
@Composable
internal fun OutlinedInputTextPreview() {
    BlocksThemePreview {
        OutlinedInputText(
            label = "Enter your name here...",
            text = "Gustav",
            onTextChanged = {},
            leadingIcon = { Icon(iconResId = R.drawable.ic_create) },
            errorText = stringResource(id = R.string.default_nowEmpty_text),
        )
    }
}