package hardcoder.dev.blocks.components.button.internal.fabButton

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.icon.Icon
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
internal fun LargeFabButton(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    @DrawableRes iconResId: Int = R.drawable.ic_add,
    @StringRes contentDescriptionResId: Int? = null,
    onFabClick: () -> Unit,
    elevation: FloatingActionButtonElevation,
) {
    LargeFloatingActionButton(
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
internal fun LargeFabButtonPreview() {
    BlocksThemePreview {
        LargeFabButton(
            onFabClick = { /* no-op */ },
            iconResId = R.drawable.ic_clear,
            iconModifier = Modifier.size(36.dp),
            elevation = FloatingActionButtonDefaults.elevation(),
        )
    }
}