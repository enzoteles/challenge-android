package br.com.desafio.base

import android.app.Application
import br.com.desafio.di.homeModule
import br.com.desafio.di.retrofitModule
import org.koin.android.ext.android.startKoin

/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class BaseApp : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(homeModule, retrofitModule))
    }

}