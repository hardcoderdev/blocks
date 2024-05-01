package hardcoder.dev.blocks.components.icon

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview
import androidx.compose.foundation.Image as ComposeFoundationImage

@Composable
fun Image(
    modifier: Modifier = Modifier,
    imageResId: Int,
    contentScale: ContentScale = ContentScale.Fit,
    @StringRes contentDescription: Int? = null,
) {
    ComposeFoundationImage(
        modifier = modifier,
        contentScale = contentScale,
        painter = painterResource(id = imageResId),
        contentDescription = contentDescription?.let { stringResource(id = it) },
    )
}

@ElementPreview
@Composable
private fun ImagePreview() {
    BlocksThemePreview {
        Image(imageResId = R.drawable.uikit_sample_image,)
    }
}