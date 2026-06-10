package com.example.listfilm

import android.app.Application
import timber.log.Timber

class ListFilmApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
