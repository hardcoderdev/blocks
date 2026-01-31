package hardcoder.dev.blocks.components.button.internal.circleIconButton

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview
import androidx.compose.material3.Icon as MaterialIcon

@Composable
internal fun OutlinedCircleIconButton(
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
        color = Color.Transparent,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
        onClick = onClick,
    ) {
        Box(contentAlignment = Alignment.Center) {
            MaterialIcon(
                painter = painterResource(iconResId),
                contentDescription = contentDescription?.let { stringResource(it) },
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(buttonSize * 0.10f)
            )
        }
    }
}

@ElementPreview
@Composable
internal fun OutlinedCircleIconButtonPreview() {
    BlocksThemePreview {
        OutlinedCircleIconButton(
            onClick = { /* no-op */ },
            iconResId = R.drawable.ic_clear,
            contentDescription = null,
            buttonSize = CircleIconButtonDefaults.Large,
        )
    }
}