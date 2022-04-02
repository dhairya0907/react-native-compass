package com.dhairyasharma.reactnativecompass

import android.content.Context
import android.content.SharedPreferences
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.RelativeLayout
import com.dhairyasharma.reactnativecompass.Compass.CompassListener
import com.facebook.react.bridge.UiThreadUtil.runOnUiThread
import kotlin.math.roundToInt


class CompassModule(context: Context?) : RelativeLayout(context) {

    private var compass: Compass? = null
    private var arrowView: ImageView? = null
    private var currentAzimuth = 0f
    private var sotwFormatter: SOTWFormatter? = null
    var sharedPreferences: SharedPreferences? = null
    var handHeight: Int? = null

    init {
        inflate(this.context, R.layout.compassmodulelayout, this)
        sotwFormatter = context?.let { SOTWFormatter(it) }
        arrowView = findViewById(R.id.compass_hands)
        sharedPreferences = context?.getSharedPreferences("CURRENT_DEGREE", Context.MODE_PRIVATE)
        compass = Compass(this.context)
        val cl: CompassListener = getCompassListener()
        compass!!.setListener(cl)
        compass!!.start()
    }
    fun setIsTurnedOn(handHeightSpan: Int) {
        handHeight = handHeightSpan
        changeHandHeight()
    }
    private fun changeHandHeight(){
        val scale : Float = resources.displayMetrics.density
        val layoutParams: ViewGroup.LayoutParams? = arrowView?.layoutParams
        layoutParams?.height = (handHeight?.times(scale))?.roundToInt()
        arrowView?.layoutParams = layoutParams
    }
    private fun adjustArrow(azimuth: Float) {
        val an: Animation = RotateAnimation(
            -currentAzimuth, -azimuth,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
            0.5f
        )
        currentAzimuth = azimuth
        an.duration = 500
        an.repeatCount = 0
        an.fillAfter = true
        arrowView!!.startAnimation(an)
    }
    private fun adjustSotwLabel(azimuth: Float) {
        var editor = sharedPreferences?.edit()
        editor?.putString("degree",sotwFormatter!!.format(azimuth))
        editor?.commit()
    }
    private fun getCompassListener(): CompassListener {
        return object : CompassListener {
            override fun onNewAzimuth(azimuth: Float) {
                runOnUiThread {
                    adjustArrow(azimuth)
                    adjustSotwLabel(azimuth)
                }
            }
        }
    }
}
