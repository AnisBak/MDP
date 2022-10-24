package com.anis.lesson3_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
    private val data = listOf("Hamburger","Mexican","Pizza","American","Chinese")
    private var arrayList = ArrayList<String>()
    private lateinit var decideButton: MaterialButton
    lateinit var addFoodButton: MaterialButton
    lateinit var randomWords: MaterialTextView
    lateinit var editText: TextInputEditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        arrayList.addAll(data)
        decideButton = findViewById(R.id.decide)
        randomWords = findViewById(R.id.randomWords)
        addFoodButton = findViewById(R.id.addFood)
        editText = findViewById(R.id.editText)
        decideButton.setOnClickListener {
            randomWords.text = arrayList.random()
        }
        addFoodButton.setOnClickListener {
            arrayList.add(editText.text.toString())

        }




    }
}