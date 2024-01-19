package com.arslan.starprofileskmm.domain.models

data class ErrorResponse(
    val errorMessage: String?,
    val errorCode: String?,
    val documentationUrl: String?
) : Exception()