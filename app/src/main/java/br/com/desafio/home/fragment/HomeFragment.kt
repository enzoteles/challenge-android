package br.com.desafio.home.fragment

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.desafio.R
import br.com.desafio.base.BaseFragment
import br.com.desafio.home.HomeInteractor
import br.com.desafio.home.HomePresenter
import br.com.desafio.home.OnHomeMVP
import br.com.desafio.service.DataBanner
import br.com.desafio.service.DataCagetoria
import br.com.desafio.service.DataProduto
import org.koin.android.ext.android.inject

/**
 * Created by Enzo Teles on 06/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class HomeFragment: BaseFragment(), OnHomeMVP.View{

    val mPresenter: HomePresenter<OnHomeMVP.View, OnHomeMVP.Interactor> by inject()
    val mInteractor: HomeInteractor by inject()
    var transaction: FragmentTransaction?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.home_fragment, container,false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initView()
        initDate()
    }

    override fun loadBanners(banners: List<DataBanner>?) {
        val fragBanner = ListBannersFragment(banners)
        transaction = activity!!.supportFragmentManager.beginTransaction()
        transaction!!.add(R.id.frag_banners, fragBanner)
        transaction!!.commitAllowingStateLoss()
        requestCategoria()
    }

    override fun loadCategorias(categorias: List<DataCagetoria>?) {
        val fragCategoria = ListCategoriasFragment(categorias)
        transaction = activity!!.supportFragmentManager.beginTransaction()
        transaction!!.add(R.id.frag_categorias, fragCategoria)
        transaction!!.commitAllowingStateLoss()
        requestProdutoMaisVendidos()
    }

    override fun loadProdutosMaisVendidos(produtos: List<DataProduto>?) {
        val fragProdutosMaisVendidos = ListProdutosMaisVendidosFragment(produtos)
        transaction = activity!!.supportFragmentManager.beginTransaction()
        transaction!!.add(R.id.frag_prod_mais_vend, fragProdutosMaisVendidos)
        transaction!!.commitAllowingStateLoss()
    }

    override fun initView() {
        mPresenter.initView(this, activity!!.baseContext)
    }

    override fun initDate() {
        mPresenter.initInteractor(mInteractor)
    }

    fun requestCategoria() {
        mPresenter.requestCategoria()
    }

    fun requestProdutoMaisVendidos() {
        mPresenter.requestProdutoMaisVendidos()
    }

    override fun isAttached() = activity!!.isFinishing

    override fun msgError(error: String) {
        error(error)
    }

}