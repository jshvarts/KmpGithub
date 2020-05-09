package com.jshvarts.kmp.shared.presentation

import com.jshvarts.kmp.shared.ApplicationDispatcher
import com.jshvarts.kmp.shared.model.MembersRepository
import kotlinx.coroutines.launch

class MembersPresenter(
  override var view: MembersView?,
  private val repository: MembersRepository
) : BasePresenter(ApplicationDispatcher, view) {

  fun loadMembers() {
    view?.showRefreshing()
    launch {
      val members = repository.getMembers()
      view?.showData(members)
    }.invokeOnCompletion {
      view?.hideRefreshing()
    }
  }

  override fun stop() {
    view = null
  }
}
