package com.example.projeto_ilha_primeira

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Perguntas4 : AppCompatActivity() {

    private lateinit var radioGroupRegistroNascimento: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas4)

        radioGroupRegistroNascimento = findViewById(R.id.radioGroupRegistroNascimento)

        val nextButton = findViewById<Button>(R.id.btnNext)
        nextButton.setOnClickListener {

            // coleta de dados:
            // val selectedId = radioGroupRegistroNascimento.checkedRadioButtonId
            // if (selectedId != -1) {
            //    val radioButton = findViewById<RadioButton>(selectedId)
            //    val resposta = radioButton.text.toString()
            //    Toast.makeText(this, "Registro: $resposta", Toast.LENGTH_SHORT).show()
            // } else {
            //    Toast.makeText(this, "Por favor, selecione uma opção.", Toast.LENGTH_SHORT).show()
            //    return@setOnClickListener // Impede de prosseguir sem seleção
            // }

            val intent = Intent(this, Perguntas5::class.java) // Ou a próxima tela designada
            startActivity(intent)
        }

        val backButton = findViewById<Button>(R.id.btnPrevious)
        backButton.setOnClickListener {
            val intent = Intent(this, Perguntas3::class.java)
            startActivity(intent)
            finish()
        }

// botão para voltar pra main.activty
//        textRetornarInicioP4.setOnClickListener {
//            // A MainActivity é geralmente a tela de entrada do app.
//            // Se Telainicial for o início do formulário, pode ser mais apropriado.
//            val intent = Intent(this, MainActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK // Limpa a pilha de activities
//            startActivity(intent)
//            finish()
//        }
    }
}