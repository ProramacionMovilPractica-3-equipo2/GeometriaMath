package com.moviles.geometriamath.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.moviles.geometriamath.R
import com.moviles.geometriamath.databinding.ActivityPerimetroTrianguloBinding

class PerimetroTrianguloActivity : AppCompatActivity() {

    private lateinit var perimetroTrianguloBinding: ActivityPerimetroTrianguloBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        perimetroTrianguloBinding = ActivityPerimetroTrianguloBinding.inflate(layoutInflater)

        setContentView(perimetroTrianguloBinding.root)

        perimetroTrianguloBinding.menuPpalButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}