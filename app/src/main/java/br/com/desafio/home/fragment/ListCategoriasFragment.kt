package br.com.desafio.home.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.desafio.R
import br.com.desafio.base.BaseFragment
import br.com.desafio.service.DataCagetoria

/**
 * Created by Enzo Teles on 04/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

@SuppressLint("ValidFragment")
class ListCategoriasFragment(categorias: List<DataCagetoria>?) : BaseFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_categorias, container, false)
    }

}