package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.fms.quiz.R

class QuizQuestions : AppCompatActivity() {
    //Create global variables for the views in the layout
    private var progressBar: ProgressBar?=null
    private var tvProgress: TextView? = null
    private var tvQuestion:TextView? = null
    private var ivImage: ImageView? = null
    private var tvOptionOne:TextView? = null
    private var tvOptionTwo:TextView? = null
    private var tvOptionThree:TextView? = null
    private var tvOptionFour:TextView? = null
    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        var questionsList = Constants.questions()
        Log.i("QuestionsList size is", "${questionsList.size}")

        // START
        val currentPosition = 1 // Default and the first question position
        val question: Question? =
            questionsList[currentPosition - 1] // Getting the question from the list with the help of current position.

        progressBar=findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        progressBar?.progress =
            currentPosition // Setting the current progress in the progressbar using the position of question
        tvProgress?.text =
            "$currentPosition" + "/" + progressBar?.getMax() // Setting up the progress text

        // Now set the current question and the options in the UI
        tvQuestion?.text = question!!.questions
        ivImage?.setImageResource(question.image)
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
    }
}