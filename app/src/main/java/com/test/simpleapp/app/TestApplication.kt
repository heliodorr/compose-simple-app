package com.test.simpleapp.app

import android.app.Application
import android.util.Log
import com.test.simpleapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("AAA", "APP")

        GlobalContext.startKoin{

            Log.d("AAA", "APP")

            androidLogger()

            Log.d("AAA", "APP")

            androidContext(this@TestApplication)

            Log.d("AAA", "APP")

            modules(appModule)

        }
    }


}