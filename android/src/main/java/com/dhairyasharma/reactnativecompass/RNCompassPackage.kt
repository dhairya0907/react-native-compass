package com.dhairyasharma.reactnativecompass

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import java.util.*

class RNCompassPackage : ReactPackage {
    override fun createViewManagers(reactContext: ReactApplicationContext):
            MutableList<ViewManager<*, *>> {
        return mutableListOf(RNCompassModule())
    }
    override fun createNativeModules(reactContext: ReactApplicationContext):
            MutableList<NativeModule> {
        return Collections.emptyList();
    }
}
