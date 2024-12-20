package hardcoder.dev.blocks.components.topBar.internal

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hardcoder.dev.blocks.R
import hardcoder.dev.blocks.components.button.circleIconButton.CircleIconButton
import hardcoder.dev.blocks.components.button.circleIconButton.CircleIconButtonConfig
import hardcoder.dev.blocks.components.icon.Icon
import hardcoder.dev.blocks.components.text.Text
import hardcoder.dev.blocks.components.topBar.Action
import hardcoder.dev.blocks.components.topBar.ActionConfig
import hardcoder.dev.blocks.preview.elements.ElementPreview
import hardcoder.dev.blocks.preview.values.BlocksThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopBar(
    @StringRes titleResId: Int,
    onGoBack: () -> Unit,
    actionConfig: ActionConfig? = null,
    searchText: String,
    placeholderText: Int,
    onSearchTextChanged: (String) -> Unit,
    onClearClick: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    val inputService = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var isSearchModeEnabled by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Box(
                modifier = Modifier.padding(end = 16.dp),
                contentAlignment = Alignment.Center,
            ) {
                AnimatedVisibility(
                    visible = !isSearchModeEnabled,
                    enter = fadeIn(),
                    exit = fadeOut(),
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = titleResId),
                    )
                }

                AnimatedVisibility(
                    visible = isSearchModeEnabled,
                    enter = fadeIn(),
                    exit = fadeOut(),
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .heightIn(min = 40.dp, max = 60.dp)
                            .padding(horizontal = 6.dp)
                            .focusRequester(focusRequester),
                        value = searchText,
                        onValueChange = onSearchTextChanged,
                        textStyle = MaterialTheme.typography.labelMedium,
                        placeholder = {
                            Text(
                                text = stringResource(id = placeholderText),
                                style = MaterialTheme.typography.labelMedium,
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        trailingIcon = {
                            Icon(
                                iconResId = R.drawable.ic_clear,
                                contentDescription = stringResource(id = R.string.icon_search_clear_content_description),
                                modifier = Modifier.clickable {
                                    onClearClick()
                                    inputService?.hide()
                                    focusManager.clearFocus()
                                    isSearchModeEnabled = false
                                },
                            )
                        },
                        maxLines = 1,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = androidx.compose.ui.text.input.ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                            },
                        ),
                    )

                    LaunchedEffect(isSearchModeEnabled) {
                        if (isSearchModeEnabled) {
                            focusRequester.requestFocus()
                            inputService?.show()
                        }
                    }
                }
            }
        },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        navigationIcon = {
            AnimatedVisibility(
                visible = !isSearchModeEnabled,
                enter = fadeIn() + expandHorizontally { -it },
                exit = fadeOut() + shrinkHorizontally { -it },
            ) {
                CircleIconButton(
                    circleIconButtonConfig = CircleIconButtonConfig.Filled(
                        onClick = onGoBack,
                        iconResId = R.drawable.ic_back,
                    ),
                )
            }
        },
        actions = {
            Row {
                AnimatedVisibility(
                    visible = !isSearchModeEnabled,
                    enter = fadeIn() + expandHorizontally { -it },
                    exit = fadeOut() + shrinkHorizontally { -it },
                ) {
                    CircleIconButton(
                        circleIconButtonConfig = CircleIconButtonConfig.Filled(
                            onClick = { isSearchModeEnabled = true },
                            iconResId = R.drawable.ic_search,
                        ),
                    )
                }
                actionConfig?.let {
                    it.actions.forEach { action ->
                        CircleIconButton(
                            circleIconButtonConfig = CircleIconButtonConfig.Filled(
                                onClick = action.onActionClick,
                                iconResId = action.iconResId,
                            ),
                        )
                    }
                }
            }
        },
    )
}

@ElementPreview
@Composable
internal fun SearchTopBarPreview() {
    var searchText by remember { mutableStateOf("") }

    BlocksThemePreview {
        SearchTopBar(
            titleResId = R.string.placeholder_one_line_label,
            onGoBack = { /* no-op */ },
            searchText = searchText,
            onSearchTextChanged = { searchText = it },
            onClearClick = {},
            placeholderText = R.string.default_nowEmpty_text,
            actionConfig = ActionConfig(
                actions = listOf(
                    Action(
                        iconResId = R.drawable.ic_add,
                        onActionClick = {},
                    ),
                ),
            ),
        )
    }
}