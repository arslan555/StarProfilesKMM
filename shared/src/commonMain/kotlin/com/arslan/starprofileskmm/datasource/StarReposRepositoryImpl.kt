package com.arslan.starprofileskmm.datasource

import com.arslan.starprofileskmm.data.network.models.StarReposDto
import com.arslan.starprofileskmm.data.network.utils.safeApiCall
import com.arslan.starprofileskmm.domain.mappers.toDomain
import com.arslan.starprofileskmm.domain.models.StarRepo
import com.arslan.starprofileskmm.domain.repository.StarReposRepository
import com.arslan.starprofileskmm.utils.ResultState
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class StarReposRepositoryImpl constructor(
    private val httpClient: HttpClient
) : StarReposRepository {
    override suspend fun fetchStarRepos(language: String): Flow<ResultState<List<StarRepo?>?>> {
        return flowOf(
            safeApiCall {
                val response = httpClient.get(urlString = "search/repositories") {
                    parameter("q", language)
                }.body<StarReposDto>()
                response.items?.map { it?.toDomain()
                }
            }
        )
    }

}
