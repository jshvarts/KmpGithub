package com.jshvarts.kmp.shared.model

import com.jshvarts.kmp.shared.api.GithubApi
import com.jshvarts.kmp.shared.api.UpdateDataException

class MembersDataRepository(private val api: GithubApi) : DataRepository {
  override var members: String? = null

  override var onRefreshListeners: List<() -> Unit> = emptyList()

  override suspend fun update() {
    val newMembers = try {
      api.getMembers()
    } catch (t: Throwable) {
      println("Unable to get members $t")
      throw UpdateDataException()
    }

    if (newMembers != members) {
      println("Got ${newMembers.count()} members")
      members = newMembers
      notifyRefreshListeners()
    }
  }

  private fun notifyRefreshListeners() {
    onRefreshListeners.forEach { it.invoke() }
  }
}
