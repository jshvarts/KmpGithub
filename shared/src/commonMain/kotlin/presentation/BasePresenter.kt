package com.jshvarts.kmp.shared.presentation

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter(
  private val presenterContext: CoroutineContext,
  protected open var view: MembersView?
) : CoroutineScope {

  private val job = Job()

  private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    view?.showError(throwable)
  }

  override val coroutineContext: CoroutineContext
    get() = presenterContext + exceptionHandler

  open fun stop() {
    job.cancel()
  }
}
