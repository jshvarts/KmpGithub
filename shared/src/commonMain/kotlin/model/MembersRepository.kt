package com.jshvarts.kmp.shared.model

import com.jshvarts.kmp.shared.api.GithubApi
import com.jshvarts.kmp.shared.api.UpdateDataException

class MembersRepository(private val api: GithubApi) {
  suspend fun getMembers(): List<Member> {
    return try {
      api.getMembers()
    } catch (t: Throwable) {
      println("Unable to get members ${t.cause}")
      throw UpdateDataException()
    }
  }
}
