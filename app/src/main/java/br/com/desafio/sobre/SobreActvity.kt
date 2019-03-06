package br.com.desafio.sobre

import android.os.Bundle
import android.os.PersistableBundle
import br.com.desafio.R
import br.com.desafio.base.BaseActivity
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.sobre_activity.*

/**
 * Created by Enzo Teles on 06/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

class SobreActvity: BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sobre_activity)
        initToolbar()
    }

    private fun initToolbar() {
        toolbar_sobre.title = "sobre"
        setSupportActionBar(toolbar_sobre)
    }

}