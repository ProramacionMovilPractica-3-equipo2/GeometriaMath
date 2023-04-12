package com.moviles.geometriamath.ui.rectangulo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.moviles.geometriamath.databinding.ActivityPerimetroRectanguloBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moviles.geometriamath.R
import com.moviles.geometriamath.ui.main.MainActivity

class PerimetroRectanguloActivity : AppCompatActivity() {
    private lateinit var perimetroRectangulobinding:ActivityPerimetroRectanguloBinding
    private lateinit var perimetroRectanguloViewModel: PerimetroRectanguloViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        perimetroRectangulobinding = ActivityPerimetroRectanguloBinding.inflate(layoutInflater)
        perimetroRectanguloViewModel = ViewModelProvider(this)[PerimetroRectanguloViewModel::class.java]

        //Configuracion del LiveData
        val resultadoObserver = Observer<Float>{resultado ->
            perimetroRectangulobinding.resultadoTextView.text = buildString {
                append(getString(R.string.res_per_rec))
                append(resultado)
            }
        }
        val errorObserver = Observer<String>{error ->
            perimetroRectangulobinding.resultadoTextView.text = error
        }

        perimetroRectanguloViewModel.resultado.observe(this, resultadoObserver)
        perimetroRectanguloViewModel.error.observe(this, errorObserver)

        setContentView(perimetroRectangulobinding.root)

        //Boton para regresar al menu
        perimetroRectangulobinding.menuPpalButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //Ejecucion del calculo
        perimetroRectangulobinding.btnCalcular.setOnClickListener {
            perimetroRectanguloViewModel.calcularPerimetro(
                perimetroRectangulobinding.ladoAEditText.text.toString(),
                perimetroRectangulobinding.ladoBEditText.text.toString()
            )
        }

    }
}