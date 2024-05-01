package hardcoder.dev.blocks.components.button.managementButton

import androidx.compose.runtime.Composable
import hardcoder.dev.blocks.components.button.internal.managementButton.CardManagementButton
import hardcoder.dev.blocks.components.button.internal.managementButton.CardManagementButtonPreview
import hardcoder.dev.blocks.components.button.internal.managementButton.ChipManagementButton
import hardcoder.dev.blocks.components.button.internal.managementButton.ChipManagementButtonPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

@Composable
fun ManagementButton(managementButtonConfig: ManagementButtonConfig) {
    when (managementButtonConfig) {
        is ManagementButtonConfig.Card -> {
            CardManagementButton(
                modifier = managementButtonConfig.modifier,
                titleResId = managementButtonConfig.titleResId,
                iconResId = managementButtonConfig.iconResId,
                onManage = managementButtonConfig.onClick,
            )
        }

        is ManagementButtonConfig.Chip -> {
            ChipManagementButton(
                modifier = managementButtonConfig.modifier,
                titleResId = managementButtonConfig.titleResId,
                iconResId = managementButtonConfig.iconResId,
                onManage = managementButtonConfig.onClick,
            )
        }
    }
}

@ElementPreview
@Composable
private fun ChipManagementButtonPreview() {
    ChipManagementButtonPreview()
}

@ElementPreview
@Composable
private fun CardManagementButtonPreview() {
    CardManagementButtonPreview()
}