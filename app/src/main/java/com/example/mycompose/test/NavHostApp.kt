package com.example.mycompose.test

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun NavHostApp() {

    val navController = rememberNavController()

    NavHost(navController = navController , startDestination = routs.Login){
        composable<routs.Login> {
            LoginDegin(navController)

        }

        composable<routs.Detail> {

            val data = it.toRoute<routs.Detail>()

            GetList(navController ,data.email, data.userName)

        }
//        composable<routs.DashbaordScreen> {
//
//            val data = it.toRoute<routs.Detail>()
//
//            GetList(navController ,data.email, data.userName)
//
//        }

    }

}