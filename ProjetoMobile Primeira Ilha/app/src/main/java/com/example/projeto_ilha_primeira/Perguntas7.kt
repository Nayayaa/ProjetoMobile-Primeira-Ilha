package com.example.projeto_ilha_primeira

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Perguntas7 : AppCompatActivity() {

    private lateinit var radioGroupPossuiConjuge: RadioGroup
    private lateinit var containerPerguntasConjugeAdicionais: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas7)

        radioGroupPossuiConjuge = findViewById(R.id.radioGroupPossuiConjuge)
        containerPerguntasConjugeAdicionais = findViewById(R.id.containerPerguntasConjugeAdicionais)

        radioGroupPossuiConjuge.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.radioPossuiConjugeSim) {
                containerPerguntasConjugeAdicionais.visibility = View.VISIBLE
            } else if (checkedId == R.id.radioPossuiConjugeNao) {
                containerPerguntasConjugeAdicionais.visibility = View.GONE
            }
        }

        val nextButton = findViewById<Button>(R.id.btnNext)
        nextButton.setOnClickListener {
            val intent = Intent(this, Perguntas8::class.java)
            startActivity(intent)
        }

        val backButton = findViewById<Button>(R.id.btnPrevious)
        backButton.setOnClickListener {
            val intent = Intent(this, Perguntas6::class.java)
            startActivity(intent)
            finish()
        }

        if (radioGroupPossuiConjuge.checkedRadioButtonId != R.id.radioPossuiConjugeSim) {
            containerPerguntasConjugeAdicionais.visibility = View.GONE
        }
    }
}
