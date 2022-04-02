package com.dhairyasharma.reactnativecompass


import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class RNCompassModule : SimpleViewManager<CompassModule?>() {
    override fun getName(): String {
        return "RNCompassModule"
    }
    override fun createViewInstance(reactContext: ThemedReactContext): CompassModule {
        return CompassModule(reactContext)
    }
    @ReactProp(name = "handHeight")
    fun setSwitchStatus(switchView: CompassModule, handHeight: Int) {
        switchView.setIsTurnedOn(handHeight)
    }
}