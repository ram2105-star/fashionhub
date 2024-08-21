package com.fashionhub.venkatasai

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fashionhub.venkatasai.ui.theme.FashionstoreAppTheme

import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign

class AddtoCartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FashionstoreAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    //cart
    Box(
        modifier = modifier
            .requiredWidth(width = 360.dp)
            .requiredHeight(height = 640.dp)
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = (-7).dp,
                    y = (-86).dp)
                .requiredWidth(width = 375.dp)
                .requiredHeight(height = 812.dp)
                .background(color = Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "arrow-left",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 35.dp)
                    .requiredSize(size = 24.dp))
            Image(
                painter = painterResource(id = R.drawable.rec),
                contentDescription = "",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp,
                        y = 468.dp)
                    .requiredWidth(width = 415.dp)
                    .requiredHeight(height = 463.dp))


            Text(
                text = "£ 900.00",
                color = Color(0xFF48D1D1),
                textAlign = TextAlign.End,
                style = TextStyle(
                    fontSize = 30.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 241.dp,
                        y = 671.dp))
            Text(
                text = "£ 60.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 295.dp,
                        y = 621.dp))
            Text(
                text = "£ 840.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 280.dp,
                        y = 581.dp))


            Text(
                text = " Total Amount",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 681.dp))
            Text(
                text = "Shipping",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 625.dp))
            Text(
                text = "Sub Total",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 585.dp))



            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 124.dp,
                        y = 284.dp)
                    .requiredSize(size = 30.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xffe8e8e8)))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 124.dp,
                        y = 166.dp)
                    .requiredSize(size = 30.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xffe8e8e8)))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 318.dp,
                        y = 229.dp)
                    .requiredSize(size = 30.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xff24232b)))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 318.dp,
                        y = 111.dp)
                    .requiredSize(size = 30.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xff24232b)))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 204.dp,
                        y = 284.dp)
                    .requiredSize(size = 30.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xffe8e8e8)))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 204.dp,
                        y = 166.dp)
                    .requiredSize(size = 30.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xffe8e8e8)))
            Text(
                text = "+",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 135.dp,
                        y = 290.dp))
            Text(
                text = "+",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 135.dp,
                        y = 172.dp))
            Text(
                text = "1",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 177.dp,
                        y = 287.dp))
            Text(
                text = "1",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 177.dp,
                        y = 169.dp))
            Text(
                text = "M",
                color = Color.White,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 327.dp,
                        y = 235.dp))

            Text(
                text = "S",
                color = Color.White,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 329.dp,
                        y = 117.dp))
            Text(
                text = "-",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 216.dp,
                        y = 290.dp))
            Text(
                text = "-",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 216.dp,
                        y = 172.dp))


            val context = LocalContext.current
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 738.dp)
                    .requiredWidth(width = 321.dp)
                    .requiredHeight(height = 50.dp)
                    .clickable {
                        context.startActivity(
                            Intent(context, PaymentActivity::class.java))
                    }

                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(color = Color(0xFF48D1D1)))
            Text(
                text = "Proceed to Checkout",
                color = Color.White,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 108.dp,
                        y = 753.dp))
            Image(
                painter = painterResource(id = R.drawable.shirt),
                contentDescription = "",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 7.dp,
                        y = 229.dp)
                    .requiredWidth(width = 102.dp)
                    .requiredHeight(height = 105.dp)
                    .clip(shape = RoundedCornerShape(15.dp)))
            Image(
                painter = painterResource(id = R.drawable.saree),
                contentDescription = "",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 7.dp,
                        y = 104.dp)
                    .requiredWidth(width = 100.dp)
                    .requiredHeight(height = 104.dp)
                    .clip(shape = RoundedCornerShape(24.dp)))
            Text(
                text = "Shirt & pants",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 124.dp,
                        y = 229.dp))

            Text(
                text = "Sarees",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 124.dp,
                        y = 111.dp))
            Text(

                text = "£ 410.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 124.dp,
                        y = 254.dp))
            Text(
                text = "£ 430.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 124.dp,
                        y = 136.dp))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 429.dp)
                    .requiredWidth(width = 321.dp)
                    .requiredHeight(height = 50.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(color = Color(0xffe8e8e8)))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 258.dp,
                        y = 434.dp)
                    .requiredWidth(width = 85.dp)
                    .requiredHeight(height = 40.dp)
                    .clip(shape = RoundedCornerShape(11.dp))
                    .background(color = Color(0xff535758)))
            Text(
                text = "Apply",
                color = Color.White,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 279.dp,
                        y = 444.dp))
            Text(
                text = "Promo Code",
                color = Color.Black.copy(alpha = 0.2f),
                style = TextStyle(
                    fontSize = 14.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 46.dp,
                        y = 445.dp)
                    .requiredWidth(width = 86.dp))

            Divider(
                color = Color.Black.copy(alpha = 0.4f),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 383.99997186660767.dp)
                    .requiredWidth(width = 321.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    FashionstoreAppTheme {
        Greeting2("Android")
    }
}