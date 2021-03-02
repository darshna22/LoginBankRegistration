package com.darshna.login.commonUtility

data class AuthorizationToken(
  val accessToken: String,
  val refreshToken: String?,
  val tokenType: String,
  val scope: NextScope
)
