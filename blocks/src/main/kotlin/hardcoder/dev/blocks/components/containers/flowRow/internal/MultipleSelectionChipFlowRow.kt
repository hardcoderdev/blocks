package hardcoder.dev.blocks.components.containers.flowRow.internal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.components.chip.content.SelectionContentChip
import hardcoder.dev.blocks.components.text.Label
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun <T> MultipleSelectionChipFlowRow(
    modifier: Modifier = Modifier,
    items: List<T>,
    selectedItems: List<T>,
    onSelectedItemChanged: (T) -> Unit,
    itemModifier: Modifier = Modifier,
    chipShape: RoundedCornerShape = RoundedCornerShape(32.dp),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    verticalArrangement: Arrangement.Vertical = Arrangement.Center,
    maxItemsInEachRow: Int,
    actionButton: @Composable () -> Unit = {},
    itemContent: @Composable (item: T, isSelected: Boolean) -> Unit,
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement,
        verticalArrangement = verticalArrangement,
        maxItemsInEachRow = maxItemsInEachRow,
    ) {
        actionButton()
        items.forEach { item ->
            SelectionContentChip(
                modifier = itemModifier,
                onSelect = { onSelectedItemChanged(item) },
                shape = chipShape,
                isSelected = selectedItems.contains(item),
                chipContent = { itemContent(item, selectedItems.contains(item)) },
            )
        }
    }
}

@ElementPreview
@Composable
internal fun MultipleSelectionChipFlowRowPreview() {
    val items = listOf(
        "First" to true,
        "Second" to true,
        "Third" to false,
        "Fourth" to false,
        "Fifth" to false
    )

    var selectedItemsList by remember { mutableStateOf(listOf(items[0], items[1])) }
    BlocksThemePreview {
        Box(modifier = Modifier) {
            MultipleSelectionChipFlowRow(
                items = items,
                selectedItems = selectedItemsList,
                onSelectedItemChanged = { selectedItem ->
                    val tempList = mutableListOf<Pair<String, Boolean>>()
                    tempList.addAll(selectedItemsList)
                    val isDeleted = tempList.removeIf { selectedItem.first == it.first }
                    if (!isDeleted) { tempList.add(selectedItem) }
                    selectedItemsList = tempList
                },
                maxItemsInEachRow = 3,
                itemModifier = Modifier
                    .wrapContentSize()
                    .padding(end = 8.dp, top = 16.dp),
                chipShape = RoundedCornerShape(16.dp),
                itemContent = { item, _ ->
                    Label(text = item.first)
                }
            )
        }
    }
}