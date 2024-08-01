package com.fashionhub.venkatasai.data.FashionHublogin

sealed class UIEventOfLoginFashionHub{

    data class EmailChanged(val email:String): UIEventOfLoginFashionHub()
    data class PasswordChanged(val password: String) : UIEventOfLoginFashionHub()

    object LoginButtonClicked : UIEventOfLoginFashionHub()
}
