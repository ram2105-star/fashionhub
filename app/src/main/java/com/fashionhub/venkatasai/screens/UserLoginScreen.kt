package com.fashionhub.venkatasai.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fashionhub.venkatasai.R
import com.fashionhub.venkatasai.components.ButtonComponent
import com.fashionhub.venkatasai.components.ClickableLoginTextComponent
import com.fashionhub.venkatasai.components.DividerTextComponent
import com.fashionhub.venkatasai.components.HeadingTextComponent
import com.fashionhub.venkatasai.components.MyTextFieldComponent
import com.fashionhub.venkatasai.components.PasswordTextFieldComponent
import com.fashionhub.venkatasai.data.ViewModelOfFashionHub
import com.fashionhub.venkatasai.data.FashionHublogin.UIEventOfLoginFashionHub
import com.fashionhub.venkatasai.navigationDirection.AppRouter
import com.fashionhub.venkatasai.navigationDirection.Screen
import com.fashionhub.venkatasai.navigationDirection.SystemBackButtonHandler


@Composable
fun LoginScreen(loginViewModel: ViewModelOfFashionHub = viewModel()) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {

            Column( modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier.size(350.dp),
                    painter = painterResource(id = R.drawable.hub),
                    contentDescription = null)

                Spacer(modifier = Modifier.height(10.dp))
                HeadingTextComponent(value = "Login")
                Spacer(modifier = Modifier.height(10.dp))

                MyTextFieldComponent(labelValue = stringResource(id = com.fashionhub.venkatasai.R.string.email),
                    painterResource(id = com.fashionhub.venkatasai.R.drawable.message),
                    onTextChanged = { loginViewModel.onEvent(UIEventOfLoginFashionHub.EmailChanged(it)) },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id =com.fashionhub.venkatasai. R.string.password),
                    painterResource(id = com.fashionhub.venkatasai.R.drawable.lock),
                    onTextSelected = {
                        loginViewModel.onEvent(UIEventOfLoginFashionHub.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )

                Spacer(modifier = Modifier.height(10.dp))

                Spacer(modifier = Modifier.height(15.dp))

                ButtonComponent(
                    value = stringResource(id = com.fashionhub.venkatasai.R.string.login),
                    onButtonClicked = {
                       loginViewModel.onEvent(UIEventOfLoginFashionHub.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    AppRouter.navigateTo(Screen.SignUpScreen)
                })
            }
        }

        if(loginViewModel.loginInProgress.value) {
            CircularProgressIndicator()
        }
    }

    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.SignUpScreen)
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

