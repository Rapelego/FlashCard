package com.example.flashcard

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flashcard.ui.theme.FlashCardTheme

class QuestionScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Total number of questions
            val totalQuestions = 5

            //Variables to track quiz progress
            var isQuizComplete by remember { mutableStateOf(false) }//Tracks if quiz is done
            var currentQuestionIndex by remember { mutableStateOf(0) }//Index of current question
            var userScore by remember { mutableStateOf(0) }//Number of correct answers
            var resultsMessage by remember { mutableStateOf("") }//Message after answering
            var areButtonDisabled by remember { mutableStateOf(false) }//Prevents double answer

            //Array of questions
            val Questions = arrayOf(
                "Nelson Mandela was the first black president in South Africa",
                "The Capital of South Africa is Cape Town",
                "Jacob Zuma was the president of the Youth League",
                "Shaka Zulu was a famous Bapedi leader",
                "The apartheid era ended in the 1990's"
            )

            //correct Answers
            val Answers = arrayOf(true, false, false, false, true)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
            //Check if quiz is ongoing
            if (!isQuizComplete && currentQuestionIndex < totalQuestions) {
                Text(text = Questions[currentQuestionIndex])//display current question
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = resultsMessage)//display feedback (Correct/Incorrect)
                Spacer(modifier = Modifier.height(50.dp))

                Row {//True Button
                    Button(
                        onClick = {
                            if (Answers[currentQuestionIndex]) {
                                resultsMessage = "correct!"
                                userScore++ //Shows Score
                            } else {
                                resultsMessage = "Incorrect!"
                            }
                            areButtonDisabled = true//disable button after selection
                        },
                        enabled = !areButtonDisabled//
                    ) {
                        Text(text = "True")
                    }
                    //False Button
                    Button(
                        onClick = {
                            if (!Answers[currentQuestionIndex]) {//if answer is correct
                                resultsMessage = "Correct!"
                                userScore++//Shows score
                            } else {
                                resultsMessage = "Incorrect!"
                            }
                            areButtonDisabled = true//Disable button after Selection
                        },
                        enabled = !areButtonDisabled
                    ) { Text(text = "False") }//
                }
            }
                Spacer(modifier = Modifier.height(24.dp))

                // NEXT Button: Only visible if quiz is not yet complete
                if (currentQuestionIndex < totalQuestions - 1) {
                    Button(
                        onClick = {
                            currentQuestionIndex++ // Move to next question
                            resultsMessage = "" // Clear feedback
                            areButtonDisabled = false // Re-enable buttons
                        }
                    ) {
                        Text(text = "Next")
                    }
                } else {
                    // At last question: mark quiz as complete when Next would be pressed
                    Button(
                        onClick = {
                            isQuizComplete = true
                        }
                    ) {
                        Text(text = "Finish Quiz")
                    }
                }
            }

            //View Results button which appears when quiz is finished
                if (isQuizComplete) {
                    Spacer(modifier = Modifier.height(40.dp))
                    Button(onClick = {
                        //Navigate to score Screen with score and total
                        val intent = Intent(this@QuestionScreen, ScoreScreen::class.java)
                        intent.putExtra("score", userScore)
                        intent.putExtra("total", totalQuestions)
                        startActivity(intent)
                        finish()
                    }) {
                        Text(text = "View Results")
                    }
                }
            }
        }
    }




