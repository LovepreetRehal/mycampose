package com.example.mycompose.model

data class LoginResponse(

    val `data`: LoginData,
    val message: String,
    val status: Boolean,
    val statusCode: Int
)

data class LoginData(
    val is_blocked: Boolean,
    val token: String,
    val user: LoginUser
)

data class LoginUser(
    val apple_id: Any,
    val branch_id: Any,
    val created_at: String,
    val device_token: Any,
    val device_type: Any,
    val email: String,
    val email_verified_at: Any,
    val id: Int,
    val image: Any,
    val last_login_at: Any,
    val last_login_ip: Any,
    val name: String,
    val path: Any,
    val role_id: Int,
    val social_id: Any,
    val status: Int,
    val submit_offer: Any,
    val telephone: Any,
    val updated_at: String
)



