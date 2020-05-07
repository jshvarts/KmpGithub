package com.jshvarts.kmp.shared.api

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.Url

class GithubApi {
  private val client = HttpClient()

  private val memberUrl = Url("https://api.github.com/orgs/squarespace/members")

  suspend fun getMembers(): String {
    return client.get(memberUrl.toString())
  }
}
