package hardcoder.dev.blocks.components.progressBar.internal

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
fun IconCircularProgressBar(
    modifier: Modifier = Modifier,
    percentage: Float,
    @DrawableRes iconResId: Int,
    radius: Dp = 50.dp,
    isEnabledShadowColor: Boolean = true,
    strokeWidth: Dp = 8.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
) {
    val color = MaterialTheme.colorScheme.primary
    val shadowColor = if (isEnabledShadowColor) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        null
    }

    var animationPlayed by remember {
        mutableStateOf(false)
    }

    val currentPercentage by animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        label = "currentPercentageOfCircularProgressBar",
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay,
        ),
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(radius.times(2)),
    ) {
        Canvas(modifier = Modifier.size(radius.times(2))) {
            shadowColor?.let {
                drawArc(
                    color = it,
                    startAngle = -90f,
                    sweepAngle = 360f * 100,
                    useCenter = false,
                    style = Stroke(
                        width = strokeWidth.toPx(),
                        cap = StrokeCap.Round,
                    ),
                )
            }
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360f * currentPercentage,
                useCenter = false,
                style = Stroke(
                    width = strokeWidth.toPx(),
                    cap = StrokeCap.Round,
                ),
            )
        }

        Icon(
            painter = painterResource(iconResId),
            contentDescription = "",
            modifier = Modifier.size(radius.times(1f)),
        )
    }
}

@ElementPreview
@Composable
internal fun IconCircularProgressBarPreview() {
    BlocksThemePreview {
        Box(modifier = Modifier.padding(32.dp)) {
            IconCircularProgressBar(
                iconResId = R.drawable.ic_create,
                percentage = 0.8f
            )
        }
    }
}