package hardcoder.dev.blocks.components.containers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.components.card.internal.SelectionCard

@Composable
fun <T> SingleCardSelectionRow(
    items: List<T>,
    selectedItem: T,
    onSelectionChanged: (T) -> Unit,
    itemContent: @Composable (item: T, isSelected: Boolean) -> Unit,
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    itemModifier: RowScope.() -> Modifier = { Modifier },
) {
    Row(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment,
    ) {
        items.forEach { item ->
            val isSelected = selectedItem == item

            SelectionCard(
                modifier = itemModifier(),
                isSelected = isSelected,
                onSelect = { onSelectionChanged(item) },
            ) {
                itemContent(item, isSelected)
            }
        }
    }
}

@Composable
fun <T> SingleCardSelectionHorizontalGrid(
    itemContent: @Composable (item: T, isSelected: Boolean) -> Unit,
    rows: GridCells,
    itemsList: List<T>,
    selectedItem: T,
    onSelectionChanged: (T) -> Unit,
    modifier: Modifier = Modifier,
    gridState: LazyGridState = rememberLazyGridState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    horizontalArrangement: Arrangement.Horizontal = if (!reverseLayout) Arrangement.Start else Arrangement.End,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    userScrollEnabled: Boolean = true,
    itemModifier: LazyGridItemScope.() -> Modifier = { Modifier },
) {
    LazyHorizontalGrid(
        modifier = modifier,
        rows = rows,
        state = gridState,
        contentPadding = contentPadding,
        reverseLayout = reverseLayout,
        horizontalArrangement = horizontalArrangement,
        verticalArrangement = verticalArrangement,
        userScrollEnabled = userScrollEnabled,
    ) {
        items(itemsList) { item ->
            val isSelected = selectedItem == item

            SelectionCard(
                modifier = itemModifier(),
                isSelected = isSelected,
                onSelect = { onSelectionChanged(item) },
            ) {
                itemContent(item, isSelected)
            }
        }
    }
}