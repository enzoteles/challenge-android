package br.com.desafio.service

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

interface BannerService{

    @GET("/banner")
    fun getBanners(): Deferred<Response<Banner>>

    @GET("/categoria")
    fun getCategorias(): Deferred<Response<Categoria>>

    @GET("/produto/maisvendidos")
    fun getProdutosMaisVendidos(): Deferred<Response<Produto>>
}