package com.fashionhub.venkatasai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fashionhub.venkatasai.app.FashionstoreApps

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FashionstoreApps()
        }
    }
}



