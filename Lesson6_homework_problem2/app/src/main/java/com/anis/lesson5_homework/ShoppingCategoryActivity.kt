package com.anis.lesson5_homework

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


private const val EXTRA_USERNAME = "com.anis.lesson5_homework.extra_username"
class ShoppingCategoryActivity: AppCompatActivity() {
    lateinit var username : TextView
    lateinit var message: String
    lateinit var electronics: CardView
    lateinit var clothing: CardView
    lateinit var beauty: CardView
    lateinit var food: CardView
    private val electronicsActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//        result ->
//        if(result.resultCode == Activity.RESULT_OK){
//        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        username = findViewById(R.id.username)
        message = "Welcome ${intent.getStringExtra(EXTRA_USERNAME)}"
        username.text = message

        electronics = findViewById(R.id.electronicsCard)
        clothing = findViewById(R.id.clothingCard)
        beauty = findViewById(R.id.beautyCard)
        food = findViewById(R.id.foodCard)

        electronics.setOnClickListener{
            Toast.makeText(this, "You have chosen the Electronics category of shopping", Toast.LENGTH_SHORT).show()
            val intent = ElectronicsActivity.newIntent(this@ShoppingCategoryActivity)
            electronicsActivityLauncher.launch(intent)
        }
        clothing.setOnClickListener{
            Toast.makeText(this, "You have chosen the Clothing category of shopping", Toast.LENGTH_SHORT).show()
        }
        beauty.setOnClickListener{
            Toast.makeText(this, "You have chosen the Beauty category of shopping", Toast.LENGTH_SHORT).show()
        }
        food.setOnClickListener{
            Toast.makeText(this, "You have chosen the Food category of shopping", Toast.LENGTH_SHORT).show()
        }

    }

    companion object{
        fun newIntent(context: Context, username: String): Intent {
            return Intent(context, ShoppingCategoryActivity:: class.java ).apply {
                putExtra(EXTRA_USERNAME, username)
            }
        }
    }
}