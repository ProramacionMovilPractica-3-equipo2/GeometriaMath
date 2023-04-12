package com.moviles.geometriamath.ui.rectangulo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AreaRectanguloViewModel : ViewModel() {

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    val resultado: MutableLiveData<Float> by lazy{
        MutableLiveData<Float>()
    }

    fun calcularArea(ladoA: String, ladoB: String) {
        val valorLado1 = ladoA.toFloatOrNull()
        val valorLado2 = ladoB.toFloatOrNull()
        if (valorLado1 == null || valorLado2 == null || valorLado1 == 0f || valorLado2 == 0f ) {
            _error.value = "Los valores ingresados no son válidos."
            return
        }
        resultado.value = valorLado1*valorLado2
    }
}