package com.example.mycompose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycompose.ui.theme.MyComposeTheme
import kotlin.math.round

class WelcomeActivity : ComponentActivity() {
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
    
    var context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Load the image using painterResource
        val backgroundPainter: Painter = painterResource(id = R.mipmap.img_slider1)

        // Display the image as a background
        Image(
            painter = backgroundPainter,
            contentDescription = "Background Image",
        )

        // Add other UI elements here
    }

    Box(
        modifier = Modifier.fillMaxSize() // Root layout to take up the full screen
    ) {
        // Box at the bottom
        Box(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter) // Align the box to the bottom center
                .background(Color.White, RoundedCornerShape(48.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth() // Make the column take the full width
                    .padding(horizontal = 16.dp), // Add horizontal padding
                horizontalAlignment = Alignment.CenterHorizontally // Center items horizontally
            ) {
                Spacer(modifier = Modifier.height(40.dp))

                // Title
                Text(
                    text = "Stay Saver",
                    fontWeight = FontWeight.Bold, // Set fontWeight here
                    style = TextStyle(fontSize = 36.sp, color = Color.Black)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Description
                Text(
                    text = "View your itineraries and explore upcoming port destinations",
                    style = TextStyle(fontSize = 16.sp, color = Color.Black),
                    modifier = Modifier
                        .fillMaxWidth() // Ensures the text spans the full width
                        .wrapContentWidth(Alignment.CenterHorizontally) // Aligns text content to the center
                        .clickable {
                            // Handle click
                        }
                )
                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black, shape = RoundedCornerShape(16.dp))
                        .padding(16.dp)
                        .clickable {
//                            viewModel.login(email, password)

                            val token = getTokenFromLocalStorage(context)
                            if (token.isNullOrEmpty()) {
                                Toast.makeText(context, "No token found!", Toast.LENGTH_SHORT).show()
                                context.startActivity(Intent(context,LoginActivity::class.java))
                            } else {
                                context.startActivity(Intent(context,DashboardActivity::class.java))
                                // Navigate to the next screen or perform an action
                            }
                        },
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Sign In",
                        style = TextStyle(fontSize = 16.sp, color = Color.White)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable {

                            val token = getTokenFromLocalStorage(context)
                            if (token.isNullOrEmpty()) {
                                Toast.makeText(context, "No token found!", Toast.LENGTH_SHORT).show()
                                context.startActivity(Intent(context,LoginActivity::class.java))
                            } else {
                                context.startActivity(Intent(context,DashboardActivity::class.java))
                                // Navigate to the next screen or perform an action
                            }
                        },
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Skip",
                        style = TextStyle(fontSize = 16.sp, color = Color.Black)
                    )
                }

            }
        }
    }
}

// Function to retrieve token from SharedPreferences
fun getTokenFromLocalStorage(context: Context): String? {
    val sharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    return sharedPreferences.getString("auth_token", null)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyComposeTheme {
        Greeting2("Android")
    }
}