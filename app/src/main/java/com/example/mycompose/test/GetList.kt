package com.example.mycompose.test

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun GetList(navController: NavController,  email :String ,  userName :String) {

    var context = LocalContext.current

    val list = remember {
        listOf(
            ListData(name = "Ram", phone = "9876543210"),
            ListData(name = "Sham", phone = "9856231014"),
            ListData(name = "Kuldeep", phone = "9876545564"),
            ListData(name = "Ravi", phone = "9876543210"),
            ListData(name = "Noor", phone = "9876543210"),
            ListData(name = "Surinder", phone = "9876543210"),
            ListData(name = "Ram", phone = "9876543210"),
            ListData(name = "Sham", phone = "9856231014"),
            ListData(name = "Kuldeep", phone = "9876545564"),
            ListData(name = "Ravi", phone = "9876543210"),
            ListData(name = "Noor", phone = "9876543210"),
            ListData(name = "Surinder", phone = "9876543210"),
            ListData(name = "Ram", phone = "9876543210"),
            ListData(name = "Sham", phone = "9856231014"),
            ListData(name = "Kuldeep", phone = "9876545564"),
            ListData(name = "Ravi", phone = "9876543210"),
            ListData(name = "Noor", phone = "9876543210"),
            ListData(name = "Surinder", phone = "9876543210"),
            ListData(name = "Ram", phone = "9876543210"),
            ListData(name = "Sham", phone = "9856231014"),
            ListData(name = "Kuldeep", phone = "9876545564"),
            ListData(name = "Ravi", phone = "9876543210"),
            ListData(name = "Noor", phone = "9876543210"),
            ListData(name = "Surinder", phone = "9876543210"),
        )
    }

    Toast.makeText(context, "$email & $userName ", Toast.LENGTH_SHORT).show()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list) { itemList ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Name -> " + itemList.name)
                    Text(text = "Phone -> " + itemList.phone)
                }
            }
        }

    }
}