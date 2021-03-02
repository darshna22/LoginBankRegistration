package com.darshna.login.commonUtility

sealed class TokenRefreshException : Exception() {

  object IsExpired : TokenRefreshException()
  data class IsApiException(val exception: ApiException) : TokenRefreshException()
  data class IsSystemError(val exception: Exception) : TokenRefreshException()

}
