package hardcoder.dev.blocks.components.chip.internal

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.text.Text
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@Composable
internal fun ActionChip(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    padding: PaddingValues = PaddingValues(16.dp),
    @DrawableRes iconResId: Int? = null,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    shape: RoundedCornerShape = RoundedCornerShape(bottomEnd = 16.dp),
) {
    Row(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.primary, shape = shape)
            .clip(shape)
            .clickable(
                enabled = true,
                role = Role.Switch,
                onClick = onClick,
            )
            .padding(padding)
            .wrapContentWidth()
            .height(16.dp),
    ) {
        iconResId?.let {
            Icon(
                painter = painterResource(id = it),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary,
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onPrimary,
            overflow = overflow,
            fontWeight = FontWeight.Bold,
        )
    }
}

@ElementPreview
@Composable
internal fun ActionChipPreview() {
    BlocksThemePreview {
        ActionChip(
            onClick = { /* no-op */ },
            text = stringResource(id = R.string.placeholder_one_line_label),
            modifier = Modifier,
            padding = PaddingValues(16.dp),
            iconResId = R.drawable.ic_add,
            overflow = TextOverflow.Ellipsis,
            shape = RoundedCornerShape(16.dp),
        )
    }
}