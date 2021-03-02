package com.darshna.login.commonUtility

import io.reactivex.disposables.CompositeDisposable

interface Disposer {
  val disposeBag: CompositeDisposable
}
