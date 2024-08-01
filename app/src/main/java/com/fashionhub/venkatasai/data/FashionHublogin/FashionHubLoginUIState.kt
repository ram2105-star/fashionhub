package com.fashionhub.venkatasai.data

data class FashionHubLoginUIState(
    var email  :String = "",
    var password  :String = "",

    var emailError :Boolean = false,
    var passwordError : Boolean = false

)
