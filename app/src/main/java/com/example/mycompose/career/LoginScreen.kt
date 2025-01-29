package com.example.mycompose.career

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycompose.R

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Welcome!",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = "Image",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(120.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Sign in to your account",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "Your Name",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFEDEDED),
                unfocusedContainerColor = Color(0xFFEDEDED),
                disabledContainerColor = Color(0xFFEDEDED),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp),
                    onValueChange = {})

        OutlinedTextField(
            value = "Enter Your Phone Number",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFEDEDED),
                unfocusedContainerColor = Color(0xFFEDEDED),
                disabledContainerColor = Color(0xFFEDEDED),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            onValueChange = {})

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .background(Color.Blue, shape = RoundedCornerShape(30.dp))
                .padding(vertical = 16.dp, horizontal = 40.dp)
        ) {
            Text(
                text = "Sign in",
                fontSize = 20.sp,
                color = Color.White, // Text color for contrast
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "or continue with",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {


            Image(
                painter = painterResource(id = R.drawable.icon_google),
                contentDescription = "Image",
                modifier = Modifier
                    .height(40.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(20.dp))

            Image(
                painter = painterResource(id = R.drawable.icon_facebook),
                contentDescription = "Image",
                modifier = Modifier
                    .height(40.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(20.dp))

            Image(
                painter = painterResource(id = R.drawable.icon_twitter),
                contentDescription = "Image",
                modifier = Modifier
                    .height(40.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Don’t have an account? Sign up",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 14.sp
        )
    }

}