package com.dhairyasharma.reactnativecompass

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager


class Compass(context: Context) : SensorEventListener {
    interface CompassListener {
        fun onNewAzimuth(azimuth: Float)
    }
    private var listener: CompassListener? = null
    private val sensorManager: SensorManager = context
        .getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val gsensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    private val msensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
    private val mGravity = FloatArray(3)
    private val mGeomagnetic = FloatArray(3)
    private val R = FloatArray(9)
    private val I = FloatArray(9)
    private var azimuth = 0f
    private var azimuthFix = 0f
    fun start() {
        sensorManager.registerListener(
            this, gsensor,
            SensorManager.SENSOR_DELAY_GAME
        )
        sensorManager.registerListener(
            this, msensor,
            SensorManager.SENSOR_DELAY_GAME
        )
    }
    fun stop() {
        sensorManager.unregisterListener(this)
    }
    fun setAzimuthFix(fix: Float) {
        azimuthFix = fix
    }
    fun resetAzimuthFix() {
        setAzimuthFix(0f)
    }
    fun setListener(l: CompassListener?) {
        listener = l
    }
    override fun onSensorChanged(event: SensorEvent) {
        val alpha = 0.97f
        synchronized(this) {
            if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                mGravity[0] = alpha * mGravity[0] + (1 - alpha) * event.values[0]
                mGravity[1] = alpha * mGravity[1] + (1 - alpha) * event.values[1]
                mGravity[2] = alpha * mGravity[2] + (1 - alpha) * event.values[2]
            }
            if (event.sensor.type == Sensor.TYPE_MAGNETIC_FIELD) {
                mGeomagnetic[0] = alpha * mGeomagnetic[0] + (1 - alpha) * event.values[0]
                mGeomagnetic[1] = alpha * mGeomagnetic[1] + (1 - alpha) * event.values[1]
                mGeomagnetic[2] = alpha * mGeomagnetic[2] + (1 - alpha) * event.values[2]
            }
            val success = SensorManager.getRotationMatrix(
                R, I, mGravity,
                mGeomagnetic
            )
            if (success) {
                val orientation = FloatArray(3)
                SensorManager.getOrientation(R, orientation)
                azimuth =
                    Math.toDegrees(orientation[0].toDouble()).toFloat()
                azimuth = (azimuth + azimuthFix + 360) % 360
                if (listener != null) {
                    listener!!.onNewAzimuth(azimuth)
                }
            }
        }
    }
    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
}