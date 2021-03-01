package com.darshna.login.models.login

data class PanLoginResonse(
    val `data`: Data,
    val message: String,
    val response_status_id: Int,
    val response_type_id: Int,
    val status: Int
)