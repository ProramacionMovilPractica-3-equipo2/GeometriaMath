package com.moviles.geometriamath.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.moviles.geometriamath.R
import com.moviles.geometriamath.databinding.ActivityMainBinding
import com.moviles.geometriamath.ui.cuadrado.AreaCuadroActivity
import com.moviles.geometriamath.ui.hexagono.AreaHexagonoActivity
import com.moviles.geometriamath.ui.rectangulo.PerimetroRectanguloActivity
import com.moviles.geometriamath.ui.hexagono.PerimetroHexagonoActivity
import com.moviles.geometriamath.ui.pentagono.PentagonAreaActivity
import com.moviles.geometriamath.ui.pentagono.PerimetroPentagonoActivity
import com.moviles.geometriamath.ui.rectangulo.AreaRectanguloActivity
import com.moviles.geometriamath.ui.triangulo.AreaTrianguloActivity
import com.moviles.geometriamath.ui.triangulo.PerimetroTrianguloActivity

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
        when(position){
            0 -> startActivity(Intent(this@MainActivity, AreaCuadroActivity::class.java))
            1 -> startActivity(Intent(this@MainActivity, AreaTrianguloActivity::class.java))
            2 -> startActivity(Intent(this@MainActivity, PerimetroTrianguloActivity::class.java))
            3 -> startActivity(Intent(this@MainActivity, AreaRectanguloActivity::class.java))
            4 -> startActivity(Intent(this@MainActivity, PerimetroRectanguloActivity::class.java))
            5 -> startActivity(Intent(this@MainActivity, PentagonAreaActivity::class.java))
            6 -> startActivity(Intent(this@MainActivity, PerimetroPentagonoActivity::class.java))
            7 -> startActivity(Intent(this@MainActivity, AreaHexagonoActivity::class.java))
            8 -> startActivity(Intent(this@MainActivity, PerimetroHexagonoActivity::class.java))
        }
    }
}
