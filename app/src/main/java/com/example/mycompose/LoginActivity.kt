package com.example.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycompose.ui.theme.MyComposeTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val generalSemiBold = FontFamily(
        Font(R.font.general_semi_bold)
    )
    Column(
        modifier = Modifier
        .padding(all = 16.dp)
        .verticalScroll(rememberScrollState())) {

        Spacer(modifier = Modifier.height(40.dp)) // Add horizontal gap between image and text
        Text(
            text = "Let’s sign you in",
            fontSize = 30.sp,
            fontFamily = generalSemiBold,
            modifier = modifier
        )

        Text(
            text = "Enter your information below or continue with your social account.",
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(40.dp)) // Add horizontal gap between image and text
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.mipmap.icon_email),
                contentDescription = "Email Icon",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp)) // Add horizontal gap between image and text
            Text(
                text = "Email",
                style = TextStyle(fontSize = 16.sp, color = Color.Black)
            )

        }

        TextField(
            value = "example@example.com",
            onValueChange = {
                // Handle the text change
            },
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color(0xFFF9F9F9), // Set the background color
//                focusedIndicatorColor = Color.Transparent, // Remove the underline when focused
//                unfocusedIndicatorColor = Color.Transparent, // Remove the underline when not focused
//                disabledIndicatorColor = Color.Transparent // Remove the underline when disabled
//            ),
            modifier = Modifier
                .fillMaxWidth() // Set to full width
                .background(color = Color(0xFFF9F9F9), shape = RoundedCornerShape(8.dp)) // Rounded corners
                .padding(horizontal = 16.dp) // Optional: Add padding
                .height(56.dp) // Optional: Set height
                .clip(RoundedCornerShape(8.dp)) // Ensure corners are clipped
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyComposeTheme {
        Greeting2("Android")
    }
}