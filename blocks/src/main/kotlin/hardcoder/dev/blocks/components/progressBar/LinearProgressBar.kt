package hardcoder.dev.blocks.components.progressBar

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
fun LinearProgressBar(
    modifier: Modifier = Modifier,
    indicatorColor: Color = MaterialTheme.colorScheme.primary,
    isAnimated: Boolean = true,
    indicatorProgress: Float,
) {
    var progress by remember { mutableFloatStateOf(0f) }
    val progressAnimDuration = 1500
    val progressAnimation by animateFloatAsState(
        targetValue = progress,
        label = "Linear progress bar animation FastOutSlowInEasing",
        animationSpec = tween(
            durationMillis = progressAnimDuration,
            easing = FastOutSlowInEasing,
        )
    )
    LinearProgressIndicator(
        progress = { if (isAnimated) progressAnimation else progress },
        color = indicatorColor,
        modifier = modifier.fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .height(16.dp),
    )
    LaunchedEffect(indicatorProgress) {
        progress = indicatorProgress
    }
}

@ElementPreview
@Composable
private fun LinearProgressBarPreview() {
    BlocksThemePreview {
        LinearProgressBar(
            indicatorProgress = 0.7f,
            modifier = Modifier,
        )
    }
}