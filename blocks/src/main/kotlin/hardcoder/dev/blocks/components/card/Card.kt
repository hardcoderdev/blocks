package hardcoder.dev.blocks.components.card

import androidx.compose.runtime.Composable
import hardcoder.dev.blocks.components.card.internal.ActionCard
import hardcoder.dev.blocks.components.card.internal.ActionCardPreview
import hardcoder.dev.blocks.components.card.internal.SelectionCard
import hardcoder.dev.blocks.components.card.internal.SelectionCardPreview
import hardcoder.dev.blocks.components.card.internal.StaticCard
import hardcoder.dev.blocks.components.card.internal.StaticCardPreview
import hardcoder.dev.blocks.preview.elements.ElementPreview

@Composable
fun Card(cardConfig: CardConfig) {
    when (cardConfig) {
        is CardConfig.Action -> ActionCard(
            modifier = cardConfig.modifier,
            onClick = cardConfig.onClick,
            cardContent = cardConfig.cardContent,
        )

        is CardConfig.Selection -> SelectionCard(
            modifier = cardConfig.modifier,
            onSelect = cardConfig.onSelect,
            isSelected = cardConfig.isSelected,
            cardContent = cardConfig.cardContent,
        )

        is CardConfig.Static -> StaticCard(
            modifier = cardConfig.modifier,
            cardContent = cardConfig.cardContent,
        )
    }
}

@ElementPreview
@Composable
private fun ActionCardPreview() {
    ActionCardPreview()
}

@ElementPreview
@Composable
private fun SelectionCardPreview() {
    SelectionCardPreview()
}

@ElementPreview
@Composable
private fun StaticCardPreview() {
    StaticCardPreview()
}