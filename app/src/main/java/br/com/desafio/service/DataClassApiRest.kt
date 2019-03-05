package br.com.desafio.service

import java.io.Serializable

/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

// Api Rest

data class Banner(val `data`: List<DataBanner>) : Serializable

data class DataBanner(val id: Int,val linkUrl: String,val urlImagem: String) : Serializable

data class Categoria(val `data`: List<DataCagetoria>) : Serializable

data class DataCagetoria(val descricao: String,val id: Int,val urlImagem: String) : Serializable

data class DataProduto(val categoria: DataCagetoria,val descricao: String,val id: Int,val nome: String,val precoDe: Int,val precoPor: Double,val urlImagem: String)

data class Produto(val `data`: List<DataProduto>)