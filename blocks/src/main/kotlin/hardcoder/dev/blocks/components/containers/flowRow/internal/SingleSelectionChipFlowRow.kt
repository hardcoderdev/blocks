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
internal fun <T> SingleSelectionChipFlowRow(
    modifier: Modifier = Modifier,
    items: List<T>,
    selectedItem: T,
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
                isSelected = selectedItem == item,
                chipContent = { itemContent(item, selectedItem == item) },
            )
        }
    }
}

@ElementPreview
@Composable
internal fun SingleSelectionChipFlowRowPreview() {
    val items = listOf("First", "Second", "Third", "Fourth", "Fifth")
    var selectedItem by remember { mutableStateOf(items[0]) }
    BlocksThemePreview {
        Box(modifier = Modifier) {
            SingleSelectionChipFlowRow(
                items = items,
                selectedItem = selectedItem,
                onSelectedItemChanged = { selectedItem = it },
                maxItemsInEachRow = 3,
                itemModifier = Modifier
                    .wrapContentSize()
                    .padding(end = 8.dp, top = 16.dp),
                chipShape = RoundedCornerShape(16.dp),
                itemContent = { item, _ ->
                    Label(text = item)
                }
            )
        }
    }
}