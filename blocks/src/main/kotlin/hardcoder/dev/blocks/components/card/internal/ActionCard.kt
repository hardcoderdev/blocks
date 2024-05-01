package hardcoder.dev.blocks.components.card.internal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.icon.Image
import hardcoder.dev.blocks.components.text.Title
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
internal fun ActionCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    cardContent: @Composable () -> Unit,
) {
    Card(
        modifier = modifier,
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        content = { cardContent() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp,
        ),
    )
}

@ElementPreview
@Composable
internal fun ActionCardPreview() {
    BlocksThemePreview {
        Box(modifier = Modifier.padding(32.dp)) {
            ActionCard(
                modifier = Modifier
                    .width(300.dp)
                    .height(200.dp),
                onClick = { /* Some selection logic here */ },
                cardContent = {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Title(text = stringResource(id = R.string.placeholder_one_line_label))
                        Spacer(modifier = Modifier.height(16.dp))
                        Image(
                            imageResId = R.drawable.uikit_sample_image,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Fit,
                        )
                    }
                },
            )
        }
    }
}