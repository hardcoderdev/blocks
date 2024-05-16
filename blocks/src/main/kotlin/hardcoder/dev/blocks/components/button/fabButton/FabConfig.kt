package hardcoder.dev.blocks.components.button.fabButton

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.ui.Modifier
import hardcoder.dev.blocks.components.button.internal.fabButton.IconGravity

sealed class FabConfig {
    data class SmallFab(
        val modifier: Modifier = Modifier,
        val iconModifier: Modifier = Modifier,
        @DrawableRes val iconResId: Int,
        @StringRes val contentDescriptionResId: Int? = null,
        val onFabClick: () -> Unit,
        val elevation: FloatingActionButtonElevation? = null,
    ) : FabConfig()

    data class LargeFab(
        val modifier: Modifier = Modifier,
        val iconModifier: Modifier = Modifier,
        @DrawableRes val iconResId: Int,
        @StringRes val contentDescriptionResId: Int? = null,
        val onFabClick: () -> Unit,
        val elevation: FloatingActionButtonElevation? = null,
    ) : FabConfig()

    data class ExtendedFab(
        val modifier: Modifier = Modifier,
        val iconModifier: Modifier = Modifier,
        @DrawableRes val iconResId: Int?,
        @StringRes val labelResId: Int,
        @StringRes val contentDescriptionResId: Int? = null,
        val iconGravity: IconGravity,
        val onFabClick: () -> Unit,
        val elevation: FloatingActionButtonElevation? = null,
    ) : FabConfig()
}