package com.rgbstudios.cxrslides.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * A data class to represent the information presented in the dog card
 */
data class Slide(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val explanation: Int,
)