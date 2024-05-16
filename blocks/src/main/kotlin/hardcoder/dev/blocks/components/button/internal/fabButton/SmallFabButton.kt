package hardcoder.dev.blocks.components.button.internal.fabButton

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.icon.Icon
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
internal fun SmallFabButton(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    @DrawableRes iconResId: Int,
    @StringRes contentDescriptionResId: Int? = null,
    onFabClick: () -> Unit,
    elevation: FloatingActionButtonElevation,
) {
    SmallFloatingActionButton(
        elevation = elevation,
        modifier = modifier,
        onClick = onFabClick
    ) {
        Icon(
            modifier = iconModifier,
            iconResId = iconResId,
            contentDescription = contentDescriptionResId?.let { stringResource(id = it) } ?: "",
        )
    }
}

@ElementPreview
@Composable
internal fun SmallFabButtonPreview() {
    BlocksThemePreview {
        SmallFabButton(
            onFabClick = { /* no-op */ },
            iconResId = R.drawable.ic_clear,
            elevation = FloatingActionButtonDefaults.elevation(),
        )
    }
}