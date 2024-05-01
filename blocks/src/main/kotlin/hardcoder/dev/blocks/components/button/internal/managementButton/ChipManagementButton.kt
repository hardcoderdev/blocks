package hardcoder.dev.blocks.components.button.internal.managementButton

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.chip.Chip
import hardcoder.dev.blocks.components.chip.ChipConfig
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
internal fun ChipManagementButton(
    modifier: Modifier = Modifier,
    @StringRes titleResId: Int,
    @DrawableRes iconResId: Int = R.drawable.ic_create,
    onManage: () -> Unit,
) {
    Chip(
        chipConfig = ChipConfig.Action(
            modifier = modifier.padding(4.dp),
            onClick = onManage,
            text = stringResource(id = titleResId),
            iconResId = iconResId,
            shape = RoundedCornerShape(32.dp),
        ),
    )
}

@ElementPreview
@Composable
internal fun ChipManagementButtonPreview() {
    BlocksThemePreview {
        ChipManagementButton(
            onManage = {},
            titleResId = R.string.placeholder_one_line_label,
        )
    }
}