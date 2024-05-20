package com.wild.wild.wild.west

import android.view.animation.RotateAnimation
import android.view.animation.Transformation

class CustomRotateAnimationWildWest(
    fromDegreesWildWest: Float,
    toDegreesWildWest: Float,
    pivotXTypeWildWest: Int,
    pivotXValueWildWest: Float,
    pivotYTypeWildWest: Int,
    pivotYValueWildWest: Float
) : RotateAnimation(fromDegreesWildWest, toDegreesWildWest, pivotXTypeWildWest, pivotXValueWildWest, pivotYTypeWildWest, pivotYValueWildWest) {
    override fun applyTransformation(interpolatedTimeWildWest: Float, tWildWest: Transformation?) {
        super.applyTransformation(interpolatedTimeWildWest, tWildWest)
    }
}