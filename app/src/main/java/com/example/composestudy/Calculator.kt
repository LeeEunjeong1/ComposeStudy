package com.example.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.composestudy.ui.theme.ComposeStudyTheme

class Calculator : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MyApp {
                Text(text = "Hello Again")
            }
        }
    }
}
@Composable
fun MyApp(content: @Composable () -> Unit){
    ComposeStudyTheme() {
        Surface(color = MaterialTheme.colors.background){
            content()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2(){
    MyApp {
        Text(text = "Hello Again")
    }
}

@Preview
@Composable
fun TopHeader(totalPerPerson: Double = 0.0) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        //.clip(shape = RoundedCornerShape(corner = CornerSize(12.dp)))
        .clip(shape = CircleShape.copy(all = CornerSize(12.dp))),
        color = Color(color=0xFFE9D7F7)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val total = "%.2f".format(totalPerPerson)
            Text(text = "Total Per Person",
                style = MaterialTheme.typography.h4)
            Text(text = "$$total",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold
            )
        }

    }
}

@Preview
@Composable
fun MainContent(){
    Surface(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp,color = Color.LightGray)
    ) {
        Column() {
            Text(text = "Hello again 1")
            Text(text = "Hello again 2")
            Text(text = "Hello again 3")
        }

    }
}