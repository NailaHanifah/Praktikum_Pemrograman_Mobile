package com.example.listfilm.data.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun setDarkMode(enabled: Boolean) {
        prefs.edit().putBoolean("dark_mode", enabled).apply()
    }

    fun isDarkMode(): Boolean = prefs.getBoolean("dark_mode", false)
}
