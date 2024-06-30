package hardcoder.dev.blocks.components.text.input

import androidx.annotation.StringRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation

sealed class InputTextConfig {
    data class Filled(
        val text: String,
        val onTextChanged: (String) -> Unit,
        val modifier: Modifier = Modifier,
        val onFocusChanged: (FocusState) -> Unit = {},
        val isEnabled: Boolean = true,
        val isReadOnly: Boolean = false,
        val label: (@Composable () -> Unit)? = null,
        val placeholder: (@Composable () -> Unit)? = null,
        val supportingText: (@Composable () -> Unit)? = null,
        val leadingIcon: (@Composable () -> Unit)? = null,
        val trailingIcon: (@Composable () -> Unit)? = null,
        val prefix: (@Composable () -> Unit)? = null,
        val suffix: (@Composable () -> Unit)? = null,
        val visualTransformation: VisualTransformation = VisualTransformation.None,
        val keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        val keyboardActions: KeyboardActions = KeyboardActions.Default,
        val isMultiLine: Boolean = false,
        val minLines: Int = 1,
        @StringRes val errorTextResId: Int? = null,
        val interactionSource: MutableInteractionSource? = null,
        val textStyle: TextStyle? = null,
        val shape: Shape? = null,
        val colors: TextFieldColors? = null,
    ) : InputTextConfig()

    data class Outlined(
        val text: String,
        val onTextChanged: (String) -> Unit,
        val modifier: Modifier = Modifier,
        val onFocusChanged: (FocusState) -> Unit = {},
        val isEnabled: Boolean = true,
        val isReadOnly: Boolean = false,
        val label: (@Composable () -> Unit)? = null,
        val placeholder: (@Composable () -> Unit)? = null,
        val supportingText: (@Composable () -> Unit)? = null,
        val leadingIcon: (@Composable () -> Unit)? = null,
        val trailingIcon: (@Composable () -> Unit)? = null,
        val prefix: (@Composable () -> Unit)? = null,
        val suffix: (@Composable () -> Unit)? = null,
        val visualTransformation: VisualTransformation = VisualTransformation.None,
        val keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        val keyboardActions: KeyboardActions = KeyboardActions.Default,
        val isMultiLine: Boolean = false,
        val minLines: Int = 1,
        @StringRes val errorTextResId: Int? = null,
        val interactionSource: MutableInteractionSource? = null,
        val textStyle: TextStyle? = null,
        val shape: Shape? = null,
        val colors: TextFieldColors? = null,
    ) : InputTextConfig()
}