package com.anis.lesson5_homework

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var signIn:Button
    lateinit var newAccount:Button
    private var listUsers =  ArrayList<User?>()
    lateinit var forgotPassword: TextView
    private val shoppingCategoryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//        result ->
//        if(result.resultCode == Activity.RESULT_OK){
//        }
    }
    private val registerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        if(result.resultCode == Activity.RESULT_OK){
            listUsers.add(
                User(result.data?.getStringExtra(EXTRA_USERNAME_FROM_REGISTER)
                    ,result.data?.getStringExtra(EXTRA_PASSWORD_FROM_REGISTER)))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        signIn = findViewById(R.id.sign_in)
        newAccount = findViewById(R.id.new_account)
        forgotPassword = findViewById(R.id.forgot_password)

        listUsers.addAll(listOf(
            User("anis@mail.com","123"),
            User("jimmy@mail.com","123"),
            User("jack","123"),
            User("Julia","123"),
            User("Ken","123")))

        signIn.setOnClickListener {
            if (listUsers.contains(User(email.text.toString(),password.text.toString()))){
                val intent = ShoppingCategoryActivity.newIntent(this@MainActivity, email.text.toString())
                shoppingCategoryLauncher.launch(intent)

            }else{
                Toast.makeText(this, "Sign in NOT successful", Toast.LENGTH_LONG).show()
            }
        }
        newAccount.setOnClickListener {
                val intent = RegisterActivity.newIntent(this@MainActivity)
                registerLauncher.launch(intent)
        }
        forgotPassword.setOnClickListener {
            listUsers.forEach { it ->
                if (it?.username == email.text.toString()){
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT, it.password)
                    startActivity(intent)
                }
            }
        }
    }
}