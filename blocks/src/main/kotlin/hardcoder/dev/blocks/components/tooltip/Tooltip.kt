package hardcoder.dev.blocks.components.tooltip

import androidx.compose.runtime.Composable
import hardcoder.dev.blocks.components.tooltip.internal.PlainTooltip
import hardcoder.dev.blocks.components.tooltip.internal.PlainTooltipPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

@Composable
fun Tooltip(tooltipConfig: TooltipConfig) {
    when (tooltipConfig) {
        is TooltipConfig.Plain -> {
            PlainTooltip(
                modifier = tooltipConfig.modifier,
                tooltipResId = tooltipConfig.tooltipResId,
                content = tooltipConfig.content,
            )
        }
    }
}

@ElementPreview
@Composable
private fun PlainTooltipPreview() {
    PlainTooltipPreview()
}
