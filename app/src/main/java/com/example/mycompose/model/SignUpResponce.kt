package com.example.mycompose.model

data class SignUpResponce(
    val `data`: RegisterData, val message: String, val status: Boolean, val statusCode: Int
)

data class RegisterData(
    val is_blocked: Boolean, val token: String, val user: RegisterDataUser
)

data class RegisterDataUser(
    val created_at: String,
    val device_token: Any,
    val email: String,
    val id: Int,
    val name: String,
    val role_id: Int,
    val telephone: String,
    val updated_at: String
)