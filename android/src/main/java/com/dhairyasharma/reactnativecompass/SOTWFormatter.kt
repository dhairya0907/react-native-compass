package com.dhairyasharma.reactnativecompass

import android.content.Context

class SOTWFormatter(context: Context) {
    fun format(azimuth: Float): String {
        val iAzimuth = azimuth.toInt()
        val index = findClosestIndex(iAzimuth)
        return iAzimuth.toString() + "° " + names!![index]
    }
    private fun initLocalizedNames(context: Context) {
        if (names == null) {
            names = arrayOf(
                context.getString(R.string.sotw_north),
                context.getString(R.string.sotw_northeast),
                context.getString(R.string.sotw_east),
                context.getString(R.string.sotw_southeast),
                context.getString(R.string.sotw_south),
                context.getString(R.string.sotw_southwest),
                context.getString(R.string.sotw_west),
                context.getString(R.string.sotw_northwest),
                context.getString(R.string.sotw_north)
            )
        }
    }
    companion object {
        private val sides = intArrayOf(0, 45, 90, 135, 180, 225, 270, 315, 360)
        private var names: Array<String>? = null
        private fun findClosestIndex(target: Int): Int {
            var i = 0
            var j = sides.size
            var mid = 0
            while (i < j) {
                mid = (i + j) / 2
                if (target < sides[mid]) {
                    if (mid > 0 && target > sides[mid - 1]) {
                        return getClosest(mid - 1, mid, target)
                    }
                    j = mid
                } else {
                    if (mid < sides.size - 1 && target < sides[mid + 1]) {
                        return getClosest(mid, mid + 1, target)
                    }
                    i = mid + 1
                }
            }
            return mid
        }
        private fun getClosest(index1: Int, index2: Int, target: Int): Int {
            return if (target - sides[index1] >= sides[index2] - target) {
                index2
            } else index1
        }
    }
    init {
        initLocalizedNames(context)
    }
}