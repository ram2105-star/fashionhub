package com.fashionhub.venkatasai

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fashionhub.venkatasai.components.HeadingTextComponent
import com.fashionhub.venkatasai.ui.theme.Primary


class ConfirmationActivity : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val context = LocalContext.current
            val gradient45 = Brush.linearGradient(
                colors = listOf(Color.White, Color.White),
                start = Offset(0f, Float.POSITIVE_INFINITY),
                end = Offset(Float.POSITIVE_INFINITY, 0f)
            )

            Surface(
                modifier = Modifier
                    .background(gradient45)
                    .fillMaxSize()
                    .padding(28.dp)

//                        .background(Color.LightGray)
                    .background(  color = Color(0x3148D1D1))

                    .padding(28.dp)
                //.align(Alignment.Center)
            ) {


                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(gradient45),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
//                        HeadingTextComponent(value = "Order Placed Successfully Completed")
                    Spacer(modifier = Modifier.height(35.dp))
                    Image(painter = painterResource(id = R.drawable.so),contentDescription = null)
                    HeadingTextComponent(value = "Order Placed Successfully Completed")
                    Spacer(modifier = Modifier.height(95.dp))

                    val fashion = ""

                    Button(
                        modifier = Modifier
                            .wrapContentWidth()
                            .heightIn(48.dp),
                        onClick = {
                            context.startActivity(Intent(context, MainActivity::class.java)
                                .putExtra("Fashion", fashion))
                        },
                        contentPadding = PaddingValues(),
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        shape = RoundedCornerShape(50.dp),

                        )

                    {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(68.dp)
                                .background(
                                    brush = Brush.horizontalGradient(listOf(Primary, Primary)),
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Back to Home",
                                fontSize = 18.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                        }

                    }
                }
            }
        }
    }






}

