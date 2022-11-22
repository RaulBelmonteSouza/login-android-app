package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class Logged : AppCompatActivity() {

    lateinit var fireBaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged)
        fireBaseAuth = FirebaseAuth.getInstance()

        val btn = findViewById<Button>(R.id.logout)
        val text = findViewById<TextView>(R.id.nameOnScreen)

        text.text = fireBaseAuth.currentUser?.email.toString()

        var logout = findViewById<Button>(R.id.logout);
        logout.setOnClickListener() {
            fireBaseAuth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}