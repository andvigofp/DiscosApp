package com.example.discosapp

import android.app.Application
import com.example.discosapp.data.AppContainer

class DiscosApplication: Application() {
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
    }
}