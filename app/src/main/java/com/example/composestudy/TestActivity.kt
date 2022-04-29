package com.example.composestudy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composestudy.ui.theme.ComposeStudyTheme

class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme{
                MyApp()
            }
        }
    }
}
@Composable
fun MyApp(){
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(all = 30.dp),
        color = Color.Yellow
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "$100", style = TextStyle(
                fontSize = 35.sp,
                fontWeight = FontWeight.ExtraBold
            ))
            Spacer(modifier = Modifier.height(130.dp))
            CreateCircle()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MyApp()
}

@Preview
@Composable
fun CreateCircle(){
    var cnt by remember {
        mutableStateOf(0)
    }
    Card(modifier = Modifier
        .padding(3.dp)
        .size(50.dp)
        .clickable {
            cnt += 1
            Log.d("Tap", "CreateCircle : Tap")
        },
    shape = CircleShape,
    elevation = 4.dp) {
        Box(contentAlignment = Alignment.Center){
            Text(text = "Tap $cnt",modifier = Modifier)
        }

    }
}
