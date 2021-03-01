package com.darshna.login.network

import com.darshna.login.models.login.PanLoginResonse
import io.reactivex.Observable
import retrofit2.http.*

interface PanLoginService {
  @Headers("developer_key: becbbce45f79c6f5109f848acd540567",
  "secret-key: MC6dKW278tBef+AuqL/5rW2K3WgOegF0ZHLW/FriZQw=",
  "secret-key-timestamp: 1516705204593",
  "Content-Type: application/x-www-form-urlencoded")
  @FormUrlEncoded
  @POST("pan/verify/")
  fun getLoginDResp(
    @Field("pan_number") pan_number: String, @Field("purpose") purpose: String,
    @Field("initiator_id") initiator_id: String, @Field("purpose_desc") purpose_desc: String,
    @Field("customer_mobile") customer_mobile: String
  ): Observable<PanLoginResonse>
}