package com.jshvarts.kmp.shared.model

interface MembersRepository {
  var members: List<Member>?
  var onRefreshListeners: List<() -> Unit>

  suspend fun update()
}
