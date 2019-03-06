package br.com.desafio.home.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.desafio.R
import br.com.desafio.base.BaseFragment
import br.com.desafio.home.adapter.ListCategoriaAdapter
import br.com.desafio.home.adapter.ListProdutosMaisVendidosAdapter
import br.com.desafio.service.DataProduto
import kotlinx.android.synthetic.main.fragment_list_produtos_mais_vendidos.*

/**
 * Created by Enzo Teles on 04/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

@SuppressLint("ValidFragment")
class ListProdutosMaisVendidosFragment(var produtos: List<DataProduto>?) : BaseFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.fragment_list_produtos_mais_vendidos, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_produtos_mais_vendidos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rv_produtos_mais_vendidos.adapter = ListProdutosMaisVendidosAdapter(produtos, requireContext())
    }


}