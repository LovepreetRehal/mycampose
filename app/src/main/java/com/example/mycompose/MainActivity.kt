package com.example.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycompose.test.DashboardScreen
import com.example.mycompose.ui.theme.MyComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyComposeTheme {
                // Set up Navigation
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "dashboard", // Specify Dashboard as the starting screen
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("dashboard") { DashboardScreen() }
                        // Add other routes here as needed
                    }

            }
            }
        }
    }
}

