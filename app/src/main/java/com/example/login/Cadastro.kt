package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.auth.FirebaseAuth

class Cadastro : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        firebaseAuth = FirebaseAuth.getInstance();

        var email = findViewById<EditText>(R.id.email)
        var senha = findViewById<EditText>(R.id.senha)
        var confSenha = findViewById<EditText>(R.id.senhaConf)
        var cadastrar = findViewById<Button>(R.id.buttonvai)

        cadastrar.setOnClickListener() {
            if(email.text.isEmpty()) {
                Toast.makeText(this, "Email vazio", Toast.LENGTH_SHORT).show()
            } else if(senha.text.isBlank()) {
                Toast.makeText(this, "Senha não pode ser nula", Toast.LENGTH_LONG).show()
            } else if(confSenha.text.toString() != senha.text.toString()) {
                Toast.makeText(this, "Senha diferente", Toast.LENGTH_LONG).show()
            } else {
                firebaseAuth.createUserWithEmailAndPassword(email.text.toString(), senha.text.toString())
                    .addOnCompleteListener() {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Cadastrado", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}