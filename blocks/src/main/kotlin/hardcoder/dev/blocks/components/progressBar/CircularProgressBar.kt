package hardcoder.dev.blocks.components.progressBar

import androidx.compose.runtime.Composable
import hardcoder.dev.blocks.components.progressBar.internal.IconCircularProgressBar
import hardcoder.dev.blocks.components.progressBar.internal.IconCircularProgressBarPreview
import hardcoder.dev.blocks.components.progressBar.internal.TextCircularProgressBar
import hardcoder.dev.blocks.components.progressBar.internal.TextCircularProgressBarPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

@Composable
fun CircularProgressBar(circularProgressBarConfig: CircularProgressBarConfig) {
    when (circularProgressBarConfig) {
        is CircularProgressBarConfig.Icon -> {
            IconCircularProgressBar(
                modifier = circularProgressBarConfig.modifier,
                iconResId = circularProgressBarConfig.iconResId,
                isEnabledShadowColor = circularProgressBarConfig.isEnabledShadowColor,
                percentage = circularProgressBarConfig.percentage,
                strokeWidth = circularProgressBarConfig.strokeWidth,
                radius = circularProgressBarConfig.radius,
                animationDelay = circularProgressBarConfig.animationDelay,
                animationDuration = circularProgressBarConfig.animationDuration,
            )
        }
        is CircularProgressBarConfig.Text -> {
            TextCircularProgressBar(
                modifier = circularProgressBarConfig.modifier,
                textResId = circularProgressBarConfig.textResId,
                isEnabledShadowColor = circularProgressBarConfig.isEnabledShadowColor,
                percentage = circularProgressBarConfig.percentage,
                strokeWidth = circularProgressBarConfig.strokeWidth,
                radius = circularProgressBarConfig.radius,
                animationDelay = circularProgressBarConfig.animationDelay,
                animationDuration = circularProgressBarConfig.animationDuration,
            )
        }
    }
}

@ElementPreview
@Composable
private fun TextCircularProgressBarPreview() {
    TextCircularProgressBarPreview()
}

@ElementPreview
@Composable
private fun IconCircularProgressBarPreview() {
    IconCircularProgressBarPreview()
}