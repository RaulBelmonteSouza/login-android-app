package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        firebaseAuth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.cadastrar_btn)
        val btn_login = findViewById<Button>(R.id.button2)

        var email = findViewById<EditText>(R.id.editTextTextPersonName)
        var senha = findViewById<EditText>(R.id.editTextTextPersonName2)


        btn.setOnClickListener() {
            startActivity(Intent(this, Cadastro::class.java));
        }

        btn_login.setOnClickListener() {
            if(email.text.isEmpty()) {
                Toast.makeText(this, "Email vazio", Toast.LENGTH_SHORT).show()
            } else if(senha.text.isBlank()) {
                Toast.makeText(this, "Senha não pode ser nula", Toast.LENGTH_LONG).show()
            } else {
                firebaseAuth.signInWithEmailAndPassword(email.text.toString(), senha.text.toString())
                    .addOnCompleteListener() {
                        if (it.isSuccessful) {
                            startActivity(Intent(this, Logged::class.java))
                            Toast.makeText(this, "Logged", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

    }
}