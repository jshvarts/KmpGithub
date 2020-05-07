package com.jshvarts.kmp.shared.repository

interface DataRepository {
  var members: String?
  var onRefreshListeners: List<() -> Unit>

  suspend fun update()
}
