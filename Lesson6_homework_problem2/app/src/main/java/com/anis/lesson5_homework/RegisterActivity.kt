package com.anis.lesson5_homework

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val EXTRA_USERNAME_FROM_REGISTER = "com.anis.lesson5_homework.username_from_register"
const val EXTRA_PASSWORD_FROM_REGISTER = "com.anis.lesson5_homework.password_from_register"
class RegisterActivity : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var password : EditText
    lateinit var firstName: EditText
    lateinit var lastName:EditText
    private lateinit var create:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        username = findViewById(R.id.email)
        password = findViewById(R.id.password)
        create = findViewById(R.id.sign_up)
        firstName = findViewById(R.id.fn)
        lastName = findViewById(R.id.ln)
        create.setOnClickListener {
            if (
                username.text.isNotEmpty() &&
                password.text.isNotEmpty() &&
                firstName.text.isNotEmpty()&&
                lastName.text.isNotEmpty()
            ){
                intent = Intent().apply {
                    putExtra(EXTRA_USERNAME_FROM_REGISTER, username.text.toString())
                    putExtra(EXTRA_PASSWORD_FROM_REGISTER, password.text.toString())
                }
                setResult(Activity.RESULT_OK, intent)
                Toast.makeText(this, "Account created successfully!", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this, "Fill all the fields", Toast.LENGTH_LONG).show()

            }

        }


    }


    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterActivity:: class.java )
        }
    }
}