package com.example.mycompose.model

data class LoginRequest(
    val email: String,
    val password: String
)
data class SignUpRequest(
    val email: String,
    val password: String
)