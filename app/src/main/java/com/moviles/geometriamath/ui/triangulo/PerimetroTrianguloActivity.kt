package com.moviles.geometriamath.ui.triangulo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moviles.geometriamath.R
import com.moviles.geometriamath.databinding.ActivityPerimetroTrianguloBinding
import com.moviles.geometriamath.ui.main.MainActivity

class PerimetroTrianguloActivity : AppCompatActivity() {

    private lateinit var perimetroTrianguloBinding: ActivityPerimetroTrianguloBinding
    private lateinit var perimetroTrianguloViewModel: PerimetroTrianguloViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        perimetroTrianguloBinding = ActivityPerimetroTrianguloBinding.inflate(layoutInflater)
        perimetroTrianguloViewModel = ViewModelProvider(this)[PerimetroTrianguloViewModel::class.java]

        //Configuracion del LiveData
        val resultadoObserver = Observer<Float>{resultado ->
            perimetroTrianguloBinding.tvResultado.text = buildString {
        append(getString(R.string.perimetroDaniel))
        append(resultado)
    }
        }
        val errorObserver = Observer<String>{error ->
            perimetroTrianguloBinding.tvResultado.text = error
        }

        perimetroTrianguloViewModel.resultado.observe(this, resultadoObserver)
        perimetroTrianguloViewModel.error.observe(this, errorObserver)

        setContentView(perimetroTrianguloBinding.root)

        //Boton para regresar al menu
        perimetroTrianguloBinding.menuPpalButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Ejecucion del calculo
        perimetroTrianguloBinding.btnCalcular.setOnClickListener {
            perimetroTrianguloViewModel.calcularPerimetro(
                perimetroTrianguloBinding.etLado1.text.toString(),
                perimetroTrianguloBinding.etLado2.text.toString(),
                perimetroTrianguloBinding.etLado3.text.toString()
            )
        }
    }
}