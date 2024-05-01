package hardcoder.dev.blocks.components.topBar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import hardcoder.dev.blocks.components.topBar.internal.GoBackTopBar
import hardcoder.dev.blocks.components.topBar.internal.GoBackTopBarPreview
import hardcoder.dev.blocks.components.topBar.internal.SearchTopBar
import hardcoder.dev.blocks.components.topBar.internal.SearchTopBarPreview
import hardcoder.dev.blocks.components.topBar.internal.SimpleTopBar
import hardcoder.dev.blocks.components.topBar.internal.SimpleTopBarPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

sealed class TopBarType {
    data object WithoutTopBar : TopBarType()
    data class TitleTopBar(@StringRes val titleResId: Int) : TopBarType()
    data class TopBarWithNavigationBack(
        @StringRes val titleResId: Int,
        val onGoBack: () -> Unit,
    ) : TopBarType()

    data class SearchTopBar(
        @StringRes val titleResId: Int,
        val searchText: String,
        @StringRes val placeholderText: Int,
        val onGoBack: () -> Unit,
        val onSearchTextChanged: (String) -> Unit,
        val onClearClick: () -> Unit,
    ) : TopBarType()
}

data class DropdownItem(
    val name: String,
    val onDropdownItemClick: () -> Unit,
)

data class DropdownConfig(
    val actionToggle: Action,
    val dropdownItems: List<DropdownItem>,
)

data class Action(
    @DrawableRes val iconResId: Int,
    val onActionClick: () -> Unit,
)

data class ActionConfig(val actions: List<Action>)

data class TopBarConfig(val type: TopBarType)

@Composable
fun TopBar(
    topBarConfig: TopBarConfig,
    actionConfig: ActionConfig?,
    dropdownConfig: DropdownConfig?,
) {
    when (topBarConfig.type) {
        is TopBarType.TitleTopBar -> SimpleTopBar(
            titleResId = topBarConfig.type.titleResId,
            actionConfig = actionConfig,
        )

        is TopBarType.TopBarWithNavigationBack -> GoBackTopBar(
            titleResId = topBarConfig.type.titleResId,
            onGoBack = topBarConfig.type.onGoBack,
            dropdownConfig = dropdownConfig,
            actionConfig = actionConfig,
        )

        is TopBarType.SearchTopBar -> SearchTopBar(
            titleResId = topBarConfig.type.titleResId,
            searchText = topBarConfig.type.searchText,
            placeholderText = topBarConfig.type.placeholderText,
            actionConfig = actionConfig,
            onGoBack = topBarConfig.type.onGoBack,
            onSearchTextChanged = topBarConfig.type.onSearchTextChanged,
            onClearClick = topBarConfig.type.onClearClick,
        )

        is TopBarType.WithoutTopBar -> {}
    }
}

@ElementPreview
@Composable
private fun GoBackTopBarPreview() {
    GoBackTopBarPreview()
}

@ElementPreview
@Composable
private fun SearchTopBarPreview() {
    SearchTopBarPreview()
}

@ElementPreview
@Composable
private fun SimpleTopBarPreview() {
    SimpleTopBarPreview()
}