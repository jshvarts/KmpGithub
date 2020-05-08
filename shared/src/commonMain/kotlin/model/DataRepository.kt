package com.jshvarts.kmp.shared.model

interface DataRepository {
  var members: List<Member>?
  var onRefreshListeners: List<() -> Unit>

  suspend fun update()
}
