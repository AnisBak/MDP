package com.anis.lesson4_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {
    private lateinit var table:TableLayout
    lateinit var button: Button
    lateinit var version:EditText
    lateinit var codeName:EditText
    lateinit var row:TableRow
    lateinit var versionText:TextView
    private lateinit var codeNameText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        table = findViewById(R.id.table)
        button = findViewById(R.id.button)
        version = findViewById(R.id.androidVersion)
        codeName = findViewById(R.id.androidCodeName)

        button.setOnClickListener {
            versionText = TextView(applicationContext)
            codeNameText = TextView(applicationContext)
            versionText.apply {
                text = version.text
                setPadding(0,0,200,0)
                setTextColor(resources.getColor(R.color.black))

            }
            codeNameText.apply {
                text = codeName.text
                setTextColor(resources.getColor(R.color.black))
            }
            row = TableRow(applicationContext)
            row.apply {
                addView(versionText,0)
                addView(codeNameText,1)
            }
            table.addView(row)
        }
    }
}