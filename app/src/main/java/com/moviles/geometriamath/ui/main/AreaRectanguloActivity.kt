package com.moviles.geometriamath.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moviles.geometriamath.R
import com.moviles.geometriamath.databinding.ActivityAreaRectanguloBinding

class AreaRectanguloActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAreaRectanguloBinding
    private lateinit var model: AreaRectanguloViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAreaRectanguloBinding.inflate(layoutInflater)
        model = ViewModelProvider(this)[AreaRectanguloViewModel::class.java]

        val resultadoObserver = Observer<Float>{resultado ->
            binding.resultadoText.text = buildString {
                append(getString(R.string.rectangulo_area_resultado))
                append(resultado)
            }
        }
        val errorObserver = Observer<String>{error ->
            binding.resultadoText.text  = error
        }
        model.resultado.observe(this,resultadoObserver)
        model.error.observe(this,errorObserver)

        val view = binding.root
        setContentView(view)

        binding.buttonCalcular.setOnClickListener {
            model.calcularArea(
                binding.altura.text.toString(),
                binding.base.text.toString()
            )
        }
    }
}