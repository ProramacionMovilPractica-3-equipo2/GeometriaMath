package com.moviles.geometriamath.ui.hexagono

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moviles.geometriamath.databinding.ActivityPerimetroHexagonoBinding
import com.moviles.geometriamath.ui.main.MainActivity

class PerimetroHexagonoActivity : AppCompatActivity() {

	private lateinit var perimetroHexagonoBinding: ActivityPerimetroHexagonoBinding
	private lateinit var perimetroHexagonoViewModel: PerimetroHexagonoViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		perimetroHexagonoBinding = ActivityPerimetroHexagonoBinding.inflate(layoutInflater)
		perimetroHexagonoViewModel = ViewModelProvider(this)[PerimetroHexagonoViewModel::class.java]
		val view = perimetroHexagonoBinding.root
		setContentView(view)

		perimetroHexagonoBinding.rbIrregular.setOnClickListener {
			mostrar()
			limpiar()
		}
		perimetroHexagonoBinding.rbRegular.setOnClickListener {
			ocultar()
			limpiar()
		}

		val salida = Observer<String>{salida->
			perimetroHexagonoBinding.tvResultado.text = salida
		}
		perimetroHexagonoViewModel.resultado.observe(this,salida)

		val mensaje = Observer<String>{msg->
			Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT).show()
		}
		perimetroHexagonoViewModel.msg.observe(this,mensaje)

		perimetroHexagonoBinding.btnCalcular.setOnClickListener {
			val rb1 = perimetroHexagonoBinding.rbRegular.isChecked
			val l1 = perimetroHexagonoBinding.edtL1.text.toString()
			val l2 = perimetroHexagonoBinding.edtL2.text.toString()
			val l3 = perimetroHexagonoBinding.edtL3.text.toString()
			val l4 = perimetroHexagonoBinding.edtL4.text.toString()
			val l5 = perimetroHexagonoBinding.edtL5.text.toString()
			val l6 = perimetroHexagonoBinding.edtL6.text.toString()
			perimetroHexagonoViewModel.calcular(rb1,l1,l2,l3,l4,l5,l6)
		}

		perimetroHexagonoBinding.btnHome.setOnClickListener {
			val intent = Intent(this@PerimetroHexagonoActivity, MainActivity::class.java)
			startActivity(intent)
		}

	}
	private fun limpiar() {
		perimetroHexagonoBinding.edtL1.setText("")
		perimetroHexagonoBinding.edtL2.setText("")
		perimetroHexagonoBinding.edtL3.setText("")
		perimetroHexagonoBinding.edtL4.setText("")
		perimetroHexagonoBinding.edtL5.setText("")
		perimetroHexagonoBinding.edtL6.setText("")
		perimetroHexagonoBinding.tvResultado.text = ""
	}
	private fun mostrar() {
		perimetroHexagonoBinding.tilL2.visibility = View.VISIBLE
		perimetroHexagonoBinding.tilL3.visibility = View.VISIBLE
		perimetroHexagonoBinding.tilL4.visibility = View.VISIBLE
		perimetroHexagonoBinding.tilL5.visibility = View.VISIBLE
		perimetroHexagonoBinding.tilL6.visibility = View.VISIBLE
	}
	private fun ocultar() {
		perimetroHexagonoBinding.tilL2.visibility = View.GONE
		perimetroHexagonoBinding.tilL3.visibility = View.GONE
		perimetroHexagonoBinding.tilL4.visibility = View.GONE
		perimetroHexagonoBinding.tilL5.visibility = View.GONE
		perimetroHexagonoBinding.tilL6.visibility = View.GONE
	}
}
//Perimetro hexagono terminado
