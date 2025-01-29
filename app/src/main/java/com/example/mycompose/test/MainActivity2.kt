package com.example.mycompose.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycompose.R
import com.example.mycompose.ui.theme.MyComposeTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting4(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {

    var value by remember { mutableStateOf(0) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello Rehal", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.mipmap.img_property),
                contentDescription = "property Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Share")
                }

                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)

                ) {
                    Text(text = "Subscribe")
                }

            }

            Spacer(modifier = Modifier.height(36.dp))

            Text(text = "Total = $value", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    value++

                },
            ) {
                Text(text = "Increment")
            }

        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview3() {
    MyComposeTheme {
        Greeting4("Android")

    }
}





data class ListData(var name: String, var phone: String)

