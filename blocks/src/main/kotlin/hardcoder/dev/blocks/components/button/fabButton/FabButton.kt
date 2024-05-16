package hardcoder.dev.blocks.components.button.fabButton

import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.runtime.Composable
import hardcoder.dev.blocks.components.button.internal.fabButton.ExtendedFabButton
import hardcoder.dev.blocks.components.button.internal.fabButton.ExtendedFabButtonPreview
import hardcoder.dev.blocks.components.button.internal.fabButton.LargeFabButton
import hardcoder.dev.blocks.components.button.internal.fabButton.LargeFabButtonPreview
import hardcoder.dev.blocks.components.button.internal.fabButton.SmallFabButton
import hardcoder.dev.blocks.components.button.internal.fabButton.SmallFabButtonPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

@Composable
fun FabButton(fabConfig: FabConfig) {
    when (fabConfig) {
        is FabConfig.SmallFab -> SmallFabButton(
            modifier = fabConfig.modifier,
            iconModifier = fabConfig.iconModifier,
            onFabClick = fabConfig.onFabClick,
            iconResId = fabConfig.iconResId,
            contentDescriptionResId = fabConfig.contentDescriptionResId,
            elevation = fabConfig.elevation ?: FloatingActionButtonDefaults.elevation()
        )

        is FabConfig.LargeFab -> LargeFabButton(
            modifier = fabConfig.modifier,
            iconModifier = fabConfig.iconModifier,
            onFabClick = fabConfig.onFabClick,
            iconResId = fabConfig.iconResId,
            contentDescriptionResId = fabConfig.contentDescriptionResId,
            elevation = fabConfig.elevation ?: FloatingActionButtonDefaults.elevation()
        )

        is FabConfig.ExtendedFab -> ExtendedFabButton(
            modifier = fabConfig.modifier,
            iconModifier = fabConfig.iconModifier,
            onFabClick = fabConfig.onFabClick,
            iconResId = fabConfig.iconResId,
            labelResId = fabConfig.labelResId,
            contentDescriptionResId = fabConfig.contentDescriptionResId,
            iconGravity = fabConfig.iconGravity,
            elevation = fabConfig.elevation ?: FloatingActionButtonDefaults.elevation()
        )
    }
}

@ElementPreview
@Composable
private fun SmallFabButtonPreview() {
    SmallFabButtonPreview()
}

@ElementPreview
@Composable
private fun LargeFabButtonPreview() {
    LargeFabButtonPreview()
}

@ElementPreview
@Composable
private fun ExtendedFabButtonPreview() {
    ExtendedFabButtonPreview()
}