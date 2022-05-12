package com.helio.compose.simpleapp.app

import android.app.Application
import com.helio.compose.simpleapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class TestApplication : Application() {

    override fun onCreate() {

        super.onCreate()

        GlobalContext.startKoin{

            androidLogger()

            androidContext(this@TestApplication)

            modules(appModule)

        }


    }


}