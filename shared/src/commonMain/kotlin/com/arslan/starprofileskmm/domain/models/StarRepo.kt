package com.arslan.starprofileskmm.domain.models

data class StarRepo(
    val id: Int? = -1,
    val name: String? = null,
    val fullName: String? = null,
    val description: String? = null,
    val starsCount: Int? = 0,
    val language: String? = null,
    val owner: Owner? = null
) {
    data class Owner(
        val id: Int? = -1,
        val avatarUrl: String? = null,
        val htmlUrl: String? = null

    )
}
