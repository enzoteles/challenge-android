package br.com.desafio.home

import br.com.desafio.home.fragment.ListBannersFragment
import br.com.desafio.service.DataBanner
import br.com.desafio.service.DataCagetoria
import br.com.desafio.service.DataProduto
import br.com.desafio.util.OnGenericMVP
import br.com.desafio.service.RetrofitB2W

/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

interface OnHomeMVP {

    interface View : OnGenericMVP.View {
        fun loadBanners(banners: List<DataBanner>?)
        fun msgError(error: String)
        fun loadCategorias(categorias: List<DataCagetoria>?)
        fun loadProdutosMaisVendidos(produtos: List<DataProduto>?)
        fun initToolbar()
        fun initDrawerLayout()
        fun initListProdutosMaisVendidosFragments(produtos: List<DataProduto>?)
        fun addListFragmentBanner(listFragBanner: ListBannersFragment)
    }

    interface Presenter<V, I> : OnGenericMVP.Presenter<OnHomeMVP.View, OnHomeMVP.Interactor> {
        fun getView(): V
        fun getInteractor(): I
        fun loadBanners(banners: List<DataBanner>?)
        fun loadCategorias(categorias: List<DataCagetoria>?)
        fun loadProdutosMaisVendidos(produtos: List<DataProduto>?)
        fun error(code: Int)
    }

    interface Interactor : OnGenericMVP.Interactor {
        fun loadBanners(callback: HomePresenter<View, Interactor>, retrofit: RetrofitB2W)
        fun loadCategorias(callback: HomePresenter<View, Interactor>, retrofit: RetrofitB2W)
        fun loadProdutosMaisVendidos(callback: HomePresenter<View, Interactor>, retrofit: RetrofitB2W)
        fun initRetrofit(retrofit: RetrofitB2W)
    }
}