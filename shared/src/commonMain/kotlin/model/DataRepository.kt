package com.jshvarts.kmp.shared.model

interface DataRepository {
  var members: String?
  var onRefreshListeners: List<() -> Unit>

  suspend fun update()
}
