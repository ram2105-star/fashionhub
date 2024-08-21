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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fashionhub.venkatasai.ui.theme.FashionstoreAppTheme

class DetailsPageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FashionstoreAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
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
            //1
            Text(
                text = "£ 430.00",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 281.dp,
                        y = 567.dp))
            Text(
                text = "T-Shirts",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 567.dp))

            Text(
                text = "Comfortable and stylish t-shirts crafted from high-quality fabric, offering a perfect fit for everyday wear. Available in a variety of colors and sizes to suit every preference.",
                color = Color.Black,

//                textDecoration = TextDecoration.Underline,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 601.dp))

            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 226.dp,
                        y = 674.dp)
                    .requiredSize(size = 30.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xff24232b)))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 27.dp,
                        y = 748.dp)
                    .requiredSize(size = 30.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xffe8e8e8)))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 107.dp,
                        y = 748.dp)
                    .requiredSize(size = 30.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xffe8e8e8)))
            //2
            val localContext = LocalContext.current
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 203.dp,
                        y = 738.dp)
                    .requiredWidth(width = 145.dp)
                    .requiredHeight(height = 50.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(color = Color(0xFF48D1D1))
                    .clickable {
                        localContext.startActivity(
                            Intent(localContext, AddtoCartActivity::class.java)
                        )
                    }
            )
            Text(
                text = "Add to Cart",
                color = Color.White,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 231.dp,
                        y = 753.dp))
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FashionstoreAppTheme {
        Greeting("Android")
    }
}