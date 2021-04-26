package com.example.shazam.android.system

import android.app.Activity
import java.lang.ref.WeakReference

class ActivityContextHolder {

    private var wrContext: WeakReference<Activity> = WeakReference<Activity>(null)

    fun insertContext(context: Activity) {
        wrContext.clear()
        wrContext = WeakReference(context)
    }

    fun clearContext() {
        wrContext.clear()
    }

    fun getContext(): Activity? = wrContext.get()
}