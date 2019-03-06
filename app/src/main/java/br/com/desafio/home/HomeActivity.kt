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
import br.com.desafio.home.fragment.HomeFragment
import br.com.desafio.home.fragment.ListBannersFragment
import br.com.desafio.home.fragment.ListCategoriasFragment
import br.com.desafio.home.fragment.ListProdutosMaisVendidosFragment
import br.com.desafio.service.DataBanner
import br.com.desafio.service.DataCagetoria
import br.com.desafio.service.DataProduto
import br.com.desafio.sobre.SobreActvity
import br.com.desafio.sobre.SobreFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.android.ext.android.inject

/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class HomeActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener{

    var transaction: FragmentTransaction?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
        initDrawerLayout()
        initView()
    }

    fun initToolbar() {
        setSupportActionBar(toolbar)
    }

    fun initDrawerLayout() {
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }


    fun initView() {
        navView.setNavigationItemSelectedListener(this)
        val home = HomeFragment()
        transaction = supportFragmentManager.beginTransaction()
        transaction!!.add(R.id.content, home)
        transaction!!.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_item_one -> {
                val home = HomeFragment()
                transaction = supportFragmentManager.beginTransaction()
                transaction!!.replace(R.id.content, home)
                transaction!!.commit()
            }
            R.id.nav_item_two -> {
                val sobre = SobreFragment()
                transaction = supportFragmentManager.beginTransaction()
                transaction!!.replace(R.id.content, sobre)
                transaction!!.commit()
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
