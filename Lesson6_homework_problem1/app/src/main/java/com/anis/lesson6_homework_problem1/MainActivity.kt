package com.anis.lesson6_homework_problem1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.anis.lesson6_homework_problem1.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var result: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun questionOneButtonClicked(view: View) {

        if (view is RadioButton) {

            val checked = view.isChecked
            when (view.getId()) {
                R.id.radio_q1_b ->
                    if (checked) {
                        result +=50
                    }
            }
        }
    }

    fun questionTwoButtonClicked(view: View) {

        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.radio_q2_a ->
                    if (checked) {
                        result +=50

                    }
            }
        }
    }

    private fun showResultDialog(title: String, message: String){
        val alertDialog: AlertDialog = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton("OK")
                { dialog, _ ->
                    clearAnswers()
                    result = 0
                    dialog.dismiss()
                }
            }
            builder.setMessage(message)
                .setTitle(title)
            builder.create()
        }
        alertDialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun checkSolution(view: View) {
        val current = LocalDateTime.now()

        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        val date = current.format(dateFormatter)
        val time = current.format(timeFormatter)
        val message = if(result > 0)
            "Congratulations! You submitted on current $date and $time, Your achieved $result%"
        else "Please, try again."
        val title = "QuizApp Result"
        showResultDialog(title, message)
    }
    fun clearAnswers(view: View) {
        clearAnswers()
    }

    private fun clearAnswers(){
        binding.questionOneRadio.clearCheck()
        binding.questionTwoRadio.clearCheck()
    }
}