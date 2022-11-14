package com.anis.lesson5_homework

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anis.lesson5_homework.databinding.ActivityElectronicsDetailsBinding


private const val EXTRA_TITLE = "com.anis.lesson5_homework.extra_title"
private const val EXTRA_COLOR = "com.anis.lesson5_homework.extra_color"
private const val EXTRA_IMAGE = "com.anis.lesson5_homework.extra_image"
private const val EXTRA_PRICE = "com.anis.lesson5_homework.extra_price"
private const val EXTRA_ID = "com.anis.lesson5_homework.extra_id"
private const val EXTRA_DESCRIPTION = "com.anis.lesson5_homework.extra_description"

class ElectronicsDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityElectronicsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElectronicsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            title.text = intent.getStringExtra(EXTRA_TITLE)
            price.text = intent.getStringExtra(EXTRA_PRICE)
            color.text = intent.getStringExtra(EXTRA_COLOR)
            thumbnail.setImageResource(intent.getIntExtra(EXTRA_IMAGE,0))
            description.text = intent.getStringExtra(EXTRA_DESCRIPTION)
            id.text = intent.getStringExtra(EXTRA_ID)
        }


    }

    companion object{
        fun newIntent(context: Context, title: String, price:Double,color:String,
                      id:String,
                      description:String,
                      image:Int): Intent {
            return Intent(context, ElectronicsDetailsActivity:: class.java ).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_PRICE, price)
                putExtra(EXTRA_COLOR, color)
                putExtra(EXTRA_ID, id)
                putExtra(EXTRA_DESCRIPTION, description)
                putExtra(EXTRA_IMAGE, image)
            }
        }
    }
}