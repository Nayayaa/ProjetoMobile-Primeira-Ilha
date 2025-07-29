package com.example.projeto_ilha_primeira

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Perguntas5 : AppCompatActivity() {

    private lateinit var radioGroupPossuiConjuge: RadioGroup
    private lateinit var containerPerguntasConjugeAdicionais: LinearLayout
    // A linha abaixo foi removida:
    // private lateinit var textRetornarInicioP5: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas5) //

        radioGroupPossuiConjuge = findViewById(R.id.radioGroupPossuiConjuge)
        containerPerguntasConjugeAdicionais = findViewById(R.id.containerPerguntasConjugeAdicionais)
        // A linha abaixo foi removida:
        // textRetornarInicioP5 = findViewById(R.id.textRetornarInicioP5)


        radioGroupPossuiConjuge.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioPossuiConjugeSim) {
                containerPerguntasConjugeAdicionais.visibility = View.VISIBLE
            } else if (checkedId == R.id.radioPossuiConjugeNao) {
                containerPerguntasConjugeAdicionais.visibility = View.GONE
            }
        }

        val nextButton = findViewById<Button>(R.id.btnNext) //
        nextButton.setOnClickListener {
            val intent = Intent(this, Perguntas6::class.java) //
            startActivity(intent) //
        }

        val backButton = findViewById<Button>(R.id.btnPrevious) //
        backButton.setOnClickListener {
            val intent = Intent(this, Perguntas4::class.java) //
            startActivity(intent) //
            finish()
        }

        // O listener para textRetornarInicioP5 foi removido daqui.

        if (radioGroupPossuiConjuge.checkedRadioButtonId != R.id.radioPossuiConjugeSim) {
            containerPerguntasConjugeAdicionais.visibility = View.GONE
        }
    }
}