package com.example.projeto_ilha_primeira

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val errorMessage = findViewById<TextView>(R.id.errorMessage)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                errorMessage.text = "Por favor, preencha todos os campos."
                errorMessage.visibility = TextView.VISIBLE
            } else if (!isValidLogin(email, password)) {
                errorMessage.text = "Email ou senha incorretos!"
                errorMessage.visibility = TextView.VISIBLE
            } else {
                errorMessage.visibility = TextView.GONE
                val intent = Intent(this, Telainicial::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun isValidLogin(email: String, password: String): Boolean {
        val sharedPref = getSharedPreferences("usuarios", Context.MODE_PRIVATE)

        if (!sharedPref.contains(email)) {
            return false
        }

        val savedData = sharedPref.getString(email, null) ?: return false

        // Separar os dados no formato "nome|senha"
        val parts = savedData.split("|")
        if (parts.size != 2) return false

        val savedPassword = parts[1]

        return password == savedPassword
    }
}
