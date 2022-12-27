package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.fms.quiz.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quizStartBtn : Button = findViewById(R.id.quizStart)
        val tvName : EditText = findViewById(R.id.tvName)

        quizStartBtn.setOnClickListener {
            if (tvName.text.isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_LONG).show()
            }else{
                val quizquestIntent : Intent = Intent(this, QuizQuestions::class.java)
                startActivity(quizquestIntent)
                finish()
            }
        }
    }
}