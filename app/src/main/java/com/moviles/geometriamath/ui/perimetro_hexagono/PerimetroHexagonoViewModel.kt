package com.moviles.geometriamath.ui.perimetro_hexagono

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PerimetroHexagonoViewModel : ViewModel()  {

	val resultado : MutableLiveData<String> = MutableLiveData()
	val msg : MutableLiveData<String> = MutableLiveData()

	fun calcular(rb1:Boolean,l1:String,l2:String,l3:String,l4:String,l5:String,l6:String) {

		if (rb1==true){
			if (l1.isEmpty()){
				msg.value = "Rellenar campos vacíos"
			}else{
				resultado.value = (l1.toDouble()*6).toString() + " cm"
			}
		}else {
			if (l1.isEmpty()||l2.isEmpty()||l3.isEmpty()||l4.isEmpty()||l5.isEmpty()||l6.isEmpty()){
				msg.value = "Rellenar campos vacíos"
			}else{
				resultado.value = (l1.toDouble()+l2.toDouble()+l3.toDouble()+l4.toDouble()+l5.toDouble()+l6.toDouble()).toString() + " cm"
			}
		}
	}
}
