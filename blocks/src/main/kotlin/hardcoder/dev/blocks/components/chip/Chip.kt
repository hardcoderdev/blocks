package hardcoder.dev.blocks.components.chip

import androidx.compose.runtime.Composable
import hardcoder.dev.blocks.components.chip.internal.ActionChip
import hardcoder.dev.blocks.components.chip.internal.ActionChipPreview
import hardcoder.dev.blocks.components.chip.internal.SelectionChip
import hardcoder.dev.blocks.components.chip.internal.SelectionChipPreview
import hardcoder.dev.blocks.components.chip.internal.StaticChip
import hardcoder.dev.blocks.components.chip.internal.StaticChipPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

@Composable
fun Chip(chipConfig: ChipConfig) {
    when (chipConfig) {
        is ChipConfig.Action -> {
            ActionChip(
                onClick = chipConfig.onClick,
                text = chipConfig.text,
                modifier = chipConfig.modifier,
                overflow = chipConfig.overflow,
                iconResId = chipConfig.iconResId,
                padding = chipConfig.padding,
                shape = chipConfig.shape,
            )
        }
        is ChipConfig.Selection -> {
            SelectionChip(
                onSelect = chipConfig.onSelect,
                text = chipConfig.text,
                modifier = chipConfig.modifier,
                overflow = chipConfig.overflow,
                iconResId = chipConfig.iconResId,
                padding = chipConfig.padding,
                shape = chipConfig.shape,
                isSelected = chipConfig.isSelected,
            )
        }
        is ChipConfig.Static -> {
            StaticChip(
                text = chipConfig.text,
                modifier = chipConfig.modifier,
                overflow = chipConfig.overflow,
                iconResId = chipConfig.iconResId,
                padding = chipConfig.padding,
                shape = chipConfig.shape,
            )
        }
    }
}

@ElementPreview
@Composable
private fun ActionChipPreview() {
    ActionChipPreview()
}

@ElementPreview
@Composable
private fun SelectionChipPreview() {
    SelectionChipPreview()
}

@ElementPreview
@Composable
private fun StaticChipPreview() {
    StaticChipPreview()
}