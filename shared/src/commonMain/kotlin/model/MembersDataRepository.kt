package com.jshvarts.kmp.shared.model

import com.jshvarts.kmp.shared.api.GithubApi
import com.jshvarts.kmp.shared.api.UpdateDataException
import com.jshvarts.kmp.shared.repository.DataRepository

class MembersDataRepository(private val api: GithubApi) : DataRepository {
  override var members: String? = null

  override var onRefreshListeners: List<() -> Unit> = emptyList()

  override suspend fun update() {
    val newMembers = try {
      api.getMembers()
    } catch (t: Throwable) {
      throw UpdateDataException()
    }

    if (newMembers != members) {
      members = newMembers
      notifyRefreshListeners()
    }
  }

  private fun notifyRefreshListeners() {
    onRefreshListeners.forEach { it.invoke() }
  }
}
