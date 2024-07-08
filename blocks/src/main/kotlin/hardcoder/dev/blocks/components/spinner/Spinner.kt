package hardcoder.dev.blocks.components.spinner

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.text.Label
import hardcoder.dev.blocks.components.text.input.InputText
import hardcoder.dev.blocks.components.text.input.InputTextConfig
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Spinner(
    isExpanded: Boolean,
    @StringRes items: List<Int>,
    @StringRes promptResId: Int,
    @StringRes selectedItemResId: Int,
    onSelectedItemChanged: (Int) -> Unit,
    onExpandedChanged: (Boolean) -> Unit,
) {
    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = onExpandedChanged,
    ) {
        InputText(
            inputTextConfig = InputTextConfig.Filled(
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(),
                text = stringResource(id = selectedItemResId),
                onTextChanged = { },
                isReadOnly = true,
                label = { Label(text = stringResource(id = promptResId)) },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
            )
        )

        DropdownMenu(
            expanded = isExpanded,
            modifier = Modifier.exposedDropdownSize(),
            onDismissRequest = { onExpandedChanged(false) },
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    text = {
                        Text(
                            text = stringResource(id = item),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    },
                    onClick = {
                        onSelectedItemChanged(item)
                        onExpandedChanged(false)
                    },
                )
            }
        }
    }
}

@ElementPreview
@Composable
private fun SpinnerPreview() {
    var isExpanded by remember { mutableStateOf(false) }

    BlocksThemePreview {
        Box(
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
        ) {
            Spinner(
                promptResId = R.string.default_nowEmpty_text,
                items = listOf(R.string.default_nowEmpty_text, R.string.placeholder_one_line_label),
                onSelectedItemChanged = {},
                onExpandedChanged = { isExpanded = it },
                selectedItemResId = R.string.placeholder_one_line_label,
                isExpanded = isExpanded
            )
        }
    }
}