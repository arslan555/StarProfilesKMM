package com.arslan.starprofileskmm.domain.repository

import com.arslan.starprofileskmm.domain.models.StarRepo
import com.arslan.starprofileskmm.utils.ResultState
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import kotlinx.coroutines.flow.Flow

interface StarReposRepository {
    @NativeCoroutines
    suspend fun fetchStarRepos(language: String) : Flow<ResultState<List<StarRepo>?>>
}
