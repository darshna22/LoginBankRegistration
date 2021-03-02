package com.darshna.login.commonUtility.serviceavailability

import com.darshna.login.commonUtility.BaseActivity
import com.darshna.login.commonUtility.BaseFragment
import com.darshna.login.commonUtility.BaseViewModel

/**
 * Checks the service availability of [code] before executing [onAvailable].
 */
fun BaseViewModel.checkService(
  code: String,
  onUnavailable: (() -> Unit)? = null,
  onAvailable: () -> Unit
) {
  if (ServiceAvailability.isAvailable(code)) {
    onAvailable.invoke()
    return
  }

  if (onUnavailable != null) {
    onUnavailable.invoke()
    return
  }

  ServiceAvailability.getStatus(code)?.let {
    val event = ServiceUnavailableEvent.FromServiceAvailability(code, it)
    emitServiceUnavailableEvent(event)
  }
}

/**
 * Checks the service availability of [code] before executing [onAvailable].
 */
fun BaseFragment.checkService(
  code: String,
  onUnavailable: (() -> Unit)? = null,
  onAvailable: () -> Unit
) {
  if (ServiceAvailability.isAvailable(code)) {
    onAvailable.invoke()
    return
  }

  if (onUnavailable != null) {
    onUnavailable.invoke()
    return
  }

  ServiceAvailability.getStatus(code)?.let {
    val event = ServiceUnavailableEvent.FromServiceAvailability(code, it)
    (activity as? BaseActivity)?.onServiceUnavailable(event)
  }
}
