package com.example.mycompose.retrofit

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.State
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




}