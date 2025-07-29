package com.example.projeto_ilha_primeira



import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Perguntas12 : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var btnProximo: Button
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas12)

        radioGroup = findViewById(R.id.radioGroupResposta)
        btnProximo = findViewById(R.id.btnProximo)
        btnVoltar = findViewById(R.id.btnVoltar)

        //comentando para usar no futuro (salvamento das respostas)
//        btnProximo.setOnClickListener {
//            val selectedId = radioGroup.checkedRadioButtonId
//            if (selectedId != -1) {
//                val resposta = findViewById<RadioButton>(selectedId).text.toString()
//                // Aqui você pode salvar ou enviar a resposta
//                Toast.makeText(this, "Resposta: $resposta", Toast.LENGTH_SHORT).show()
//                // startActivity(Intent(this, ProximaActivity::class.java))
//            } else {
//                Toast.makeText(this, "Selecione uma opção.", Toast.LENGTH_SHORT).show()
//            }
//        }

        btnProximo.setOnClickListener {
            val intent = Intent(this, ConclusaoActivity::class.java)
            startActivity(intent)
        }

        btnVoltar.setOnClickListener {
            finish() // ou startActivity(Intent(this, PerguntaAnterior::class.java))
        }

    }
}
