package hardcoder.dev.blocks.components.statistics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.text.Text
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
fun Statistics(
    modifier: Modifier = Modifier,
    statistics: List<StatisticData>,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        statistics.forEach { item ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .weight(1f),
                    text = item.name,
                    horizontalArrangement = Arrangement.Start,
                )
                Text(text = item.value)
            }

            if (item != statistics.last()) {
                HorizontalDivider()
            }
        }
    }
}

@ElementPreview
@Composable
private fun StatisticsPreview() {
    BlocksThemePreview {
        Statistics(
            statistics = listOf(
                StatisticData(
                    name = stringResource(id = R.string.placeholder_one_line_label),
                    value = "20",
                ),
                StatisticData(
                    name = stringResource(id = R.string.default_nowEmpty_text),
                    value = "40",
                ),
                StatisticData(
                    name = stringResource(id = R.string.placeholder_one_line_label),
                    value = "60",
                ),
                StatisticData(
                    name = stringResource(id = R.string.default_nowEmpty_text),
                    value = "80",
                ),
            ),
        )
    }
}