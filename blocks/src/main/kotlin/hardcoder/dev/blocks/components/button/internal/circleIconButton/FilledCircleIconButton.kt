package hardcoder.dev.blocks.components.button.internal.circleIconButton

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview
import androidx.compose.material3.Icon as MaterialIcon

/**
 * @param [modifier] optional modifier for button
 * @param [shapeSize] rounded corner shape size in dp for button
 * @param [buttonSize] size in dp of button
 * @param [onClick] callback that is called when the button is clicked
 * @param [iconResId] icon drawable resource identifier for button
 * @param [contentDescription] optional content description for button. By default is null (empty string in the end)
 */

@Composable
internal fun FilledCircleIconButton(
    modifier: Modifier = Modifier,
    shapeSize: Dp = 16.dp,
    buttonSize: Dp = CircleIconButtonDefaults.Big,
    onClick: () -> Unit,
    @DrawableRes iconResId: Int,
    @StringRes contentDescription: Int?,
) {
    Surface(
        modifier = modifier.size(buttonSize),
        shape = RoundedCornerShape(shapeSize),
        color = MaterialTheme.colorScheme.primary,
        onClick = onClick,
    ) {
        Box(contentAlignment = Alignment.Center) {
            MaterialIcon(
                painter = painterResource(iconResId),
                contentDescription = contentDescription?.let { stringResource(it) },
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(buttonSize * 0.10f)
            )
        }
    }
}

@ElementPreview
@Composable
internal fun FilledCircleIconButtonPreview() {
    BlocksThemePreview {
        FilledCircleIconButton(
            onClick = { /* no-op */ },
            iconResId = R.drawable.ic_clear,
            contentDescription = null,
            buttonSize = CircleIconButtonDefaults.Large,
        )
    }
}