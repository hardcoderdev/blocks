package hardcoder.dev.blocks.components.tooltip

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

sealed class TooltipConfig {
    data class Plain(
        val modifier: Modifier = Modifier,
        @StringRes val tooltipResId: Int,
        val content: @Composable () -> Unit,
    ) : TooltipConfig()
}