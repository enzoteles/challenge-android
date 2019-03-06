package br.com.desafio.home.adapter

import android.content.Context
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.desafio.R
import br.com.desafio.service.DataCagetoria
import br.com.desafio.service.DataProduto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_categorias.view.*
import kotlinx.android.synthetic.main.item_list_produtos_mais_vendidos.view.*

/**
 * Created by Enzo Teles on 05/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class ListProdutosMaisVendidosAdapter(val items: List<DataProduto>?, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolderProdutos(LayoutInflater.from(context).inflate(R.layout.item_list_produtos_mais_vendidos, parent, false))

    override fun getItemCount() = items!!.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val produto = items!!.get(position)

        holder?.itemView.tv_nome_produto.text = produto.nome
        holder?.itemView.tv_preco_de.text = "De: ${produto.precoDe.toString()}"
        holder?.itemView.tv_preco_por.text = "Por: ${produto.precoPor.toString()}"
        holder?.itemView.tv_preco_de.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)

        Picasso
            .with(context)
            .load(produto.urlImagem)
            .into(holder?.itemView.iv_produto_mais_vendido)

    }

}

class ViewHolderProdutos(view: View): RecyclerView.ViewHolder(view)
