package com.darshna.login.commonUtility

class InsufficientScopeException(val requiredScope: NextScope) : RuntimeException()
