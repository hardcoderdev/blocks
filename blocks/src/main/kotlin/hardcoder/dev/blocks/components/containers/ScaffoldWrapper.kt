package hardcoder.dev.blocks.components.containers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.button.fabButton.FabButton
import hardcoder.dev.blocks.components.button.fabButton.FabConfig
import hardcoder.dev.blocks.components.topBar.Action
import hardcoder.dev.blocks.components.topBar.ActionConfig
import hardcoder.dev.blocks.components.topBar.DropdownConfig
import hardcoder.dev.blocks.components.topBar.DropdownItem
import hardcoder.dev.blocks.components.topBar.TopBar
import hardcoder.dev.blocks.components.topBar.TopBarConfig
import hardcoder.dev.blocks.components.topBar.TopBarType
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
fun ScaffoldWrapper(
    content: @Composable () -> Unit,
    topBarConfig: TopBarConfig,
    fabConfig: FabConfig? = null,
    dropdownConfig: DropdownConfig? = null,
    actionConfig: ActionConfig? = null,
) {
    Scaffold(
        contentWindowInsets = WindowInsets.systemBars,
        topBar = {
            TopBar(
                topBarConfig = topBarConfig,
                actionConfig = actionConfig,
                dropdownConfig = dropdownConfig,
            )
        },
        floatingActionButton = {
            fabConfig?.let { FabButton(fabConfig = fabConfig) }
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            content = { content() }
        )
    }
}

@ElementPreview
@Composable
private fun ScaffoldWrapperPreview() {
    BlocksThemePreview {
        ScaffoldWrapper(
            content = { },
            topBarConfig = TopBarConfig(
                type = TopBarType.TopBarWithNavigationBack(
                    titleResId = R.string.placeholder_one_line_label,
                    onGoBack = {},
                ),
            ),
            actionConfig = ActionConfig(
                actions = listOf(
                    Action(
                        iconResId = R.drawable.ic_add,
                        onActionClick = {},
                    ),
                ),
            ),
            dropdownConfig = DropdownConfig(
                actionToggle = Action(
                    iconResId = R.drawable.ic_drop_down,
                    onActionClick = {},
                ),
                dropdownItems = listOf(
                    DropdownItem(
                        name = "Add",
                        onDropdownItemClick = {},
                    ),
                    DropdownItem(
                        name = "Remove",
                        onDropdownItemClick = {},
                    ),
                    DropdownItem(
                        name = "Clear",
                        onDropdownItemClick = {},
                    ),
                ),
            ),
            fabConfig = FabConfig.LargeFab(
                iconResId = R.drawable.ic_add,
                onFabClick = {},
            ),
        )
    }
}