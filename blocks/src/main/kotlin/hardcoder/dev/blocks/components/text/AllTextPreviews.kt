package hardcoder.dev.blocks.components.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@ElementPreview
@Composable
private fun HeadlinePreview() {
    BlocksThemePreview {
        Headline(text = stringResource(id = R.string.placeholder_one_line_label))
    }
}

@ElementPreview
@Composable
private fun TitlePreview() {
    BlocksThemePreview {
        Title(text = stringResource(id = R.string.placeholder_one_line_label))
    }
}

@ElementPreview
@Composable
private fun DescriptionPreview() {
    BlocksThemePreview {
        Description(text = stringResource(id = R.string.placeholder_one_line_label))
    }
}

@ElementPreview
@Composable
private fun LabelPreview() {
    BlocksThemePreview {
        Label(text = stringResource(id = R.string.placeholder_one_line_label))
    }
}

@ElementPreview
@Composable
private fun ErrorTextPreview() {
    BlocksThemePreview {
        ErrorText(text = stringResource(id = R.string.placeholder_one_line_label))
    }
}