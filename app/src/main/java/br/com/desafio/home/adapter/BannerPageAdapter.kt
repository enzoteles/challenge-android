package br.com.desafio.home.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import br.com.desafio.home.OnHomeMVP
import br.com.desafio.home.fragment.BannerItemFragment

/**
 * Created by Enzo Teles on 05/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class BannerPageAdapter(
    val fragmentManager: FragmentManager,
    val listFrags: ArrayList<BannerItemFragment>
) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = listFrags.get(position)
    override fun getCount() = listFrags!!.size


}