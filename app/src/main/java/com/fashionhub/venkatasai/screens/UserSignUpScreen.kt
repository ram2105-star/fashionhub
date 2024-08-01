package com.fashionhub.venkatasai.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
//import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fashionhub.venkatasai.components.ButtonComponent
import com.fashionhub.venkatasai.components.CheckboxComponent
import com.fashionhub.venkatasai.components.ClickableLoginTextComponent
import com.fashionhub.venkatasai.components.DividerTextComponent
import com.fashionhub.venkatasai.components.HeadingTextComponent
import com.fashionhub.venkatasai.components.MyTextFieldComponent
import com.fashionhub.venkatasai.components.PasswordTextFieldComponent
import com.fashionhub.venkatasai.data.RegisterfashionHub.UserRegistrationEvent
import com.fashionhub.venkatasai.data.RegisterfashionHub.UserRegisterViewModel
import com.fashionhub.venkatasai.navigationDirection.AppRouter
import com.fashionhub.venkatasai.navigationDirection.Screen

//import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SignUpScreen(signupViewModel: UserRegisterViewModel = viewModel()) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center,

    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
                .align(Alignment.Center)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Image(
                    modifier = Modifier.size(250.dp),
                    painter = painterResource(id = com.fashionhub.venkatasai.R.drawable.hub),
                    contentDescription = null)
                  HeadingTextComponent(value = "FashionHub App")
                  Spacer(modifier = Modifier.height(8.dp))
//                HeadingTextComponent(value = "First Name")
//@Composable
//fun HeadingTextComponent(value: String) {
//    Text(
//        text = "First Name",
//        color = Color.Black, // Example color, you can change as needed
//        fontSize = 24.sp, // Adjust the font size here (sp is for scalable pixels)
//        modifier = Modifier
//    )
//}
                  MyTextFieldComponent(
                    labelValue = stringResource(id = com.fashionhub.venkatasai.R.string.first_name),
                    painterResource(id =com.fashionhub.venkatasai. R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(UserRegistrationEvent.FirstNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.firstNameError
                )

                MyTextFieldComponent(
                    labelValue = stringResource(id = com.fashionhub.venkatasai.R.string.last_name),
                    painterResource = painterResource(id =com.fashionhub.venkatasai. R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(UserRegistrationEvent.LastNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.lastNameError
                )

                MyTextFieldComponent(
                    labelValue = stringResource(id =com.fashionhub.venkatasai. R.string.email),
                    painterResource = painterResource(id = com.fashionhub.venkatasai.R.drawable.message),
                    onTextChanged = {
                        signupViewModel.onEvent(UserRegistrationEvent.EmailChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id = com.fashionhub.venkatasai.R.string.password),
                    painterResource = painterResource(id = com.fashionhub.venkatasai.R.drawable.ic_lock),
                    onTextSelected = {
                        signupViewModel.onEvent(UserRegistrationEvent.PasswordChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.passwordError
                )

                CheckboxComponent(value = stringResource(id = com.fashionhub.venkatasai.R.string.terms_and_conditions),
                    onTextSelected = {
                        AppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                    },
                    onCheckedChange = {
                        signupViewModel.onEvent(UserRegistrationEvent.PrivacyPolicyCheckBoxClicked(it))
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ButtonComponent(
                    value = stringResource(id =com.fashionhub.venkatasai. R.string.register),
                    onButtonClicked = {
                        signupViewModel.onEvent(UserRegistrationEvent.RegisterButtonClicked)
                    },
                    isEnabled = signupViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(10.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                    AppRouter.navigateTo(Screen.LoginScreen)
                })
            }
        }


        if(signupViewModel.signUpInProgress.value) {
            CircularProgressIndicator()
        }
    }

}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}