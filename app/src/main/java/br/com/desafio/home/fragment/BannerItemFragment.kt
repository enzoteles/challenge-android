package br.com.desafio.home.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.desafio.R
import br.com.desafio.base.BaseFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_banner_fragment.*

/**
 * Created by Enzo Teles on 05/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

@SuppressLint("ValidFragment")
class BannerItemFragment(var urlImage: String) : BaseFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.item_banner_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso
            .with(requireContext()) // give it the context
            .load(urlImage) // load the image
            .fit().centerCrop()
            .into(item_banner)


    }
}