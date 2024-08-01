package  com.fashionhub.venkatasai.data.RegisterfashionHub

sealed class UserRegistrationEvent{

    data class FirstNameChanged(val firstName:String) : UserRegistrationEvent()
    data class LastNameChanged(val lastName:String) : UserRegistrationEvent()
    data class EmailChanged(val email:String): UserRegistrationEvent()
    data class PasswordChanged(val password: String) : UserRegistrationEvent()

    data class PrivacyPolicyCheckBoxClicked(val status:Boolean) : UserRegistrationEvent()

    object RegisterButtonClicked : UserRegistrationEvent()
}
