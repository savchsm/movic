package com.savchsm.movic

import android.app.Application
import com.savchsm.movic.data.di.networkModule
import com.savchsm.movic.di.MoviesApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(MoviesApp.modules)
        }
    }
}