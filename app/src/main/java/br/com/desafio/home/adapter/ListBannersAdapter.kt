package br.com.desafio.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.desafio.R
import br.com.desafio.service.DataBanner
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Enzo Teles on 05/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class ListBannersAdapter(val items: List<DataBanner>?, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_list_categorias, parent, false))

    override fun getItemCount() = items!!.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class ViewHolder(view: View): RecyclerView.ViewHolder(view)