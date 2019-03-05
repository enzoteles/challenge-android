package br.com.desafio.util

import android.content.Context
/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

interface OnGenericMVP{
    interface View{
        fun initView()
        fun initDate()
        fun isAttached(): Boolean
    }
    interface Presenter<V: View, I: Interactor>{
        fun initView(view: V, baseContext: Context)
        fun initInteractor(interactor: I)
    }
    interface Interactor {
    }
}