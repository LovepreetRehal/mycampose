package com.example.mycompose.retrofit



data class PropertyListResponse(
    val `data`: AllPropertiesData,
    val message: String,
    val status: Boolean,
    val statusCode: Int
)

data class AllPropertiesData(
    val properties: Properties
)

data class Properties(
    val current_page: Any,
    val `data`: ArrayList<AllProperties>,
    val first_page_url: String,
    val from: Any,
    val last_page: Any,
    val last_page_url: Any,
    val links: ArrayList<AllPropertyLink>,
    val next_page_url: Any,
    val path: Any,
    val per_page: Any,
    val prev_page_url: Any,
    val to: Any,
    val total: Any
)

data class AllProperties(
    val add_info: String?="",
    val agent_notes: Any?="",
    val archived_at: Any?="",
    val area: Int?=0,
    val baths: String?="",
    val beds: String?="",
    val branch_id: Any?=0,
    val city: String?="",
    val client_valuation_id: Any?="",
    val complex_name: String?="",
    val country: String?="",
    val created_at: String?="",
    val description: String?="",
    val development_id: Any?=0,
    val feed_id: Any?=0,
    val `file`: Any?="",
    val from_date: String?="",
    val guest: String?="",
    val id: Int?=0,
    val internal_area: Any?="",
    val internal_area_unit: Any?="",
    val is_development: String?="",
    val is_featured: Any?="",
    val is_rental: Int?=0,
    val is_shortlist: Boolean?=false,
    val land_area: Any?="",
    val land_area_unit: Any?="",
    val latitude: String?="",
    val longitude: String?="",
    val name: String?="",
    val address: String?="",
    val pb_id: Any?="",
    val postcode: String?="",
    val price: Int?=0,
    val price_qualifier: String?="",
    val property_media_photos: ArrayList<PropertyMediaPhoto>,
    val property_status: Any?="",
    val property_type_id: Int?=0,
    val propertybase_fields: Any?="",
    val ref: Any?="",
    val region: String?="",
    val rent_period: Any?="",
    val status: String?="",
    val street: String?="",
    val to_date: String?="",
    val town: String?="",
    val updated_at: String?="",
    val user_id: Int?=0,
    val youtube_id: Any?="",
    var rating_count : String? = "",
)

data class AllPropertyLink(
    val active: Boolean,
    val label: String?="",
    val url: String?=""
)

data class PropertyMediaPhoto(
    val created_at: String?="",
    val extension: String?="",
    val id: Int?=0,
    val orientation: Any?="",
    val path: String?="",
    val property_id: Int?=0,
    val sequence: Any?="",
    val title: Any?="",
    val type: String?="",
    val updated_at: String?=""
)
