package com.moviles.geometriamath.ui.triangulo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PerimetroTrianguloViewModel : ViewModel() {

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    val resultado: MutableLiveData<Float> by lazy{
        MutableLiveData<Float>()
    }

    fun calcularPerimetro(lado1: String, lado2: String, lado3: String) {
        if (lado1.isEmpty() || lado2.isEmpty() || lado3.isEmpty()) {
            _error.value = "Los campos no pueden estar vacíos."
            return
        }

        val valorLado1 = lado1.toFloatOrNull()
        val valorLado2 = lado2.toFloatOrNull()
        val valorLado3 = lado3.toFloatOrNull()

        if (valorLado1 == null || valorLado2 == null || valorLado3 == null || valorLado1 == 0f || valorLado2 == 0f || valorLado3 == 0f) {
            _error.value = "Los valores ingresados no son válidos."
            return
        }

        resultado.value = valorLado1 + valorLado2 + valorLado3
    }
    }