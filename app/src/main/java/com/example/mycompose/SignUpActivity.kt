package com.example.mycompose

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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycompose.retrofit.PropertyDetailViewModel
import com.example.mycompose.ui.theme.MyComposeTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposeTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val viewModel: PropertyDetailViewModel =
                        viewModel() // Get the ViewModel instance
                       Greeting3(name = "Android", modifier = Modifier.padding(innerPadding),viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier,viewModel: PropertyDetailViewModel) {

    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    try {
        val registerResponse  = viewModel.signUpResponse.value
        registerResponse.let {
            if (it!!.status){

                Toast.makeText(context, "Success -> ${it.message}", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Error -> ${it.message}", Toast.LENGTH_SHORT).show()

            }
        }
    }catch (e:Exception){
        Log.e("TAG_SignUp", "Greeting3:" )
    }



    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Let’s sign you up ", fontSize = 30.sp)
        Text(text = "Enter your information below or continue with your social account.")
        Spacer(modifier = Modifier.height(40.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Email Address") },
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
        TextField(
            value = userName,
            onValueChange = { userName = it },
            placeholder = { Text("User Name") },
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
        TextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            placeholder = { Text("Phone Number") },
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
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
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
        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            placeholder = { Text("Confirm Password") },
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
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(R.mipmap.icon_google),
            contentDescription = "google login",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Sign In Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black, shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
                .clickable {
//                    val intent = Intent(context, SignUpActivity::class.java)
//                    context.startActivity(intent)

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

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview3() {
//    MyComposeTheme {
//        Greeting3("Android")
//    }
//}