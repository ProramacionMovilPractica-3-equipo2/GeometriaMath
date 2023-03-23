package com.moviles.geometriamath.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.moviles.geometriamath.R
import com.moviles.geometriamath.databinding.ActivityPerimetroPentagonoBinding
import java.util.*
import kotlin.concurrent.timerTask

class PerimetroPentagonoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerimetroPentagonoBinding
    private lateinit var model: PerimetroPentagonoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerimetroPentagonoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = ViewModelProvider(this)[PerimetroPentagonoViewModel::class.java]
        val timer = Timer()
        var textView: TextView

        with(binding){
            setTextViewsIds_toModel()

            operateButton.setOnClickListener{
                setDefaultColorToTextViews()
                val sideA = inputSideAEditText.text.toString()
                val sideB = inputSideBEditText.text.toString()
                val sideC = inputSideCEditText.text.toString()
                val sideD = inputSideDEditText.text.toString()
                val sideE = inputSideEEditText.text.toString()

                model.perimeterPentagon(sideA, sideB,sideC, sideD, sideE)
            }

            model.errorLiveData.observe(this@PerimetroPentagonoActivity){
                error->
                Toast.makeText(this@PerimetroPentagonoActivity, error, Toast.LENGTH_SHORT).show()
                textView = findViewById(model.getCurrentTextViewWithError())
                textView.setTextColor(ContextCompat.getColor(this@PerimetroPentagonoActivity, R.color.error))

                timer.schedule(timerTask {
                        textView.setTextColor(ContextCompat.getColor(this@PerimetroPentagonoActivity, R.color.ic_launcher_background)) }
                    ,1500)
            }

            model.resultLiveData.observe(this@PerimetroPentagonoActivity){
                result-> resultTextView.text = result.toString()
            }
        }
    }

    private fun ActivityPerimetroPentagonoBinding.setDefaultColorToTextViews() {
        sideATextView.setTextColor(ContextCompat.getColor(this@PerimetroPentagonoActivity, R.color.ic_launcher_background))
        sideBTextView.setTextColor(ContextCompat.getColor(this@PerimetroPentagonoActivity, R.color.ic_launcher_background))
        sideCTextView.setTextColor(ContextCompat.getColor(this@PerimetroPentagonoActivity, R.color.ic_launcher_background))
        sideDTextView.setTextColor(ContextCompat.getColor(this@PerimetroPentagonoActivity, R.color.ic_launcher_background))
        sideETextView.setTextColor(ContextCompat.getColor(this@PerimetroPentagonoActivity, R.color.ic_launcher_background))
    }

    private fun ActivityPerimetroPentagonoBinding.setTextViewsIds_toModel() {
        val arrayOfTextViewsIds =
            arrayOf(
                sideATextView.id,
                sideBTextView.id,
                sideCTextView.id,
                sideDTextView.id,
                sideETextView.id)
        model.setTextViewsIds(arrayOfTextViewsIds)
    }
}