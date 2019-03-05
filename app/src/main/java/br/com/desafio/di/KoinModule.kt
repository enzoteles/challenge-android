package br.com.desafio.di

import br.com.desafio.home.HomeInteractor
import br.com.desafio.home.HomePresenter
import br.com.desafio.home.OnHomeMVP
import br.com.desafio.service.RetrofitB2W
import org.koin.dsl.module.module

/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

val homeModule = module {
    factory { HomePresenter<OnHomeMVP.View, OnHomeMVP.Interactor>(get() as RetrofitB2W) }
    factory { HomeInteractor() }
}

val retrofitModule = module {
    single {RetrofitB2W()}
}


