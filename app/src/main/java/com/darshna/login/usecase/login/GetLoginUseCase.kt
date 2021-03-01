package com.darshna.login.usecase.login

import com.darshna.login.di.base.BaseUseCase
import com.darshna.login.models.login.PanLoginResonse
import com.darshna.login.network.PanLoginService
import io.reactivex.Observable
import javax.inject.Inject

class GetLoginUseCase @Inject constructor(
  private val api: PanLoginService
) : BaseUseCase.WithParams<GetLoginUseCase.Params, PanLoginResonse>() {
  override fun onExecute(params: Params): Observable<PanLoginResonse> {
    return api.getLoginDResp(params.pan_number, params.purpose, params.initiator_id, params.purpose_desc,params.customer_mobile)
  }

  data class Params(val pan_number: String, val purpose: String, val initiator_id: String, var purpose_desc: String, var customer_mobile: String)
}