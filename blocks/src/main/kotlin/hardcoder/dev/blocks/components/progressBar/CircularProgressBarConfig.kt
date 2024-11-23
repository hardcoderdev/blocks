package hardcoder.dev.blocks.components.progressBar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class CircularProgressBarConfig {
    data class Text(
        val modifier: Modifier = Modifier,
        @StringRes val textResId: Int,
        val percentage: Float,
        val isEnabledShadowColor: Boolean = true,
        val strokeWidth: Dp = 8.dp,
        val radius: Dp = 50.dp,
        val animationDuration: Int = 1000,
        val animationDelay: Int = 0,
    ) : CircularProgressBarConfig()

    data class Icon(
        val modifier: Modifier = Modifier,
        @DrawableRes val iconResId: Int,
        val percentage: Float,
        val isEnabledShadowColor: Boolean = true,
        val strokeWidth: Dp = 8.dp,
        val radius: Dp = 50.dp,
        val animationDuration: Int = 1000,
        val animationDelay: Int = 0,
    ) : CircularProgressBarConfig()
}