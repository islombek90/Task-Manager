package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GreetingImage(
                        taskText = stringResource(R.string.all_tasks_completed),
                        taskEvaluation = stringResource(R.string.nice_work),
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(taskText: String, taskEvaluation: String,  modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text = taskText,
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center

        )
        Text(
            text = taskEvaluation,
            fontSize = 16.sp
        )

    }

}

@Composable
fun GreetingImage(taskText: String, taskEvaluation: String,){
    val image = painterResource(R.drawable.ic_task_completed)
    Column(modifier = Modifier.fillMaxSize().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = image,
            contentDescription = null,
        )


        Greeting(
            taskText = taskText,
            taskEvaluation = taskEvaluation,


            )

    }




}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        GreetingImage(
            taskText = stringResource(R.string.all_tasks_completed),
            taskEvaluation = stringResource(R.string.nice_work),

        )
    }
}