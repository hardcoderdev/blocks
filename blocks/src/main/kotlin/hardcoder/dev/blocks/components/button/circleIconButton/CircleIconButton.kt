package hardcoder.dev.blocks.components.button.circleIconButton

import androidx.compose.runtime.Composable
import hardcoder.dev.blocks.components.button.internal.circleIconButton.FilledCircleIconButton
import hardcoder.dev.blocks.components.button.internal.circleIconButton.FilledCircleIconButtonPreview
import hardcoder.dev.blocks.components.button.internal.circleIconButton.OutlinedCircleIconButton
import hardcoder.dev.blocks.components.button.internal.circleIconButton.OutlinedCircleIconButtonPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

@Composable
fun CircleIconButton(circleIconButtonConfig: CircleIconButtonConfig) {
    when (circleIconButtonConfig) {
        is CircleIconButtonConfig.Filled -> {
            FilledCircleIconButton(
                modifier = circleIconButtonConfig.modifier,
                onClick = circleIconButtonConfig.onClick,
                iconResId = circleIconButtonConfig.iconResId,
                contentDescription = circleIconButtonConfig.contentDescription,
            )
        }

        is CircleIconButtonConfig.Outlined -> {
            OutlinedCircleIconButton(
                modifier = circleIconButtonConfig.modifier,
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