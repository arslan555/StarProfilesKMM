package com.arslan.starprofileskmm.domain.mappers

import com.arslan.starprofileskmm.data.network.models.ErrorResponseDto
import com.arslan.starprofileskmm.data.network.models.StarReposDto
import com.arslan.starprofileskmm.domain.models.ErrorResponse
import com.arslan.starprofileskmm.domain.models.StarRepo


fun ErrorResponseDto.toDomain(): ErrorResponse =
     ErrorResponse(
        errorMessage = this.message,
        documentationUrl = this.documentationUrl,
        errorCode = this.errors?.get(0)?.code
    )

fun StarReposDto.Repo.toDomain()  =
    StarRepo(
        id = id,
        name = name,
        fullName = fullName,
        description = description,
        starsCount = stargazersCount,
        language = language,
        StarRepo.Owner(
            id = owner?.id,
            avatarUrl = owner?.avatarUrl,
            htmlUrl = owner?.htmlUrl
        )
    )
