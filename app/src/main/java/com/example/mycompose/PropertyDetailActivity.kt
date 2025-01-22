package com.example.mycompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycompose.retrofit.PropertyDetailViewModel
import com.example.mycompose.ui.theme.MyComposeTheme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.size.Scale

class PropertyDetailActivity : ComponentActivity() {

    var propertyId = ""
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        propertyId = intent.getStringExtra("propertyId").toString()

        setContent {
            MyComposeTheme {
                Scaffold(

                    topBar = {
                        // AppBar
                        TopAppBar(
                            title = {
                                Text(text = "Property Details") // AppBar title
                            },
                            navigationIcon = {
                                IconButton(onClick = { /* Handle back action */ }) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack, // Use back icon
                                        contentDescription = "Back"
                                    )
                                }
                            }
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Greeting(propertyId,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                }
            }
        }
    }


@Composable
fun Greeting(propertyId: String, modifier: Modifier = Modifier) {

    val viewModel: PropertyDetailViewModel = viewModel() // Get the ViewModel instance
    val propertyDetails = viewModel.propertyDetails.value

    // Call the API when the screen is composed
    LaunchedEffect(Unit) {
        Log.e("TAG_Detail", "propertyId  104  : $propertyId")
        viewModel.fetchPropertyDetails(propertyId)
    }

    if (propertyDetails == null) {
//        Text(text = "Loading...", modifier = Modifier.ali.align(Alignment.CenterHorizontally))
        Log.e("TAG_Detail", "Greeting  110  : $propertyDetails")
    } else {
//        Text(text = "Loading...", modifier = Modifier.align(Alignment.CenterHorizontally))
        Log.e("TAG_Detail", "Greeting: $propertyDetails")

    }
    Column(
        modifier = Modifier
            .padding(all = 16.dp)
            .verticalScroll(rememberScrollState()) // Add vertical scroll

//            .clickable {
//                // Navigate to PropertyDetailActivity
//                val intent = Intent(context, PropertyDetailActivity::class.java).apply {
//                    putExtra("propertyName", items[index])
//                }
//                context.startActivity(intent)
//            }
    ) {
        Image(
            painter = painterResource(id = R.mipmap.img_property),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(12.dp))

        Row (modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = propertyDetails?.data?.name ?: "",
                modifier = Modifier.alignByBaseline() // Aligns the first Text properly
            )

            Text(text = "Rs "+propertyDetails?.data?.price ?: "" ,
              modifier = Modifier.alignByBaseline() // Aligns the second Text properly

            )

        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.mipmap.icon_rating),
                contentDescription = "rating",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp)) // Add horizontal gap between image and text
            Text(
                text = propertyDetails?.data?.rating_count.toString() ?: "",
                style = TextStyle(fontSize = 16.sp, color = Color.Black)
            )
        }

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
            Spacer(modifier = Modifier.width(4.dp)) // Add horizontal gap between image and text
            Text(
                text =  propertyDetails?.data?.user?.address ?: "",
                style = TextStyle(fontSize = 16.sp, color = Color.Black)
            )
        }
        Spacer(modifier = Modifier.height(14.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray, shape = RoundedCornerShape(12.dp))
                .padding(8.dp) // Inner padding inside the border
        )  {
            Image(
                painter =
                rememberImagePainter(
                    data =  "https://rent.nightclubpool.com/storage/"+propertyDetails?.data?.user?.image, // Your image URL here
//                    data =  "https://rent.nightclubpool.com/storage/"+propertyDetails?.data?.user?.image, // Your image URL here
                    builder = {
                        crossfade(true) // Enable crossfade effect while loading the image
                        scale(Scale.FILL) // Optionally control how the image scales
                    }
                ),
//                painterResource(id = R.mipmap.img_property),
                contentDescription = "Image",
                modifier = Modifier
                    .size(40.dp) // Sets the size of the circle
                    .clip(CircleShape) // Clips the image to a circular shape
                    .border(2.dp, Color.Gray, CircleShape) // Optional: Adds a border to the circle
            )
            Spacer(modifier = Modifier.width(14.dp)) // Add horizontal gap between image and text

            Text(
                text =  propertyDetails?.data?.user?.name ?: "",
                style = TextStyle(fontSize = 16.sp, color = Color.Black)
            )
        }
        Spacer(modifier = Modifier.height(14.dp))
        Log.e("TAG_IMAGEURL", "Greeting  :216  --> "+"https://rent.nightclubpool.com/storage"+propertyDetails?.data?.user?.image)
        AsyncImage(
            model = "https://rent.nightclubpool.com/storage"+propertyDetails?.data?.user?.image,
            placeholder = painterResource(id = R.mipmap.img_property),
            error = painterResource(id = R.mipmap.img_property),
            contentDescription = "The delasign logo",
            modifier = Modifier
                .size(50.dp) // Set the size of the image (50x50)
                .clip(CircleShape) // Clip the image into a circular shape
        )
        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text =  propertyDetails?.data?.add_info ?: "",
            style = TextStyle(fontSize = 14.sp, color = Color.Black)
        )
        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Reserve now for your luxury year round gathering at IBB Beach Mansion, possibly the largest house available for rent on the Oregon Coast with incredible panoramic ocean views from every room and a 200 sq ft deck.",
            style = TextStyle(fontSize = 14.sp, color = Color.Black)
        )
        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Reserve now for your luxury year round gathering at IBB Beach Mansion, possibly the largest house available for rent on the Oregon Coast with incredible panoramic ocean views from every room and a 200 sq ft deck.",
            style = TextStyle(fontSize = 14.sp, color = Color.Black)
        )
        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Reserve now for your luxury year round gathering at IBB Beach Mansion, possibly the largest house available for rent on the Oregon Coast with incredible panoramic ocean views from every room and a 200 sq ft deck.",
            style = TextStyle(fontSize = 14.sp, color = Color.Black)
        )
        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Reserve now for your luxury year round gathering at IBB Beach Mansion, possibly the largest house available for rent on the Oregon Coast with incredible panoramic ocean views from every room and a 200 sq ft deck.",
            style = TextStyle(fontSize = 14.sp, color = Color.Black)
        )
        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Reserve now for your luxury year round gathering at IBB Beach Mansion, possibly the largest house available for rent on the Oregon Coast with incredible panoramic ocean views from every room and a 200 sq ft deck.",
            style = TextStyle(fontSize = 14.sp, color = Color.Black)
        )
        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Reserve now for your luxury year round gathering at IBB Beach Mansion, possibly the largest house available for rent on the Oregon Coast with incredible panoramic ocean views from every room and a 200 sq ft deck.",
            style = TextStyle(fontSize = 14.sp, color = Color.Black)
        )
        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Reserve now for your luxury year round gathering at IBB Beach Mansion, possibly the largest house available for rent on the Oregon Coast with incredible panoramic ocean views from every room and a 200 sq ft deck.",
            style = TextStyle(fontSize = 14.sp, color = Color.Black)
        )
    }
}
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview2() {
//    MyComposeTheme {
//        Greeting(propertyId)
//    }
//}