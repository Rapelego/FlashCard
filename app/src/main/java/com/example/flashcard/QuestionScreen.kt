package com.example.flashcard

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
            //variables
            val totalQuestions =5//total number of questions
            var isQuizComplete by remember { mutableStateOf(false) }//
            var currentQuestionIndex by remember { mutableStateOf(0) }//
            var userScore by remember { mutableStateOf(0) }//
            var resultsMessage by remember { mutableStateOf("") }//
            var areButtonDisabled by remember { mutableStateOf(false) }//

            val Questions = arrayOf(
                "Nelson Mandela was the first black president in South Africa",
                "The Capital of South Africa is Cape Town",
                "Jacob Zuma was the president of the Youth League",
                "Shaka Zulu was a famous Bapedi leader",
                "The apartheid era ended in the 1990's",
            )//
            val Answers = arrayOf(true,false,false,false,true)//

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,//
                modifier= Modifier.fillMaxSize()
            ){//Check if quiz is ongoing
                if (isQuizComplete && currentQuestionIndex < totalQuestions) {
                    Text(text = Questions[currentQuestionIndex])//display current question
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(text=resultsMessage)
                    Spacer(modifier = Modifier.height(50.dp))

                    Row{//True Button
                        Button(
                            onClick = {
                                if (Answers[currentQuestionIndex]) {
                                    resultsMessage = "correct!"
                                    userScore++ //Increment Score
                                }else{
                                    resultsMessage= "Wrong!"
                                }
                                areButtonDisabled= true//disable button after selection
                            },
                            enabled = areButtonDisabled//
                        ) {
                            Text(text = "true")
                        }
                     //False Button
                        Button(onClick = {
                            if (Answers[currentQuestionIndex]){//if answer is correct
                                resultsMessage= "Correct!"
                                userScore++
                            }else{
                                resultsMessage= "Wrong!"
                            }
                            areButtonDisabled= true//
                        },) {Text(text= "False") }//
                    }
                }
        //Next Button
         Button(onClick = {currentQuestionIndex++//move to next question
                           resultsMessage=""//Clear feedback
                           areButtonDisabled= false//re-enable buttons
                 if (currentQuestionIndex>=totalQuestions) {
                     //Check if Quiz is Completed
                     isQuizComplete=true
                 }
         }) { Text(text = "Next")}
            }





        }
    }

    }


