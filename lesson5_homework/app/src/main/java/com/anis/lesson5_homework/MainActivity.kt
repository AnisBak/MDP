package com.anis.lesson5_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var signIn:Button

    private var listUsers =  ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        signIn = findViewById(R.id.sign_in)

        listUsers.addAll(listOf(
            User("anis@mail.com","123"),
            User("jimmy@mail.com","123"),
            User("jack","123"),
            User("Julia","123"),
            User("Ken","123")))

        signIn.setOnClickListener {
            if (listUsers.contains(User(email.text.toString(),password.text.toString()))){
                Toast.makeText(this, "Sign in successful", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Sign in NOT successful", Toast.LENGTH_LONG).show()
            }

        }


    }
}