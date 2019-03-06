package br.com.desafio.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.desafio.R
import br.com.desafio.service.DataCagetoria
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_categorias.view.*

/**
 * Created by Enzo Teles on 05/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class ListCategoriaAdapter(val items: List<DataCagetoria>?, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_categorias, parent, false))

    override fun getItemCount() = items!!.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val categoria = items!!.get(position)

        holder?.itemView.tv_descricao.text = categoria.descricao
        Picasso
            .with(context)
            .load(categoria.urlImagem)
            .into(holder?.itemView.iv_produto)
    }

}

class ViewHolder(view: View): RecyclerView.ViewHolder(view)