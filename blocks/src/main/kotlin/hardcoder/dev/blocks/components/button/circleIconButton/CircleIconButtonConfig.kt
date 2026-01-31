package hardcoder.dev.blocks.components.button.circleIconButton

import androidx.annotation.StringRes
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.components.button.internal.circleIconButton.CircleIconButtonDefaults

/**
 * Config for [CircleIconButton].
 *
 * Can only be one of 2 options:
 * 1) [CircleIconButtonConfig.Filled]
 * 1) [CircleIconButtonConfig.Outlined]
 *
 * */

sealed class CircleIconButtonConfig {

    /**
     * @param [modifier] optional modifier for button
     * @param [shapeSize] rounded corner shape size in dp for button
     * @param [buttonSize] size in dp of button
     * @param [onClick] callback that is called when the button is clicked
     * @param [iconResId] icon drawable resource identifier for button
     * @param [contentDescription] optional content description for button. By default is null (empty string in the end)
     */
    data class Filled(
        val modifier: Modifier = Modifier,
        val shapeSize: Dp = 16.dp,
        val buttonSize: Dp = CircleIconButtonDefaults.Big,
        val onClick: () -> Unit,
        val iconResId: Int,
        @StringRes val contentDescription: Int? = null,
    ) : CircleIconButtonConfig()

    /**
     * @param [modifier] optional modifier for button
     * @param [shapeSize] rounded corner shape size in dp for button
     * @param [buttonSize] size in dp of button
     * @param [onClick] callback that is called when the button is clicked
     * @param [iconResId] icon drawable resource identifier for button
     * @param [contentDescription] optional content description for button. By default is null (empty string in the end)
     */
    data class Outlined(
        val modifier: Modifier = Modifier,
        val shapeSize: Dp = 16.dp,
        val buttonSize: Dp = CircleIconButtonDefaults.Big,
        val onClick: () -> Unit,
        val iconResId: Int,
        @StringRes val contentDescription: Int? = null,
    ) : CircleIconButtonConfig()
}