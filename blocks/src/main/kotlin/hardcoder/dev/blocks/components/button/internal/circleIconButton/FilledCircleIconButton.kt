package hardcoder.dev.blocks.components.button.internal.circleIconButton

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview
import androidx.compose.material3.Icon as MaterialIcon
import androidx.compose.material3.IconButton as MaterialIconButton

@Composable
internal fun FilledCircleIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @DrawableRes iconResId: Int,
    @StringRes contentDescription: Int?,
) {
    MaterialIconButton(
        modifier = modifier.background(
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(16.dp),
        ),
        onClick = onClick,
    ) {
        MaterialIcon(
            modifier = Modifier
                .padding(8.dp),
            painter = painterResource(id = iconResId),
            contentDescription = contentDescription?.let { stringResource(id = it) },
            tint = MaterialTheme.colorScheme.onPrimary,
        )
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
        )
    }
}