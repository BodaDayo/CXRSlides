package com.rgbstudios.cxrslides.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Slide(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val explanation: Int,
)