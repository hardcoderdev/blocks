package hardcoder.dev.blocks.components.sections

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.statistics.StatisticData
import hardcoder.dev.blocks.components.statistics.Statistics
import hardcoder.dev.blocks.components.text.Title
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
fun StatisticsSection(
    @StringRes titleResource: Int,
    statisticsDataList: List<StatisticData>,
) {
    Title(text = stringResource(id = titleResource))
    Spacer(modifier = Modifier.height(16.dp))
    Statistics(statistics = statisticsDataList)
}

@Preview
@Composable
private fun StatisticsSectionPreview() {
    BlocksThemePreview {
        StatisticsSection(
            titleResource = R.string.placeholder_one_line_label,
            statisticsDataList = listOf(
                StatisticData("Name1", "Value1"),
                StatisticData("Name2", "Value2"),
                StatisticData("Name3", "Value3"),
                StatisticData("Name4", "Value4"),
            ),
        )
    }
}