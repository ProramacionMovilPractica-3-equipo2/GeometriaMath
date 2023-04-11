package com.moviles.geometriamath.ui.main

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class AreaTrianguloViewModel : ViewModel() {
    private val _errorMsg = MutableLiveData<String>()
    val errorMsg : LiveData<String> = _errorMsg

    val area : MutableLiveData<Float> by lazy {
        MutableLiveData<Float>()
    }


    fun calcularArea(base: String, altura: String){
        if (base.isEmpty() || altura.isEmpty()){
            _errorMsg.value = "Los campos no pueden estar vacios"
            return
        }

        val valorBase = base.toFloatOrNull()
        val valorAltura = altura.toFloatOrNull()

        if (valorBase == null || valorAltura == null || valorBase == 0F || valorAltura == 0F){
            _errorMsg.value = "Los valores ingresados no son validos"
            return
        }

        area.value = (valorBase * valorAltura)/2
    }
}