package com.example.flashcard

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flashcard.ui.theme.FlashCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(text = "Welcome")
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = "This a flash card app to help you study for your History")
                Divider()
                Spacer(modifier = Modifier.size(50.dp))
                Button(onClick = {
                    //Runs Question Screen When Clicked
                    val Start = Intent (this@MainActivity, QuestionScreen::class.java)
                    startActivity(Start)
                })
                {
                    Text(text = "Start Quiz")
                }


            }
        }
    }
}

