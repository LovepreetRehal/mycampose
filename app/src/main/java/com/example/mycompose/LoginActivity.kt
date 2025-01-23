package com.example.mycompose


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2( modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val generalSemiBold = FontFamily(
        Font(R.font.general_semi_bold)
    )
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
//            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Let’s sign you in",
            fontSize = 30.sp,
            fontFamily = generalSemiBold,
            modifier = modifier
        )
        Text(
            text = "Enter your information below or continue with your social account.",
//            modifier = modifier.padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))

        // Email Section
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.mipmap.icon_email),
                contentDescription = "Email Icon",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Email", style = TextStyle(fontSize = 16.sp, color = Color.Black))
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Email") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFEDEDED),
                unfocusedContainerColor = Color(0xFFEDEDED),
                disabledContainerColor = Color(0xFFEDEDED),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFF9F9F9), shape = RoundedCornerShape(8.dp))
                .height(56.dp)
                .clip(RoundedCornerShape(8.dp))
        )


        Spacer(modifier = Modifier.height(20.dp))

        // Password Section
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.mipmap.icon_password),
                contentDescription = "Password Icon",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Password", style = TextStyle(fontSize = 16.sp, color = Color.Black))
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Enter your password") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF9F9F9), RoundedCornerShape(8.dp))
                .height(56.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFEDEDED),
                unfocusedContainerColor = Color(0xFFEDEDED),
                disabledContainerColor = Color(0xFFEDEDED),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Forgot Password?",
            modifier = Modifier
                .align(Alignment.End)
                .clickable {
                    // Handle Forgot Password
                },
            style = TextStyle(fontSize = 16.sp, color = Color.Blue)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Social Login
        Image(
            painter = painterResource(id = R.mipmap.icon_google),
            contentDescription = "Google Icon",
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.CenterHorizontally)
                .clickable { /* Handle Google Sign-In */ }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Sign In Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black, shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
                .clickable {
                    val intent = Intent(context, SignUpActivity::class.java)
                    context.startActivity(intent)
                },
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Sign In",
                style = TextStyle(fontSize = 16.sp, color = Color.White)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyComposeTheme {
        Greeting2()
    }
}