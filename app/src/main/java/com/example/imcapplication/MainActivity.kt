package com.example.imcapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners(){
        buttonCalc.setOnClickListener {
            calculaImc(inputPeso.text.toString(), inputAltura.text.toString())
        }
    }

    private fun calculaImc(peso:String, altura:String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null){
            val imc = (peso) / (altura * altura)

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("IMC", imc)
            }

            startActivity(intent)
        }
    }
}