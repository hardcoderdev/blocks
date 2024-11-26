package hardcoder.dev.blocks.components.containers.flowRow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

sealed class SelectionChipFlowRowConfig<T> {

    data class SelectionChip<T>(
        val modifier: Modifier = Modifier,
        val itemModifier: Modifier = Modifier,
        val chipShape: RoundedCornerShape = RoundedCornerShape(32.dp),
        val horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
        val verticalArrangement: Arrangement.Vertical = Arrangement.Center,
        val maxItemsInEachRow: Int,
        val actionButton: @Composable () -> Unit = {},
        val itemContent: @Composable (item: T, isSelected: Boolean) -> Unit,
        val selectionType: SelectionType<T>,
        val items: List<T>,
        val onSelectionChanged: (T) -> Unit,
    ) : SelectionChipFlowRowConfig<T>()

    sealed interface SelectionType<T> {
        data class Single<T>(val selectedItem: T) : SelectionType<T>

        data class Multiple<T>(val selectedItemsList: List<T>) : SelectionType<T>
    }
}