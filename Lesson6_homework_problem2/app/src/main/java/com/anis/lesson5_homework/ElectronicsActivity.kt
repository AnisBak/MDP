package com.anis.lesson5_homework

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ElectronicsActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    var productsList = listOf(
        Product("TV LG", 128.0,"Black", R.drawable.tv,"1","24 inch tv", "#6473"),
        Product("iPhone 14 pro", 999.0,"black",R.drawable.phone,"2","Black iphone", "#06756"),
        Product("HP laptop",650.0,"Grey", R.drawable.laptop,"3", "16 GB RAM laptop", "#4537"),
        Product("Mouse HP",19.0,"Black", R.drawable.mouse,"4", "Wireless mouse", "#1964"),
        Product("Web-camera", 34.0,"Black", R.drawable.camera,"5","Web-camera  ultra-wide", "#8574")
    )
    private val electronicsDetailActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//        result ->
//        if(result.resultCode == Activity.RESULT_OK){
//        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronics)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@ElectronicsActivity)
        recyclerView.adapter = ElectronicsListAdapter(productsList){ title,color,price,id,description, image->
            val intent = ElectronicsDetailsActivity.newIntent(this@ElectronicsActivity, title,price,color,id,description, image)
            electronicsDetailActivityLauncher.launch(intent)

        }
    }


    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, ElectronicsActivity:: class.java )
        }
    }
}