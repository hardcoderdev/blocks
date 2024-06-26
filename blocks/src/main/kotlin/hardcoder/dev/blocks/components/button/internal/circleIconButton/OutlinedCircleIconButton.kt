package hardcoder.dev.blocks.components.button.internal.circleIconButton

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.border
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
internal fun OutlinedCircleIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @DrawableRes iconResId: Int,
    @StringRes contentDescription: Int?,
) {
    MaterialIconButton(
        modifier = modifier.border(
            width = 1.dp,
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.onBackground,
        ),
        onClick = onClick,
    ) {
        MaterialIcon(
            modifier = Modifier
                .padding(8.dp),
            painter = painterResource(id = iconResId),
            contentDescription = contentDescription?.let { stringResource(id = it) },
            tint = MaterialTheme.colorScheme.onBackground,
        )
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
        )
    }
}