package com.example.flashcard

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.flashcard.ui.theme.FlashCardTheme

class QuestionScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data class Question(val Question: String, val answer: Boolean)
        setContent {
//FlashCard Questions and answers
            val Questions = arrayOf(
                Question("Nelson Mandela was the first black president in South Africa", true),
                Question("The Capital of South Africa is Cape Town", false),
                Question("Jacob Zuma was the president of the Youth League", false),
                Question("Shaka Zulu was a famous Bapedi leader", false),
                Question("The apartheid era ended in the 1990's", true)
            )
            //Check questions and update score
            var currentQuestionIndex = 0
            var score = 0

            fun checkAnswer(answer: Boolean) {
                if (answer == Questions[currentQuestionIndex].answer) {
                    score++
                    val feedbackTextView = null
                    feedbackTextView.text = "Correct!"
                } else {
                    val feedbackTextView = null
                    feedbackTextView.text = "incorrect!"
                }
                currentQuestionIndex++
                if (currentQuestionIndex < Questions.size) {
                    displayQuestion()
                } else {
                    displayScore()
                }
            }
            fun displayQuestion(){
                val questionTextView = null
                questionTextView.text= Questions[currentQuestionIndex].Question
            }
            fun displayScore(){
                val intent= Intent(this, ScoreScreen::class.java)
                intent.putExtra("score",score)
                startActivity(intent)
            }




        }
    }

    private fun displayScore() {
        TODO("Not yet implemented")
        }
    }


