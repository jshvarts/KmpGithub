package com.jshvarts.kmp.shared.presentation

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class CoroutinePresenter(
  private val presenterContext: CoroutineContext,
  private val view: BaseView
) : CoroutineScope {

  private val job = Job()
  private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    view.showError(throwable)
  }

  override val coroutineContext: CoroutineContext
    get() = presenterContext + exceptionHandler

  abstract fun onCreate()

  open fun onDestroy() {
    job.cancel()
  }
}
