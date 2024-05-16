package hardcoder.dev.blocks.components.button.internal.fabButton

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.icon.Icon
import hardcoder.dev.blocks.components.text.Title
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

enum class IconGravity {
    START,
    END
}

@Composable
internal fun ExtendedFabButton(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    @DrawableRes iconResId: Int? = null,
    @StringRes labelResId: Int,
    @StringRes contentDescriptionResId: Int? = null,
    iconGravity: IconGravity = IconGravity.START,
    onFabClick: () -> Unit,
    elevation: FloatingActionButtonElevation,
) {
    ExtendedFloatingActionButton(
        elevation = elevation,
        modifier = modifier,
        onClick = onFabClick
    ) {
        if (iconResId != null) {
            when (iconGravity) {
                IconGravity.START -> {
                    Icon(
                        modifier = iconModifier,
                        iconResId = iconResId,
                        contentDescription = contentDescriptionResId?.let { stringResource(id = it) }
                            ?: "",
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Title(text = stringResource(id = labelResId))
                }

                IconGravity.END -> {
                    Title(text = stringResource(id = labelResId))
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        modifier = iconModifier,
                        iconResId = iconResId,
                        contentDescription = contentDescriptionResId?.let { stringResource(id = it) }
                            ?: "",
                    )
                }
            }
        } else {
            Title(text = stringResource(id = labelResId))
        }
    }
}

@ElementPreview
@Composable
internal fun ExtendedFabButtonPreview() {
    BlocksThemePreview {
        ExtendedFabButton(
            onFabClick = { /* no-op */ },
            iconResId = R.drawable.ic_clear,
            iconModifier = Modifier.size(36.dp),
            labelResId = R.string.placeholder_one_line_label,
            elevation = FloatingActionButtonDefaults.elevation(),
        )
    }
}