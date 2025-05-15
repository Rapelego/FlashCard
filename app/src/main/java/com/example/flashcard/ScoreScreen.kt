package com.example.flashcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ScoreScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var reviewAnswers by remember { mutableStateOf(false) }

            val score = intent.getIntExtra("score", -1)
            val totalQuestions = intent.getIntExtra("totalQuestions", 5)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Quiz Complete",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(20.dp))

                //Display the score
                Text(
                    text = "You scored $score out of $totalQuestions",
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.size(12.dp))

                //Feedback Based on Score
                val feedback = if (score >= 3)  "Great job!" else "Keep Practicing!"
                Text(
                    text = feedback,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.size(20.dp))

                Row(
                    modifier = Modifier.padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(onClick = { reviewAnswers = true }) {
                        Text(text = "Review Answers")
                    }

                    Button(onClick = { this@ScoreScreen.finishAffinity() }) {
                        Text(text = "Exit")
                    }
                }

                Spacer(modifier = Modifier.size(30.dp))

                if (reviewAnswers) {
                    Text(
                        text = """
                    Nelson Mandela was the first black president in South Africa: True
                    The Capital of South Africa is Cape Town: False
                    Jacob Zuma was the president of the Youth League: False
                    Shaka Zulu was a famous Bapedi leader: False
                    The apartheid era ended in the 1990's: True
                """.trimIndent(),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
            }
        }
    }
}

