package com.moviles.geometriamath.ui.triangulo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moviles.geometriamath.R
import com.moviles.geometriamath.databinding.ActivityAreaTrianguloBinding
import com.moviles.geometriamath.ui.main.MainActivity


class AreaTrianguloActivity : AppCompatActivity() {
    private lateinit var areaTrianguloBinding: ActivityAreaTrianguloBinding
    private lateinit var areaTrianguloViewModel: AreaTrianguloViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        areaTrianguloBinding = ActivityAreaTrianguloBinding.inflate(layoutInflater)
        areaTrianguloViewModel = ViewModelProvider(this)[AreaTrianguloViewModel::class.java]

        //Configuracion del LiveData
        val areaObserver = Observer<Float>{area ->
            areaTrianguloBinding.tvArea.text = buildString {
                append(getString(R.string.Area_Triangulo))
                append(area)
            }
        }
        val errorObserver = Observer<String> { error ->
            areaTrianguloBinding.tvArea.text = error
        }

        areaTrianguloViewModel.area.observe(this, areaObserver)
        areaTrianguloViewModel.errorMsg.observe(this, errorObserver)

        setContentView(areaTrianguloBinding.root)

        //Boton para regresar al menu
        areaTrianguloBinding.menuPpalButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Ejecucion del calculo
        areaTrianguloBinding.botonCalcular.setOnClickListener {
            areaTrianguloViewModel.calcularArea(
                areaTrianguloBinding.base.text.toString(),
                areaTrianguloBinding.altura.text.toString()
            )
        }
    }
}
