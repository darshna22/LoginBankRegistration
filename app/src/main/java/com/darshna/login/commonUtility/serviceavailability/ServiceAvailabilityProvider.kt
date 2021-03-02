package com.darshna.login.commonUtility.serviceavailability

interface ServiceAvailabilityProvider {

  fun getServiceStatus(code: String): ServiceStatus?

}
