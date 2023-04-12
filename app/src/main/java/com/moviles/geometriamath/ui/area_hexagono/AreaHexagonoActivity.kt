package com.moviles.geometriamath.ui.area_hexagono

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moviles.geometriamath.databinding.ActivityAreaHexagonoBinding
import com.moviles.geometriamath.ui.main.MainActivity

class AreaHexagonoActivity : AppCompatActivity() {

    private lateinit var areaHexagonoBinding: ActivityAreaHexagonoBinding
    private lateinit var areaHexagonoViewModel: AreaHexagonoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        areaHexagonoBinding = ActivityAreaHexagonoBinding.inflate(layoutInflater)
        areaHexagonoViewModel = ViewModelProvider(this)[AreaHexagonoViewModel::class.java]
        val view = areaHexagonoBinding.root
        setContentView(view)

        if(areaHexagonoBinding.rbRegular.isChecked()){
            ocultar()

        }

        areaHexagonoBinding.rbIrregular.setOnClickListener {
            mostrar()
            limpiar()
        }
       areaHexagonoBinding.rbRegular.setOnClickListener {
            ocultar()
            limpiar()
        }


        val salida = Observer<String> { salida ->
            areaHexagonoBinding.tvAhResult.text = salida
        }
        areaHexagonoViewModel.resultado.observe(this, salida)

        val mensaje = Observer<String> { msg ->
            Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
        }
        areaHexagonoViewModel.msg.observe(this, mensaje)

        areaHexagonoBinding.btnCalcular.setOnClickListener {
            val rb1 = areaHexagonoBinding.rbRegular.isChecked()
            val l1 = areaHexagonoBinding.edtL1.text.toString()
            val l2 = areaHexagonoBinding.edtL2.text.toString()
            val l3 = areaHexagonoBinding.edtL3.text.toString()
            val l4 = areaHexagonoBinding.edtL4.text.toString()
            val l5 = areaHexagonoBinding.edtL5.text.toString()
            val l6 = areaHexagonoBinding.edtL6.text.toString()
            val h1 = areaHexagonoBinding.edtA1.text.toString()
            val h2 = areaHexagonoBinding.edtA2.text.toString()
            val h3 = areaHexagonoBinding.edtA3.text.toString()
            val h4 = areaHexagonoBinding.edtA4.text.toString()
            val h5 = areaHexagonoBinding.edtA5.text.toString()
            val h6 = areaHexagonoBinding.edtA6.text.toString()
            areaHexagonoViewModel.calcularArea(rb1, l1, l2, l3, l4, l5, l6, h1, h2, h3, h4, h5, h6)
        }

        areaHexagonoBinding.btnHome.setOnClickListener{
            val intent = Intent(this@AreaHexagonoActivity, MainActivity::class.java)
            startActivity(intent)
        }


    }


    private fun limpiar() {
        areaHexagonoBinding.edtL1.setText("")
        areaHexagonoBinding.edtL2.setText("")
        areaHexagonoBinding.edtL3.setText("")
        areaHexagonoBinding.edtL4.setText("")
        areaHexagonoBinding.edtL5.setText("")
        areaHexagonoBinding.edtL6.setText("")

        areaHexagonoBinding.edtA1.setText("")
        areaHexagonoBinding.edtA2.setText("")
        areaHexagonoBinding.edtA3.setText("")
        areaHexagonoBinding.edtA4.setText("")
        areaHexagonoBinding.edtA5.setText("")
        areaHexagonoBinding.edtA6.setText("")
        areaHexagonoBinding.tvAhResult.text = ""
    }


    private fun mostrar() {

        areaHexagonoBinding.tilL2.visibility = View.VISIBLE
        areaHexagonoBinding.tilL3.visibility = View.VISIBLE
        areaHexagonoBinding.tilL4.visibility = View.VISIBLE
        areaHexagonoBinding.tilL5.visibility = View.VISIBLE
        areaHexagonoBinding.tilL6.visibility = View.VISIBLE

        areaHexagonoBinding.tilA1.visibility = View.VISIBLE
        areaHexagonoBinding.tilA2.visibility = View.VISIBLE
        areaHexagonoBinding.tilA3.visibility = View.VISIBLE
        areaHexagonoBinding.tilA4.visibility = View.VISIBLE
        areaHexagonoBinding.tilA5.visibility = View.VISIBLE
        areaHexagonoBinding.tilA6.visibility = View.VISIBLE

    }

    private fun ocultar() {
        areaHexagonoBinding.tilL2.visibility = View.GONE
        areaHexagonoBinding.tilL3.visibility = View.GONE
        areaHexagonoBinding.tilL4.visibility = View.GONE
        areaHexagonoBinding.tilL5.visibility = View.GONE
        areaHexagonoBinding.tilL6.visibility = View.GONE

        areaHexagonoBinding.tilA1.visibility = View.GONE
        areaHexagonoBinding.tilA2.visibility = View.GONE
        areaHexagonoBinding.tilA3.visibility = View.GONE
        areaHexagonoBinding.tilA4.visibility = View.GONE
        areaHexagonoBinding.tilA5.visibility = View.GONE
        areaHexagonoBinding.tilA6.visibility = View.GONE
    }


}


