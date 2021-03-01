package com.darshna.login.ui.login

import androidx.lifecycle.MutableLiveData
import com.darshna.login.commonUtility.BaseViewModel
import com.darshna.login.commonUtility.disposedBy
import com.darshna.login.commonUtility.doToggleLoadingStateOf
import com.darshna.login.commonUtility.subscribeWithViewModel
import com.darshna.login.models.login.PanLoginResonse
import com.darshna.login.usecase.login.GetLoginUseCase
import com.darshna.login.utility.Constants
import javax.inject.Inject

class RegistrationLoginViewModel @Inject constructor(
  private val getLoginUseCase: GetLoginUseCase
) : BaseViewModel() {
  val msg = MutableLiveData<String>()

  fun initialize(panNo: String) {
    val params = GetLoginUseCase.Params(
      panNo,
      Constants.PURPOSE_VALUE,
      Constants.INITIATOR_ID_VALUE,
      Constants.PURPOSE_DES_VALUE,
      Constants.CUSTOMER_MOBILE_VALUE
    )

    getLoginUseCase.build(
      params
    )
        .doToggleLoadingStateOf(this)
        .subscribeWithViewModel(this, this::onFetchLoginSuccess, this::onFetchLoginsError)
        .disposedBy(this)
  }

  private fun onFetchLoginSuccess(response: PanLoginResonse) {
    msg.value = response.message
  }

  private fun onFetchLoginsError(t: Throwable) {
    showAlert(t) {
    }
  }

}