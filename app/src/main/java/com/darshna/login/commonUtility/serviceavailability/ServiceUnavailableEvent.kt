package com.darshna.login.commonUtility.serviceavailability

import com.darshna.login.commonUtility.ApiError

sealed class ServiceUnavailableEvent {

  /**
   * Represents a [ServiceUnavailableEvent] as a result of checking against
   * the service availability list.
   */
  data class FromServiceAvailability(
    val serviceCode: String,
    val status: ServiceStatus
  ) : ServiceUnavailableEvent()

  /**
   * Represents a [ServiceUnavailableEvent] as a result of an API response.
   */
  data class FromApiResponse(
    val error: ApiError
  ) : ServiceUnavailableEvent()

}
