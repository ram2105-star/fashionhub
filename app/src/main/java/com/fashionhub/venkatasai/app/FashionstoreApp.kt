package com.fashionhub.venkatasai.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fashionhub.venkatasai.data.FashionHubhome.FashiomHubViewModel
import com.fashionhub.venkatasai.navigationDirection.AppRouter
import com.fashionhub.venkatasai.navigationDirection.Screen
import com.fashionhub.venkatasai.screens.HomeScreen
import com.fashionhub.venkatasai.screens.LoginScreen
import com.fashionhub.venkatasai.screens.SignUpScreen
import com.fashionhub.venkatasai.screens.TermsAndConditionsScreen


@Composable
fun FashionstoreApps(homeViewModel: FashiomHubViewModel = viewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {

        if (homeViewModel.isUserLoggedIn.value == true) {
            AppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = AppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }
            }
        }

    }
}