package com.example.composepractice.network

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T? = null) : ApiResult<T>()
    data class Error(val message: String? = null) : ApiResult<Nothing>()
    object Loading : ApiResult<Nothing>()
    object Empty : ApiResult<Nothing>()
}

//suspend fun <T> safeApiCall(
//    dispatcher: CoroutineDispatcher,
//    apiCall: suspend () -> T
//): Flow<ApiResult<T>> {
//    return withContext(dispatcher) {
//        try {
//            emit(ApiResult.Success(apiCall.invoke()))
//        } catch (e: Throwable) {
//            when (e) {
//                is IOException -> {
//                    ApiResult.Loading
//                }
//
//                is HttpException -> {
//                    ApiResult.Loading
//                }
//
//                else -> {
//                    ApiResult.Error("An error occurred")
//                }
//            }
//        }
//    }
//}