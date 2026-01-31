package hardcoder.dev.blocks.components.button.circleIconButton

import androidx.compose.runtime.Composable
import hardcoder.dev.blocks.components.button.internal.circleIconButton.FilledCircleIconButton
import hardcoder.dev.blocks.components.button.internal.circleIconButton.FilledCircleIconButtonPreview
import hardcoder.dev.blocks.components.button.internal.circleIconButton.OutlinedCircleIconButton
import hardcoder.dev.blocks.components.button.internal.circleIconButton.OutlinedCircleIconButtonPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

/**
 * Circle button with icon.
 *
 * Has 2 variants:
 *
 * 1) Filled - @see [FilledCircleIconButton]
 * 1) Outlined - @see [OutlinedCircleIconButton]
 *
 * All variants take as a @param [circleIconButtonConfig] - config for button configuration
 */

@Composable
fun CircleIconButton(circleIconButtonConfig: CircleIconButtonConfig) {
    when (circleIconButtonConfig) {
        is CircleIconButtonConfig.Filled -> {
            FilledCircleIconButton(
                modifier = circleIconButtonConfig.modifier,
                shapeSize = circleIconButtonConfig.shapeSize,
                buttonSize = circleIconButtonConfig.buttonSize,
                onClick = circleIconButtonConfig.onClick,
                iconResId = circleIconButtonConfig.iconResId,
                contentDescription = circleIconButtonConfig.contentDescription,
            )
        }

        is CircleIconButtonConfig.Outlined -> {
            OutlinedCircleIconButton(
                modifier = circleIconButtonConfig.modifier,
                shapeSize = circleIconButtonConfig.shapeSize,
                buttonSize = circleIconButtonConfig.buttonSize,
                onClick = circleIconButtonConfig.onClick,
                iconResId = circleIconButtonConfig.iconResId,
                contentDescription = circleIconButtonConfig.contentDescription,
            )
        }
    }
}

@ElementPreview
@Composable
private fun FilledCircleIconButtonPreview() {
    FilledCircleIconButtonPreview()
}

@ElementPreview
@Composable
private fun OutlinedCircleIconButtonPreview() {
    OutlinedCircleIconButtonPreview()
}