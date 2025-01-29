package com.example.mycompose.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showSystemUi = true, showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConvetUi() {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }

    var showBottomSheet by remember { mutableStateOf(false) }
    var sheetState  = rememberModalBottomSheetState(skipPartiallyExpanded = false)



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(text = "Unit converter", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
        }, label = {
            Text(text = "Enter value")
        },
            modifier = Modifier.fillMaxWidth()

        )


    }


}

@Composable
fun BottomSheet(onCloses: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {
        Text(text = "Bottom Sheet Content")
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onCloses) {
            Text(text = "Close Bottom Sheet ")
        }
    }


}