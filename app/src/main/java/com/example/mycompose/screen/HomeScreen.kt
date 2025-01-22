package com.example.mycompose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycompose.R

@Composable
fun HomeScreen() {
    val items = listOf(
        "Item 1",
        "Item 2",
        "Item 3"     ,
        "Item 1",
        "Item 2",
        "Item 3"   ,
        "Item 1",
        "Item 2",
        "Item 3"
    )

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,) {
        Text("Welcome to the Home Screen!", modifier = Modifier.padding(bottom = 32.dp))

    }

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        items(items.size){ index->
            Row (modifier = Modifier.padding(all = 16.dp)){
                Image(painter = painterResource(id = R.mipmap.img_property), contentDescription = "Image", modifier = Modifier.size(140.dp))
                Spacer(modifier = Modifier.width(2.dp))
                Column {
                    Text(text = "hii user",Modifier.padding(start = 8.dp))
                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_location), // Your location icon
                            contentDescription = "Location Icon",
                            modifier = Modifier.size(20.dp) // Set the size of the icon
                        )
                        Text(
                            text = "Mohali, Chandigarh", // Text equivalent to android:text="Name"
                            style = TextStyle(fontSize = 16.sp, color = Color.Black)
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth() // Ensures the Row takes full width
                    ) {
                        // First inner Row with icon and text for "Bed"
                        Row(
                            modifier = Modifier
                                .weight(1f) // Ensures equal distribution of space
                                .border(1.dp, Color.Gray, shape = RectangleShape) // Black border for the Row
                                .padding(4.dp), // Padding inside the Row for spacing
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.mipmap.icon_bed), // Your location icon for Bed
                                contentDescription = "Bed Icon",
                                modifier = Modifier.size(20.dp) // Set the size of the icon
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text
                            Text(
                                text = "0", // Text for Bed
                                style = TextStyle(fontSize = 16.sp, color = Color.Black)
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp)) // Space between two rows

                        // Second inner Row with icon and text for "Bathroom"
                        Row(
                            modifier = Modifier
                                .weight(1f) // Ensures equal distribution of space
                                .border(1.dp, Color.Gray, shape = RectangleShape) // Black border for the Row
                                .padding(4.dp), // Padding inside the Row for spacing
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.mipmap.icon_bathroom), // Your location icon for Bathroom
                                contentDescription = "Bathroom Icon",
                                modifier = Modifier.size(20.dp) // Set the size of the icon
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text
                            Text(
                                text = "0", // Text for Bathroom
                                style = TextStyle(fontSize = 16.sp, color = Color.Black)
                            )
                        }
                    }

                    Text(
                        text = "Configure your layout"
                    )
                }
            }

        }
    }

}