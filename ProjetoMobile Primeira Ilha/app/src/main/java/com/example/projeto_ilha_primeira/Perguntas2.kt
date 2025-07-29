package com.example.projeto_ilha_primeira

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children

class Perguntas2 : AppCompatActivity() {

    private lateinit var spinnerMoradores: Spinner
    private lateinit var containerPerguntasAdicionais: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas2)

        spinnerMoradores = findViewById(R.id.spinnerMoradores)
        containerPerguntasAdicionais = findViewById(R.id.containerPerguntasAdicionais)

        val nextButton = findViewById<Button>(R.id.btnNext)
        val backButton = findViewById<Button>(R.id.btnPrevious)

        // Crie um ArrayAdapter para o Spinner com os números de 1 a 7
        val numeros = Array(7) { i -> (i + 1).toString() }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, numeros)
        spinnerMoradores.adapter = adapter

        // Defina o listener para o Spinner
        spinnerMoradores.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val numeroSelecionado = parent?.getItemAtPosition(position).toString().toInt()
                atualizarVisibilidadePerguntas(numeroSelecionado)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Não precisa fazer nada quando nada é selecionado
            }
        }

        nextButton.setOnClickListener {
            val numeroPessoas = spinnerMoradores.selectedItem.toString()
            val intent = Intent(this, Perguntas3::class.java)
            intent.putExtra("numero_pessoas", numeroPessoas)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, Perguntas1::class.java)
            startActivity(intent)
            finish()
        }

        // Inicialmente, as outras perguntas devem estar ocultas
        containerPerguntasAdicionais.visibility = View.GONE
    }

    private fun atualizarVisibilidadePerguntas(numeroPessoas: Int) {
        // Se o número de pessoas for maior que 1, torna as outras perguntas visíveis
        containerPerguntasAdicionais.visibility = if (numeroPessoas > 1) View.VISIBLE else View.GONE
    }
}