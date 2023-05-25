package com.savchsm.movic.di

import com.savchsm.movic.data.di.dataModule
import com.savchsm.movic.data.di.networkModule

object MoviesApp {
    val modules = listOf(appModule, domainModule, dataModule, networkModule)
}