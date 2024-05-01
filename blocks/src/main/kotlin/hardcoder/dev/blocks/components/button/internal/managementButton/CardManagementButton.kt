package hardcoder.dev.blocks.components.button.internal.managementButton

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.card.Card
import hardcoder.dev.blocks.components.card.CardConfig
import hardcoder.dev.blocks.components.text.Label
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
internal fun CardManagementButton(
    modifier: Modifier = Modifier,
    @StringRes titleResId: Int,
    @DrawableRes iconResId: Int = R.drawable.ic_create,
    onManage: () -> Unit,
) {
    Card(
        cardConfig = CardConfig.Action(
            onClick = onManage,
            modifier = modifier.padding(
                start = 4.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 16.dp,
            ),
            cardContent = {
                Column(
                    modifier = Modifier
                        .width(130.dp)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        modifier = Modifier.height(60.dp),
                        painter = painterResource(id = iconResId),
                        contentDescription = stringResource(id = R.string.placeholder_one_line_label),
                        alignment = Alignment.Center,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Label(text = stringResource(id = titleResId))
                }
            },
        ),
    )
}

@ElementPreview
@Composable
internal fun CardManagementButtonPreview() {
    BlocksThemePreview {
        CardManagementButton(
            onManage = {},
            titleResId = R.string.placeholder_one_line_label,
        )
    }
}