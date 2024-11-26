package hardcoder.dev.blocks.components.containers.flowRow

import androidx.compose.runtime.Composable
import hardcoder.dev.blocks.components.containers.flowRow.internal.MultipleSelectionChipFlowRow
import hardcoder.dev.blocks.components.containers.flowRow.internal.MultipleSelectionChipFlowRowPreview
import hardcoder.dev.blocks.components.containers.flowRow.internal.SingleSelectionChipFlowRow
import hardcoder.dev.blocks.components.containers.flowRow.internal.SingleSelectionChipFlowRowPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

@Composable
fun <T : Any> SelectionChipFlowRow(selectionChipFlowRowConfig: SelectionChipFlowRowConfig<T>) {
    when (selectionChipFlowRowConfig) {
        is SelectionChipFlowRowConfig.SelectionChip -> {
            when (val selectionType = selectionChipFlowRowConfig.selectionType) {
                is SelectionChipFlowRowConfig.SelectionType.Multiple<T> -> {
                    MultipleSelectionChipFlowRow(
                        modifier = selectionChipFlowRowConfig.modifier,
                        items = selectionChipFlowRowConfig.items,
                        selectedItems = selectionType.selectedItemsList,
                        onSelectedItemChanged = selectionChipFlowRowConfig.onSelectionChanged,
                        itemModifier = selectionChipFlowRowConfig.itemModifier,
                        chipShape = selectionChipFlowRowConfig.chipShape,
                        horizontalArrangement = selectionChipFlowRowConfig.horizontalArrangement,
                        verticalArrangement = selectionChipFlowRowConfig.verticalArrangement,
                        maxItemsInEachRow = selectionChipFlowRowConfig.maxItemsInEachRow,
                        actionButton = selectionChipFlowRowConfig.actionButton,
                        itemContent = selectionChipFlowRowConfig.itemContent
                    )
                }

                is SelectionChipFlowRowConfig.SelectionType.Single -> {
                    SingleSelectionChipFlowRow(
                        modifier = selectionChipFlowRowConfig.modifier,
                        items = selectionChipFlowRowConfig.items,
                        selectedItem = selectionType.selectedItem,
                        onSelectedItemChanged = selectionChipFlowRowConfig.onSelectionChanged,
                        itemModifier = selectionChipFlowRowConfig.itemModifier,
                        chipShape = selectionChipFlowRowConfig.chipShape,
                        horizontalArrangement = selectionChipFlowRowConfig.horizontalArrangement,
                        verticalArrangement = selectionChipFlowRowConfig.verticalArrangement,
                        maxItemsInEachRow = selectionChipFlowRowConfig.maxItemsInEachRow,
                        actionButton = selectionChipFlowRowConfig.actionButton,
                        itemContent = selectionChipFlowRowConfig.itemContent
                    )
                }
            }
        }
    }
}

@ElementPreview
@Composable
private fun SingleSelectionFlowRowPreview() {
    SingleSelectionChipFlowRowPreview()
}

@ElementPreview
@Composable
private fun MultipleSelectionFlowRowPreview() {
    MultipleSelectionChipFlowRowPreview()
}

