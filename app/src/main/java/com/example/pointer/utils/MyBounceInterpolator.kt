package com.example.pointer.utils

import kotlin.math.cos
import kotlin.math.pow

class MyBounceInterpolator: android.view.animation.Interpolator {

    private var mAmplitude = 1.0
    private var mFrequency = 10.0

    constructor(mAmplitude: Double, mFrequency: Double) {
        this.mAmplitude = mAmplitude
        this.mFrequency = mFrequency
    }

    override fun getInterpolation(input: Float): Float {
        return ((-1 * Math.E.pow(-input / mAmplitude) *
                cos(mFrequency * input) + 1).toFloat())
    }
}