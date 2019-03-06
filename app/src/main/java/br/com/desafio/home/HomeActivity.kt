package br.com.desafio.home

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import br.com.desafio.R
import br.com.desafio.base.BaseActivity
import br.com.desafio.home.fragment.ListBannersFragment
import br.com.desafio.home.fragment.ListCategoriasFragment
import br.com.desafio.home.fragment.ListProdutosMaisVendidosFragment
import br.com.desafio.service.DataBanner
import br.com.desafio.service.DataCagetoria
import br.com.desafio.service.DataProduto
import br.com.desafio.sobre.SobreActvity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.android.ext.android.inject

/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class HomeActivity : BaseActivity(), OnHomeMVP.View , NavigationView.OnNavigationItemSelectedListener{

    val mPresenter: HomePresenter<OnHomeMVP.View, OnHomeMVP.Interactor> by inject()
    val mInteractor: HomeInteractor by inject()
    var transaction: FragmentTransaction?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
        initDrawerLayout()
        initView()
        initDate()
    }

    override fun initToolbar() {
        setSupportActionBar(toolbar)
    }

    override fun initDrawerLayout() {
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun loadBanners(banners: List<DataBanner>?) {
        val fragBanner = ListBannersFragment(banners)
        transaction = supportFragmentManager.beginTransaction()
        transaction!!.add(R.id.frag_banners, fragBanner!!)
        transaction!!.commitAllowingStateLoss()
        requestCategoria()
    }

    override fun loadCategorias(categorias: List<DataCagetoria>?) {
        val fragCategoria = ListCategoriasFragment(categorias)
        transaction = supportFragmentManager.beginTransaction()
        transaction!!.add(R.id.frag_categorias, fragCategoria!!)
        transaction!!.commitAllowingStateLoss()
        requestProdutoMaisVendidos()
    }

    override fun loadProdutosMaisVendidos(produtos: List<DataProduto>?) {
        val fragProdutosMaisVendidos = ListProdutosMaisVendidosFragment(produtos)
        transaction = supportFragmentManager.beginTransaction()
        transaction!!.add(R.id.frag_prod_mais_vend, fragProdutosMaisVendidos!!)
        transaction!!.commitAllowingStateLoss()
    }

    override fun initView() {
        mPresenter.initView(this, baseContext)
        navView.setNavigationItemSelectedListener(this)
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

    override fun isAttached() = !isFinishing

    override fun msgError(error: String) {
        error(error)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_item_one -> {
                // Handle the camera action
            }
            R.id.nav_item_two -> {
                val intent = Intent(this, SobreActvity::class.java)
                startActivity(intent)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}
