package br.com.desafio.sobre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.desafio.R
import br.com.desafio.base.BaseFragment

/**
 * Created by Enzo Teles on 06/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class SobreFragment: BaseFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.sobre_activity, container, false)

}