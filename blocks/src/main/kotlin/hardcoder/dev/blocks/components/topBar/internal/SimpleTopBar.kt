package hardcoder.dev.blocks.components.topBar.internal

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.button.circleIconButton.CircleIconButton
import hardcoder.dev.blocks.components.button.circleIconButton.CircleIconButtonConfig
import hardcoder.dev.blocks.components.text.Text
import hardcoder.dev.blocks.components.topBar.Action
import hardcoder.dev.blocks.components.topBar.ActionConfig
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SimpleTopBar(
    @StringRes titleResId: Int,
    actionConfig: ActionConfig? = null,
) {
    TopAppBar(
        title = { Text(text = stringResource(id = titleResId)) },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        actions = {
            actionConfig?.let {
                it.actions.forEach { action ->
                    CircleIconButton(
                        circleIconButtonConfig = CircleIconButtonConfig.Filled(
                            onClick = action.onActionClick,
                            iconResId = action.iconResId,
                        ),
                    )
                }
            }
        },
    )
}

@ElementPreview
@Composable
internal fun SimpleTopBarPreview() {
    BlocksThemePreview {
        SimpleTopBar(
            titleResId = R.string.placeholder_one_line_label,
            actionConfig = ActionConfig(
                actions = listOf(
                    Action(
                        iconResId = R.drawable.ic_add,
                        onActionClick = {},
                    ),
                ),
            ),
        )
    }
}