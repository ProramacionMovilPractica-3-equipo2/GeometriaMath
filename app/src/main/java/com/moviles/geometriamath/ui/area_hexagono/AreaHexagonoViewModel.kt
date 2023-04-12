package com.moviles.geometriamath.ui.area_hexagono


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt
import kotlin.math.roundToLong


class AreaHexagonoViewModel : ViewModel() {

    val resultado: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val msg : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun calcularArea(rb1:Boolean,l1:String,l2:String,l3:String,l4:String,l5:String,l6:String,h1:String,h2:String,h3:String,h4:String,h5:String,h6:String) {

        if (rb1==true){
            if (l1.isEmpty() || l1 =="."){
                msg.value = "Error. Colocar el valor del Lado"
            }else if(l1.toDouble() > 0){
                resultado.value = (((3 * kotlin.math.sqrt(3.0) * l1.toDouble() * l1.toDouble() / 2)*1000.0).roundToInt()/1000.0).toString() + " cm2"
            } else
                msg.value = "Error. Ingresar un número positivo"
        }else {
            if (l1.isEmpty()||l2.isEmpty()||l3.isEmpty()||l4.isEmpty()||l5.isEmpty()||l6.isEmpty()||h1.isEmpty()||h2.isEmpty()||h3.isEmpty()||h4.isEmpty()||h5.isEmpty()||h6.isEmpty()){
                msg.value = "Rellenar campos vacíos"

            } else{
                val date = arrayOf<String>(l1,l2,l3,l4,l5,l6,h1,h2,h3,h4,h5,h6)
                var bandError= true
                for(i in date.indices){
                    if(date[i] =="." || date[i] == "0"){
                        bandError = false
                    }
                    else true
                }
                if(bandError) {
                    resultado.value =
                        (((l1.toDouble() * h1.toDouble()) / 2) + ((l2.toDouble() * h2.toDouble()) / 2) + ((l3.toDouble() * h3.toDouble()) / 2)
                                + ((l4.toDouble() * h4.toDouble()) / 2) + ((l5.toDouble() * h5.toDouble()) / 2) + ((l6.toDouble() * h6.toDouble()) / 2)).toString() + " cm2"

                }
                else msg.value = "Error. Ingresar números positivos"
//
            }
        }
    }
}
