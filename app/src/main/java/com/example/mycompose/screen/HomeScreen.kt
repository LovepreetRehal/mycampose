package com.example.mycompose.screen

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycompose.PropertyDetailActivity
import com.example.mycompose.R
import com.example.mycompose.retrofit.AllProperties
import com.example.mycompose.retrofit.PropertyDetailViewModel

@Composable
fun HomeScreen() {
    // Get the current context
    val context = LocalContext.current
    val propertyListData : ArrayList<AllProperties> = ArrayList()

//    val items = listOf(
//        "Item 1",
//        "Item 2",
//        "Item 3",
//        "Item 4",
//        "Item 5"
//    )
    val viewModel: PropertyDetailViewModel = viewModel() // Get the ViewModel instance
    val propertyList = viewModel.propertyList.value

    // Call the API when the screen is composed
    LaunchedEffect(Unit) {
        viewModel.getPropertyList()
    }

    if (propertyList == null) {
//        Text(text = "Loading...", modifier = Modifier.ali.align(Alignment.CenterHorizontally))
        Log.e("TAG_List", "Greeting  51  : $propertyList")

    } else {
//        Text(text = "Loading...", modifier = Modifier.align(Alignment.CenterHorizontally))
        Log.e("TAG_List", "Greeting: $propertyList")

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Welcome to the Home Screen!", modifier = Modifier.padding(bottom = 32.dp))
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        try {
            val items =  propertyList?.data?.properties?.data
            items(items!!.size) { index ->
                Row(
                    modifier = Modifier
                        .padding(all = 16.dp)
                        .clickable {
                            // Navigate to PropertyDetailActivity
                            val intent = Intent(context, PropertyDetailActivity::class.java).apply {
                                putExtra("propertyId", items[index].id.toString())
                            }
                            context.startActivity(intent)
                        }
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.img_property),
                        contentDescription = "Image",
                        modifier = Modifier.size(140.dp)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Column {
                        Text(text = items[index].name.toString(), Modifier.padding(start = 8.dp))
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_location),
                                contentDescription = "Location Icon",
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = items[index].address.toString(),
                                style = TextStyle(fontSize = 16.sp, color = Color.Black)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Row(
                                modifier = Modifier
                                    .weight(1f)
                                    .border(1.dp, Color.Gray, shape = RectangleShape)
                                    .padding(4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.mipmap.icon_bed),
                                    contentDescription = "Bed Icon",
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = items[index].beds.toString(),
                                    style = TextStyle(fontSize = 16.sp, color = Color.Black)
                                )
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Row(
                                modifier = Modifier
                                    .weight(1f)
                                    .border(1.dp, Color.Gray, shape = RectangleShape)
                                    .padding(4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.mipmap.icon_bathroom),
                                    contentDescription = "Bathroom Icon",
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = items[index].baths.toString(),
                                    style = TextStyle(fontSize = 16.sp, color = Color.Black)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = items[index].add_info.toString(),
                        )
                    }
                }
            }

        }catch (e:Exception){
            Log.e("TAG", "HomeScreen  156 --: "+e.message)
        }
    }
}
