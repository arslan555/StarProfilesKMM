package com.arslan.starprofileskmm.android

import android.app.Application
import com.arslan.starprofileskmm.di.initKoin

class StarReposApp : Application() {
    override fun onCreate() {
        super.onCreate()

     //   ContextUtils.setContext(context = this)

        initKoin {
//            androidLogger(level = Level.NONE)
//            androidContext(androidContext = this@NotflixApplication)
        }
    }
}