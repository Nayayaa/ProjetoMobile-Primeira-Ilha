package com.example.projeto_ilha_primeira

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Perguntas3 : AppCompatActivity() {

    private lateinit var spinnerComodos: Spinner
    private lateinit var spinnerDormitorios: Spinner
    private lateinit var spinnerBanheirosCompletos: Spinner
    private lateinit var spinnerBanheirosIncompletos: Spinner
    private lateinit var radioGroupInternet: RadioGroup
    private lateinit var radioGroupMaquinaLavar: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas3)

        // Inicializa os componentes da UI
        spinnerComodos = findViewById(R.id.spinnerComodos)
        spinnerDormitorios = findViewById(R.id.spinnerDormitorios)
        spinnerBanheirosCompletos = findViewById(R.id.spinnerBanheirosCompletos)
        spinnerBanheirosIncompletos = findViewById(R.id.spinnerBanheirosIncompletos)
        radioGroupInternet = findViewById(R.id.radioGroupInternet)
        radioGroupMaquinaLavar = findViewById(R.id.radioGroupMaquinaLavar)

        // Configura os Spinners
        setupSpinner(spinnerComodos, arrayOf("Selecione o número:", "1", "2", "3", "4", "5", "6", "7+"))
        setupSpinner(spinnerDormitorios, arrayOf("Selecione o número:", "0", "1", "2", "3", "4", "5+"))
        setupSpinner(spinnerBanheirosCompletos, arrayOf("Selecione o número:", "0", "1", "2", "3+"))
        setupSpinner(spinnerBanheirosIncompletos, arrayOf("Selecione o número:", "0", "1", "2", "3+"))

        // Botões de navegação
        val nextButton = findViewById<Button>(R.id.btnNext)
        nextButton.setOnClickListener {

            // coleta de dados:
            // val comodos = spinnerComodos.selectedItem.toString()
            // val internetId = radioGroupInternet.checkedRadioButtonId
            // val radioButtonInternet = findViewById<RadioButton>(internetId)
            // val temInternet = radioButtonInternet?.text.toString()

            // Toast.makeText(this, "Cômodos: $comodos, Internet: $temInternet", Toast.LENGTH_LONG).show()

            val intent = Intent(this, Perguntas4::class.java)
            startActivity(intent)
        }

        val backButton = findViewById<Button>(R.id.btnPrevious)
        backButton.setOnClickListener {
            val intent = Intent(this, Perguntas2::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setupSpinner(spinner: Spinner, options: Array<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
}