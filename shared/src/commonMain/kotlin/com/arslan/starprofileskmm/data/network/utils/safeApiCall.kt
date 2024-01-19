package com.arslan.starprofileskmm.data.network.utils

import com.arslan.starprofileskmm.data.network.models.ErrorResponseDto
import com.arslan.starprofileskmm.domain.mappers.toDomain
import com.arslan.starprofileskmm.domain.models.ErrorResponse
import com.arslan.starprofileskmm.utils.ResultState
import com.rickclephas.kmp.nativecoroutines.NativeCoroutines
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException

@NativeCoroutines
suspend fun <T : Any?> safeApiCall(apiCall: suspend () -> T): ResultState<T> {
    return try {
        ResultState.Loading

        ResultState.Success(apiCall.invoke())
    } catch (e: RedirectResponseException) {
        val error = parseNetworkError(e.response.body())
        ResultState.Failure(exception = error)
    } catch (e: ClientRequestException) {
        val error = parseNetworkError(e.response.body())
        ResultState.Failure(exception = error)
    } catch (e: ServerResponseException) {
        val error = parseNetworkError(e.response.body())
        ResultState.Failure(exception = error)
    } catch (e: UnresolvedAddressException) {
        val error = parseNetworkError(exception = e)
        ResultState.Failure(exception = error)
    } catch (e: Exception) {
        val error = parseNetworkError(exception = e)
        ResultState.Failure(exception = error)
    }
}

/**Generate [Exception] from network or system error when making network calls
 *
 * @throws [Exception]
 * */
internal suspend fun parseNetworkError(
    errorResponse: HttpResponse? = null,
    exception: Exception? = null
): Exception {
    throw errorResponse?.body<ErrorResponseDto>()?.toDomain() ?: ErrorResponse(
        errorMessage = exception?.message ?: "Something Went Wrong",
        errorCode = "505",
        documentationUrl = "https://docs.github.com/rest"
    )
}