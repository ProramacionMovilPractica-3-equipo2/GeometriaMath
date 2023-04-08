package com.moviles.geometriamath.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PentagonAreaViewModel : ViewModel() {

    val errorMessage : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val  pentagonArea: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun calculateAreaPentagon(sideA: String, sideB: String,
                              sideC: String, sideD: String,
                              sideE: String, apothem: String) {

        // Verifica si algún campo está en blanco
        if (sideA.isBlank()) {
            errorMessage.value = "El campo Lado A no se llenó"
            return

        }
        if (sideA == "." || sideA == "," ) {
            errorMessage.value = "El campo Lado A tiene ingresado un valor no númerico "
            return
        }
        if (sideB.isBlank()) {
            errorMessage.value = "El campo Lado B no se llenó"
            return
        }
        if (sideB == "." || sideB == "," ) {
            errorMessage.value = "El campo Lado B tiene ingresado unvalor no númerico "
            return
        }

        if (sideC.isBlank()) {
            errorMessage.value = "El campo Lado C no se llenó"
            return
        }
        if (sideC == "." || sideC == "," ) {
            errorMessage.value = "El campo Lado C tiene ingresado un valor no númerico "
            return
        }
        if (sideD.isBlank()) {
            errorMessage.value = "El campo Lado D no se llenó"
            return

        }
        if (sideD == "." || sideD == "," ) {
            errorMessage.value = "El campo Lado D tiene ingresado un valor no númerico "
            return
        }
        if (sideE.isBlank()) {
            errorMessage.value = "El campo Lado E no se llenó"
            return
        }
        if (sideE == "." || sideE == "," ) {
            errorMessage.value = "El campo Lado E tiene ingresado un valor no númerico "
            return
        }
        if (apothem.isBlank()) {
            errorMessage.value = "El campo Apotema no se llenó"
            return
        }
        if (apothem == "." || apothem == "," ) {
            errorMessage.value = "El campo apotema tiene ingresado un valor no númerico "
            return
        }

        try {
            val a = sideA.toDouble()
            val b = sideB.toDouble()
            val c = sideC.toDouble()
            val d = sideD.toDouble()
            val e = sideE.toDouble()
            val ap = apothem.toDouble()

            // Cálculo del área
            val area = 0.5 * (a+b+c+d+e) * ap

            // Mostrar el resultado
            pentagonArea.value= (String.format("%.2f", area))

        } catch (e: NumberFormatException) {
            // Si ocurre una excepción, se muestra un mensaje de error y se limpia el resultado
            pentagonArea.value = ""
            errorMessage.value = "Se ingresaron valores no numericos"
        }
    }
}
