package com.example.mycompose.retrofit



data class PropertyDetailsResponse(
    val `data`: PropDetailData, val message: String, val status: Boolean, val statusCode: Int
)

data class PropDetailData(
    val access_information: String,
    val add_info: String,
    val address: String,
    val agent_notes: Any,
    val archived_at: Any,
    val area: Any,
    val baths: Int,
    val beds: Int,
    val child: String,
    val city: String,
    val complex_name: String,
    val country: String,
    val created_at: String,
    val deleted_at: Any,
    val description: String,
    val `file`: Any,
    val from_date: String,
    val guest: String,
    val house_rules: String,
    val id: Int,
    val internal_area: Any,
    val is_featured: Any,
    val is_rental: Any,
    val is_shortlist: Boolean,
    val latitude: String,
    val longitude: String,
    val name: String,
    val pets: Any,
    val postcode: String,
    val price: Int,
    val price_qualifier: String,
    val property_media_photos: List<PropertyMediaPhoto>,
    val property_status: Any,
    val property_type_id: Int,
    val property_type_name: String,
    val rating_count: Any,
    val ref: Any,
    val region: String,
    val review_count: Int,
    val status: String,
    val street: String,
    val to_date: String,
    val town: String,
    val type: Type,
    val updated_at: String,
    val user: User,
    val user_id: Int
)

data class Type(
    val created_at: String,
    val id: Int,
    val name: String,
    val rightmove_number: Int,
    val slug: String,
    val zoopla_type: Any
)

data class User(
    val address: String,
    val apple_id: Any,
    val branch_id: Any,
    val created_at: String,
    val device_token: Any,
    val device_type: Any,
    val document: String,
    val email: String,
    val email_verified_at: Any,
    val flat: String,
    val government_type: String,
    val id: Int,
    val image: String,
    val last_login_at: String,
    val last_login_ip: String,
    val name: String,
    val path: String,
    val postalcode: String,
    val role_id: Int,
    val social_id: String,
    val status: Int,
    val street: String,
    val stripe_customer_id: String,
    val submit_offer: Any,
    val telephone: String,
    val updated_at: String
)
