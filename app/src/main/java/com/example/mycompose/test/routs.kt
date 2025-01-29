package com.example.mycompose.test

import kotlinx.serialization.Serializable

sealed class routs {

    @Serializable
    object Login

    @Serializable
    data class Detail (val email :String , val userName :String)

    @Serializable
    data class DashbaordScreen (val email :String , val userName :String)

}