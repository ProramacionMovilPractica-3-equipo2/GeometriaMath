package com.moviles.geometriamath.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moviles.geometriamath.R
import com.moviles.geometriamath.databinding.ActivityAreaCuadroBinding


class AreaCuadroActivity : AppCompatActivity() {
    private lateinit var areaCuadroBinding: ActivityAreaCuadroBinding
    private lateinit var areaCuadroViewModel: AreaCuadroViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        areaCuadroBinding = ActivityAreaCuadroBinding.inflate(layoutInflater)
        areaCuadroViewModel = ViewModelProvider(this)[AreaCuadroViewModel::class.java]

        //Configuracion del LiveData
        val resultadoObserver = Observer<Float>{resultado ->
            areaCuadroBinding.resultadoTextView.text= buildString {
                append(getString(R.string.mensaje_area_cuadro))
                append(" " + resultado)
            }
        }

        val errorObserver = Observer<String>{error ->
            areaCuadroBinding.resultadoTextView.text = error
        }

        areaCuadroViewModel.resultado.observe(this, resultadoObserver)
        areaCuadroViewModel.error.observe(this, errorObserver)

        setContentView(areaCuadroBinding.root)

        //Botón para regresar al menú
        areaCuadroBinding.menuPpalButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Botón para el cálculo
        areaCuadroBinding.btnCalcular.setOnClickListener{
            areaCuadroViewModel.calcularArea(
                areaCuadroBinding.ladoAEditText.text.toString()
            )
        }
    }
}
