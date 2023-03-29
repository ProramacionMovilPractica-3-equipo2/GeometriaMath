package com.moviles.geometriamath.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.moviles.geometriamath.databinding.ActivityAreaPentagonoBinding
import androidx.lifecycle.Observer

class PentagonAreaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAreaPentagonoBinding
    private lateinit var model: PentagonAreaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAreaPentagonoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = ViewModelProvider(this)[PentagonAreaViewModel::class.java]

        binding.operateButton.setOnClickListener {
            val sideA = binding.LadoAEditText.text.toString()
            val sideB = binding.LadoBEditText.text.toString()
            val sideC = binding.LadoCEditText.text.toString()
            val sideD = binding.LadoDEditText.text.toString()
            val sideE = binding.LadoEEditText.text.toString()
            val apothem = binding.ApothemEditText.text.toString()

            model.calculateAreaPentagon(sideA,sideB,sideC, sideD, sideE,apothem)
        }

        val  errorObserver= Observer<String>{ error->
            Toast.makeText(this,error , Toast.LENGTH_SHORT).show()
        }
        model.errorMessage.observe(this, errorObserver)


        val  calculateAreaObserver= Observer<String>{ area ->
            binding.areaTextView.text= area
        }
        model.pentagonArea.observe(this, calculateAreaObserver)

    }
}