package br.com.desafio.home

import br.com.desafio.service.RetrofitB2W
import br.com.desafio.util.WrapperLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class HomeInteractor : OnHomeMVP.Interactor {

    var retro: RetrofitB2W? = null

    override fun initRetrofit(retrofit: RetrofitB2W) {
        this.retro = retrofit
    }

    override fun loadBanners(
        callback: HomePresenter<OnHomeMVP.View, OnHomeMVP.Interactor>,
        retrofit: RetrofitB2W
    ) {

        val request = retrofit.b2wService().getBanners()

        GlobalScope.launch(Dispatchers.Default) {
            try {
                val response = request.await()
                callback.loadBanners(response.body()!!.data)
            } catch (e: HttpException) {
                WrapperLog.error(e.code().toString())
                callback.error(e.code())
            } catch (e: Throwable) {
                WrapperLog.error(e.stackTrace.toString())
            }
        }

    }

    override fun loadCategorias(callback: HomePresenter<OnHomeMVP.View, OnHomeMVP.Interactor>, retrofit: RetrofitB2W) {

        val request = retrofit.b2wService().getCategorias()

        GlobalScope.launch(Dispatchers.Default) {
            try {
                val response = request.await()
                callback.loadCategorias(response.body()!!.data)
            } catch (e: HttpException) {
                WrapperLog.error(e.code().toString())
                callback.error(e.code())
            } catch (e: Throwable) {
                WrapperLog.error(e.stackTrace.toString())
            }
        }
    }

    override fun loadProdutosMaisVendidos(
        callback: HomePresenter<OnHomeMVP.View, OnHomeMVP.Interactor>,
        retrofit: RetrofitB2W
    ) {
        val request = retrofit.b2wService().getProdutosMaisVendidos()

        GlobalScope.launch(Dispatchers.Default) {
            try {
                val response = request.await()
                callback.loadProdutosMaisVendidos(response.body()!!.data)
            } catch (e: HttpException) {
                WrapperLog.error(e.code().toString())
                callback.error(e.code())
            } catch (e: Throwable) {
                WrapperLog.error(e.stackTrace.toString())
            }
        }
    }
}