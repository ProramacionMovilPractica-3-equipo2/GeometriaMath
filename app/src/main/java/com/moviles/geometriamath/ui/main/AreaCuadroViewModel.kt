package com.moviles.geometriamath.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AreaCuadroViewModel: ViewModel() {

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    val resultado: MutableLiveData<Float> by lazy{
        MutableLiveData<Float>()
    }


    fun calcularArea(lado: String) {
        if (lado.isEmpty()) {
            _error.value = "Los campos no pueden estar vacíos."
            return
        }

        else {
            val valorLado = lado.toFloatOrNull()

            if (valorLado == null || valorLado == 0f) {
                _error.value = "Los valores ingresados no son válidos."
                return
            } else {
                resultado.value = valorLado * valorLado
            }
        }
    }

}