package br.com.desafio.util

import android.content.Context
import android.util.Log
import android.widget.Toast
/**
 * Created by Enzo Teles on 03/03/19
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

fun Context.toast(msg:String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.error(msg:String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}


object WrapperLog{

    fun info(msg:String) {
        Log.i("B2W", msg)
    }

    fun debug(msg:String) {
        Log.d("B2W", msg)
    }

    fun error(msg:String) {
        Log.e("B2W", msg)
    }
}
