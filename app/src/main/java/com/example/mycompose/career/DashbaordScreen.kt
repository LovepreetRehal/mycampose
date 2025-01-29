package com.example.mycompose.career

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycompose.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashbaordScreen() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = "Hello, john!", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Image(
                painter = painterResource(id = R.drawable.icon_notification),
                contentDescription = null,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(horizontal = 20.dp, vertical = 10.dp) // Margin
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF17BDC8), Color(0xFF13CDDA)), // Gradient colors
                        start = Offset(0f, 0f),
                        end = Offset(1000f, 1000f) // Adjust gradient angle
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {


            Row(
                modifier = Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    // Title
                    Text(
                        text = "Find Your Child’s Perfect\nCareer Path", // Replace with string resource
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.general_bold)), // Use your font
                        color = Color.Black,
                        lineHeight = 22.sp
                    )

                    // Description
                    Text(
                        text = "Answer a few quick questions to discover careers that align with your child’s interests and strengths.", // Replace with string resource
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.general_regular)),
                        color = Color.Black,
                        lineHeight = 18.sp,
                        maxLines = 3,
                        modifier = Modifier.width(260.dp)
                    )


                }

                // Image + Button
                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    // Main Image
                    Image(
                        painter = painterResource(id = R.mipmap.icon_businessman),
                        contentDescription = "Businessman Icon",
                        modifier = Modifier
                            .size(100.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    // Small Button with Arrow
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.mipmap.icon_arrow_right),
                            contentDescription = "Arrow Icon",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }


        }

        Text(
            text = "Career options",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp)
        )


        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 10.dp) // Margin
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color.White, Color.White), // Gradient colors
                        start = Offset(0f, 0f),
                        end = Offset(1000f, 1000f) // Adjust gradient angle
                    ),
                    shape = RoundedCornerShape(26.dp)
                )
        ) {
            Row(
                modifier = Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Image + Button
                Column(
                ) {
                    // Main Image
                    Image(
                        painter = painterResource(id = R.mipmap.icon_businessman),
                        contentDescription = "Businessman Icon",
                        modifier = Modifier
                            .size(40.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))


                }
                Column(
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    // Title
                    Text(
                        text = "Agriculture", // Replace with string resource
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.general_bold)), // Use your font
                        color = Color.Black,
                        lineHeight = 22.sp,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .border(
                                2.dp,
                                Color(0xFF17BDC8),
                                shape = RoundedCornerShape(16.dp)
                            ) // Outline
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(0x1A17BDC8),
                                        Color(0x1A17BDC8)
                                    ), // Gradient colors
                                    start = Offset(0f, 0f),
                                    end = Offset(1000f, 1000f) // Adjust gradient angle
                                ),
                                shape = RoundedCornerShape(16.dp) // Apply rounded corners to background
                            )
                    ) {
                        Text(
                            text = "View",
                            fontSize = 18.sp,
                            color = Color(0xFF17BDC8),
                            modifier = Modifier
                                .padding(
                                    start = 16.dp,
                                    end = 16.dp,
                                    top = 4.dp,
                                    bottom = 4.dp
                                ) // Inner padding for text
                        )
                    }


                }


            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp) // Margin
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color.White, Color.White), // Gradient colors
                        start = Offset(0f, 0f),
                        end = Offset(1000f, 1000f) // Adjust gradient angle
                    ),
                    shape = RoundedCornerShape(26.dp)
                )
        ) {
            Row(
                modifier = Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Image + Button
                Column(
                ) {
                    // Main Image
                    Image(
                        painter = painterResource(id = R.mipmap.icon_businessman),
                        contentDescription = "Businessman Icon",
                        modifier = Modifier
                            .size(40.dp)
                    )

                    Spacer(modifier = Modifier.width(16.dp))


                }
                Column(
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    // Title
                    Text(
                        text = "Agriculture", // Replace with string resource
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.general_bold)), // Use your font
                        color = Color.Black,
                        lineHeight = 22.sp,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    // Description
                    Text(
                        text = "Answer a few quick questions to discover careers that align with your child’s interests and strengths.", // Replace with string resource
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.general_regular)),
                        color = Color.Black,
                        lineHeight = 18.sp,
                        maxLines = 3,
                        modifier = Modifier.width(260.dp)
                            .padding(start = 16.dp)

                    )

                    Box(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .align(Alignment.End)
                            .border(
                                2.dp,
                                Color(0xFF17BDC8),
                                shape = RoundedCornerShape(16.dp)
                            ) // Outline
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(0x1A17BDC8),
                                        Color(0x1A17BDC8)
                                    ), // Gradient colors
                                    start = Offset(0f, 0f),
                                    end = Offset(1000f, 1000f) // Adjust gradient angle
                                ),

                                shape = RoundedCornerShape(16.dp) // Apply rounded corners to background
                            )
                    ) {
                        Text(
                            text = "➜",
                            fontSize = 18.sp,
                            color = Color(0xFF17BDC8),
                            modifier = Modifier
                                .padding(
                                    start = 16.dp,
                                    end = 16.dp,
                                    top = 4.dp,
                                    bottom = 6.dp
                                ) // Inner padding for text
                        )
                    }


                }


            }
        }
    }

}

