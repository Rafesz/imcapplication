package com.example.imcapplication

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*
import kotlin.math.roundToInt

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        exibeResultado()
        voltarTelaInicial()
        copiaLinkGit()
    }

    private fun exibeResultado(){
        val imc = intent.getFloatExtra("IMC", 1.0F)
        val textoResultado = "O seu imc é: \n\n${imc.roundToInt()}"

        finalResult.text = textoResultado
    }

    private fun voltarTelaInicial(){
        val voltar = buttonVoltar

        voltar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun copiaLinkGit(){
        imageGitHub.setOnClickListener {
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", "https://github.com/Rafesz")
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "Link copiado!", Toast.LENGTH_LONG).show()
        }
    }
}