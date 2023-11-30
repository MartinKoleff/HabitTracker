package com.koleff.habittracker

import androidx.lifecycle.DefaultLifecycleObserver
import dagger.hilt.android.HiltAndroidApp
import androidx.multidex.MultiDexApplication


@HiltAndroidApp
class KoleffApp : MultiDexApplication(), DefaultLifecycleObserver {

    override fun onCreate() {
        super<MultiDexApplication>.onCreate()
    }
}