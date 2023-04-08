package com.moviles.geometriamath.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moviles.geometriamath.R

class PerimetroPentagonoViewModel: ViewModel() {
    private lateinit var _arrayOfTextViewIds: Array<Int>
    private var currentTextViewError: Int = 0

    private val errorMutableLiveData: MutableLiveData<Int> = MutableLiveData()
    val errorLiveData: LiveData<Int> = errorMutableLiveData
    private val resultMutableLiveData: MutableLiveData<Float> = MutableLiveData()
    val resultLiveData: LiveData<Float> = resultMutableLiveData

    fun setTextViewsIds(arrayOfTextViewIds: Array<Int>){
        _arrayOfTextViewIds = arrayOfTextViewIds
    }
    
    fun getCurrentTextViewWithError(): Int{
        return _arrayOfTextViewIds[currentTextViewError]
    }

    fun perimeterPentagon(
        sideA: String,
        sideB: String,
        sideC: String,
        sideD: String,
        sideE: String
    ){
        if(sideA.isEmpty()){
            currentTextViewError = 0
            errorMutableLiveData.value = R.string.pPentagono_error_sideA_empty
        }else if (sideB.isEmpty()){
            currentTextViewError = 1
            errorMutableLiveData.value = R.string.pPentagono_error_sideB_empty
        }else if (sideC.isEmpty()){
            currentTextViewError = 2
            errorMutableLiveData.value = R.string.pPentagono_error_sideC_empty
        }else if (sideD.isEmpty()){
            currentTextViewError = 3
            errorMutableLiveData.value = R.string.pPentagono_error_sideD_empty
        }else if (sideE.isEmpty()){
            currentTextViewError = 4
            errorMutableLiveData.value = R.string.pPentagono_error_sideE_empty
        }
        else{
            resultMutableLiveData.value= sideA.toFloat() + sideB.toFloat() + sideC.toFloat() + sideD.toFloat() + sideE.toFloat()
        }
    }
}