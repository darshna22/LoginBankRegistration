package com.darshna.login.commonUtility

interface PrivilegeEscalationHandler {

  /**
   * Request for a privilege escalation using [request].
   */
  fun requestPrivilege(request: PrivilegeEscalationRequest)

}
