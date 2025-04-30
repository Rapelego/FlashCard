package com.example.flashcard

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

class ScoreScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
val score = intent.getIntExtra("score",0)
            scoreTextView.text= "You Scored $score out of ${Questions.size}"
            if (score>=3) {
                feedbackTextView.text ="Great Job!" } else{
                feedbackTextView."Keep Studying!"
            }
        }
    }
}

