package com.example.mycompose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycompose.retrofit.PropertyDetailViewModel
import com.example.mycompose.ui.theme.MyComposeTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val viewModel: PropertyDetailViewModel =
                        viewModel() // Get the ViewModel instance
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier, viewModel: PropertyDetailViewModel) {
    val context = LocalContext.current
    val generalSemiBold = FontFamily(Font(R.font.general_semi_bold))
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginResponse = viewModel.loginResponse.value // Collect the login response state

    // Handle login response
    loginResponse?.let {
        if (it.status) {
            // Save the token in shared preferences
            saveTokenToLocalStorage(context, it.data.token)

            // Navigate to the next screen
            Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, SignUpActivity::class.java) // Replace with your next activity
            context.startActivity(intent)
        } else {
            Toast.makeText(context, "Login Failed: ${it.message}", Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
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
        )
        Spacer(modifier = Modifier.height(40.dp))

        // Email Section
        LoginInputField(
            icon = R.mipmap.icon_email,
            label = "Email",
            value = email,
            onValueChange = { email = it },
            placeholder = "Enter your email"
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Password Section
        LoginInputField(
            icon = R.mipmap.icon_password,
            label = "Password",
            value = password,
            onValueChange = { password = it },
            placeholder = "Enter your password",
            isPassword = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Forgot Password
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
                    viewModel.login(email, password)
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

@Composable
fun LoginInputField(
    icon: Int,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "$label Icon",
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label, style = TextStyle(fontSize = 16.sp, color = Color.Black))
    }
    Spacer(modifier = Modifier.height(8.dp))
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
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
        )
    )
}

fun saveTokenToLocalStorage(context: Context, token: String) {
    val sharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("auth_token", token)
    editor.apply()
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview2() {
//    MyComposeTheme {
//        Greeting2()
//    }
//}