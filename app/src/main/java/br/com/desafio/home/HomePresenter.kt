package br.com.desafio.home

import android.content.Context
import br.com.desafio.service.DataBanner
import br.com.desafio.service.DataCagetoria
import br.com.desafio.service.DataProduto
import br.com.desafio.service.RetrofitB2W
import br.com.desafio.util.HttpStatusCodes

/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class HomePresenter<V : OnHomeMVP.View, I : OnHomeMVP.Interactor>(val retrofit: RetrofitB2W) : OnHomeMVP.Presenter<V, I> {

    //variables
    lateinit var mView: OnHomeMVP.View
    lateinit var mInteractor: OnHomeMVP.Interactor
    lateinit var baseContext: Context

    override fun initView(mView: OnHomeMVP.View, baseContext: Context) {
        this.mView = mView
        this.baseContext = baseContext
    }

    override fun initInteractor(mInteractor: OnHomeMVP.Interactor) {
        this.mInteractor = mInteractor
        //lista de banners
        getInteractor().loadBanners(this as HomePresenter<OnHomeMVP.View, OnHomeMVP.Interactor>, retrofit)
        //lista de categorias
        getInteractor().loadCategorias(this as HomePresenter<OnHomeMVP.View, OnHomeMVP.Interactor>, retrofit)
        //lista de produtos mais vendidos
        getInteractor().loadProdutosMaisVendidos(this as HomePresenter<OnHomeMVP.View, OnHomeMVP.Interactor>, retrofit)
    }

    override fun getView() = mView as V

    override fun getInteractor() = mInteractor as I

    override fun loadBanners(banners: List<DataBanner>?) {
        if (mView.isAttached()){
            mView.loadBanners(banners)
        }
    }

    override fun loadCategorias(categorias: List<DataCagetoria>?) {
        if (mView.isAttached()){
            mView.loadCategorias(categorias)
        }
    }

    override fun loadProdutosMaisVendidos(produtos: List<DataProduto>?) {
        if (mView.isAttached()){
            mView.loadProdutosMaisVendidos(produtos)
        }
    }

    override fun error(code: Int) {
        val error = HttpStatusCodes.errorStatusCode(code)
        mView.msgError(error)
    }

}