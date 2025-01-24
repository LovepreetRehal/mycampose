package com.example.mycompose.retrofit

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.State
import com.example.mycompose.model.LoginRequest
import com.example.mycompose.model.LoginResponse
import com.example.mycompose.model.SignUpRequest
import com.example.mycompose.model.SignUpResponce
import kotlinx.coroutines.launch

class PropertyDetailViewModel : ViewModel() {
    private val _propertyDetails = mutableStateOf<PropertyDetailsResponse?>(null)
    val propertyDetails: State<PropertyDetailsResponse?> = _propertyDetails

    fun fetchPropertyDetails(id:String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPropertyDetails(id)
                _propertyDetails.value = response
                Log.e("TAG_Detail", "fetchPropertyDetails : $response")
            } catch (e: Exception) {
                Log.e("TAG_Detail", "fetchPropertyDetails : "+e.message)
                // Handle error
            }
        }
    }



    private val _getProperty = mutableStateOf<PropertyListResponse?>(null)
    val propertyList: State<PropertyListResponse?> = _getProperty

    fun getPropertyList() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getProperty()
                _getProperty.value = response
                Log.e("TAG_Detail", "fetchPropertyDetails : $response")
            } catch (e: Exception) {
                Log.e("TAG_Detail", "fetchPropertyDetails : "+e.message)
                // Handle error
            }
        }
    }

    // Perform login API call
    // State to store login response
    private val _loginResponse = mutableStateOf<LoginResponse?>(null)
    val loginResponse: State<LoginResponse?> = _loginResponse
    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(email, password)
                val response = RetrofitInstance.api.login(loginRequest)

                if (response.isSuccessful) {
                    _loginResponse.value = response.body()
                    Log.e("TAG_Login", "login successful: ${response.body()}")
                } else {
                    Log.e("TAG_Login", "login failed: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("TAG_Login", "login error: ${e.message}")
                // Handle error
            }
        }
    }

    // Perform login API call
    // State to store login response
    private val _signUpResponse = mutableStateOf<SignUpResponce?>(null)
    val signUpResponse: State<SignUpResponce?> = _signUpResponse
    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            try {
                val signUpRequest = SignUpRequest(email, password)
                val response = RetrofitInstance.api.signup(signUpRequest)

                if (response.isSuccessful) {
                    _signUpResponse.value = response.body()
                    Log.e("TAG_Login", "_signUpResponse successful: ${response.body()}")
                } else {
                    Log.e("TAG_Login", "_signUpResponse failed: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("TAG_Login", "_signUpResponse error: ${e.message}")
                // Handle error
            }
        }
    }



}