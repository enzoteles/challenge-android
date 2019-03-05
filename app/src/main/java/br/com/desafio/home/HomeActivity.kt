package br.com.desafio.home

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import br.com.desafio.R
import br.com.desafio.base.BaseActivity
import br.com.desafio.service.DataBanner
import br.com.desafio.service.DataCagetoria
import br.com.desafio.service.DataProduto
import br.com.desafio.util.WrapperLog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.android.ext.android.inject

/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class HomeActivity : BaseActivity(), OnHomeMVP.View , NavigationView.OnNavigationItemSelectedListener{

    val mPresenter: HomePresenter<OnHomeMVP.View, OnHomeMVP.Interactor> by inject()
    val mInteractor: HomeInteractor by inject()

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
        banners!!.forEach {
            WrapperLog.info("${it.linkUrl}")
        }
    }

    override fun loadCategorias(categorias: List<DataCagetoria>?) {
        categorias!!.forEach {
            WrapperLog.info("${it.descricao}")
        }
    }

    override fun loadProdutosMaisVendidos(produtos: List<DataProduto>?) {
        produtos!!.forEach {
            WrapperLog.info("${it.descricao}")
        }
    }

    override fun initView() {
        mPresenter.initView(this, baseContext)
        navView.setNavigationItemSelectedListener(this)
    }

    override fun initDate() {
        mPresenter.initInteractor(mInteractor)
    }

    override fun isAttached(): Boolean {
        return !isFinishing
    }

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

            }
            R.id.nav_item_three -> {

            }
            R.id.nav_item_four -> {

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
