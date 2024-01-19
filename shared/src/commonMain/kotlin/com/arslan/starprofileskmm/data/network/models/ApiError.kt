package com.arslan.starprofileskmm.data.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiError(
    @SerialName("message")
    val message: String?,
    @SerialName("errors")
    val errors: List<Error?>?,
    @SerialName("documentation_url")
    val documentationUrl: String?
) {
    @Serializable
    data class Error(
        @SerialName("resource")
        val resource: String?,
        @SerialName("field")
        val `field`: String?,
        @SerialName("code")
        val code: String?
    )
}