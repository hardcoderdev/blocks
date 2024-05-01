package hardcoder.dev.blocks.components.tooltip.internal

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.PlainTooltip as MaterialPlainTooltip
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.icon.Icon
import hardcoder.dev.blocks.components.text.Label
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PlainTooltip(
    modifier: Modifier = Modifier,
    @StringRes tooltipResId: Int,
    content: @Composable () -> Unit,
) {
    TooltipBox(
        modifier = modifier,
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        state = rememberTooltipState(),
        content = content,
        tooltip = {
            MaterialPlainTooltip(content = { Label(text = stringResource(tooltipResId)) })
        },
    )
}

@ElementPreview
@Composable
internal fun PlainTooltipPreview() {
    BlocksThemePreview {
        Box(modifier = Modifier.padding(32.dp),) {
            PlainTooltip(
                tooltipResId = R.string.default_nowEmpty_text,
                content = {
                    LargeFloatingActionButton(onClick = {}) {
                        Icon(
                            iconResId = R.drawable.ic_add,
                            contentDescription = null,
                        )
                    }
                },
            )
        }
    }
}