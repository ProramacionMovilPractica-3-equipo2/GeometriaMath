package com.moviles.geometriamath.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.moviles.geometriamath.R
import com.moviles.geometriamath.databinding.ActivityMainBinding
import com.moviles.geometriamath.ui.perimetro_hexagono.PerimetroHexagonoActivity

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root

        setContentView(view)

        val activities = resources.getStringArray(R.array.actividades)
        val adapter = ArrayAdapter(this,R.layout.list_activities,activities)
        with(mainBinding.autoCompleteTextView2){
            setAdapter(adapter)
            onItemClickListener = this@MainActivity
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this@MainActivity, item+" "+position, Toast.LENGTH_SHORT).show()
//        when(position){
//            0 -> TODO("areaCírculo")
//            1 -> TODO("Perímetro Círculo")
//            2 -> TODO("Área Cuadro")
//            3 -> TODO("Perímetro Cuadro")
//            4 -> TODO("Área Triángulo")
//            5 -> TODO("Perímetro Triángulo")
//            6 -> TODO("Área Rectángulo")
//            7 -> TODO("Perímetro Rectángulo")
//            8 -> TODO("Área de un Pentágono")
//            9 -> TODO("Perímetro de un Pentágono")
//            10 -> TODO("Área de un Hexágono")
//            11 -> TODO("Perímetro de un Hexágono")
//        }
        when(position){
            5 -> startActivity(Intent(this@MainActivity, PerimetroTrianguloActivity::class.java))
            8 -> startActivity(Intent(this@MainActivity, PentagonAreaActivity::class.java))
            9 -> startActivity(Intent(this@MainActivity, PerimetroPentagonoActivity::class.java))
            11 -> startActivity(Intent(this@MainActivity, PerimetroHexagonoActivity::class.java))
        }
    }
}
