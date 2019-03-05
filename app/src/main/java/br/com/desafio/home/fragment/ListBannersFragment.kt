package br.com.desafio.home.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.desafio.R
import br.com.desafio.base.BaseFragment
import br.com.desafio.home.adapter.BannerPageAdapter
import br.com.desafio.service.DataBanner
import kotlinx.android.synthetic.main.fragment_list_banners.*

/**
 * Created by Enzo Teles on 04/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

@SuppressLint("ValidFragment")
class ListBannersFragment(var dataBanner: List<DataBanner>?) : BaseFragment(){

    var fragment: BannerItemFragment?= null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_banners, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createFrag()
    }

    private fun createFrag() {
        var listFragment = ArrayList<BannerItemFragment>()

        for(i in 0..dataBanner!!.size - 1){
            fragment = BannerItemFragment(dataBanner!!.get(i).urlImagem)
            listFragment.add(fragment!!)
        }
        val viewpageAdapter = BannerPageAdapter(activity!!.supportFragmentManager, listFragment)
        viewPager.adapter = viewpageAdapter
    }


}