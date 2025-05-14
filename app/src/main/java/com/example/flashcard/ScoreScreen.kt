package com.example.flashcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flashcard.ui.theme.FlashCardTheme

class ScoreScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          var reviewAnswers by remember{mutableStateOf(false)}
          var Score = intent.getIntExtra("score",-1)
          var  totalQuestions = intent.getIntExtra("totalQuestions",-1)

     Column {
         Text(text = "Quiz Complete")
         Spacer(modifier = Modifier.size(20.dp))
         if (Score<3){
             Text(text="Better luck next time:$Score/$totalQuestions")//if scored less than 3

         }else{
             Text(text="Congradulations: $Score/$totalQuestions")}//if scored over 3
        }

            Row {
                Button(onClick =  {reviewAnswers= true
                }){
                Text(text = "Review Answers")
                }

                Button({this@ScoreScreen.finishAffinity()}) {
                    Text(text = "Exit")
                }//close all activities
            }
Spacer(modifier = Modifier.size(30.dp))
            if (reviewAnswers)//reviews and displays questions and answers
            {
                Text(text = "Nelson Mandela was the first black president in South Africa: True\n"+
                "The Capital of South Africa is Cape Town : False\n"+
                "Jacob Zuma was the president of the Youth League: False\n"+
                "Shaka Zulu was a famous Bapedi leader : False\n"+
                "The apartheid era ended in the 1990's : True\n",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}

