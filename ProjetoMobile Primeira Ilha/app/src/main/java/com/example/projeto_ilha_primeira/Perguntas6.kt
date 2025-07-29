package com.example.projeto_ilha_primeira

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Perguntas6 : AppCompatActivity() {

    private lateinit var radioGroupTrabalhou: RadioGroup
    private lateinit var radioGroupQuantosTrabalhos: RadioGroup
    private lateinit var btnProximo: Button
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas6)

        radioGroupTrabalhou = findViewById(R.id.radioGroupTrabalhou)
        radioGroupQuantosTrabalhos = findViewById(R.id.radioGroupQuantosTrabalhos)
        btnProximo = findViewById(R.id.btnNext)
        btnVoltar = findViewById(R.id.btnPrevious) // ID do botão Voltar no seu XML é btnPrevious

        btnProximo.setOnClickListener {
            val selectedIdTrabalhou = radioGroupTrabalhou.checkedRadioButtonId
            val selectedIdQuantosTrabalhos = radioGroupQuantosTrabalhos.checkedRadioButtonId

            if (selectedIdTrabalhou != -1 && selectedIdQuantosTrabalhos != -1) {
                // Opcional: Coletar e mostrar as respostas
                val respostaTrabalhou = findViewById<RadioButton>(selectedIdTrabalhou).text.toString()
                val respostaQuantosTrabalhos = findViewById<RadioButton>(selectedIdQuantosTrabalhos).text.toString()

                val intent = Intent(this, Perguntas7::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Selecione uma opção", Toast.LENGTH_SHORT).show()
            }
        }

        btnVoltar.setOnClickListener {
            val intent = Intent(this, Perguntas5::class.java)
            startActivity(intent)
            finish()
        }
    }
}