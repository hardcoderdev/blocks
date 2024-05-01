package hardcoder.dev.blocks.components.icon

import androidx.annotation.DrawableRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview
import androidx.compose.material3.Icon as MaterialIcon

@Composable
fun Icon(
    modifier: Modifier = Modifier,
    @DrawableRes iconResId: Int,
    contentDescription: String? = null,
) {
    MaterialIcon(
        modifier = modifier,
        painter = painterResource(id = iconResId),
        contentDescription = contentDescription,
        tint = MaterialTheme.colorScheme.onBackground,
    )
}

@ElementPreview
@Composable
private fun IconPreview() {
    BlocksThemePreview {
        Icon(iconResId = R.drawable.ic_add)
    }
}