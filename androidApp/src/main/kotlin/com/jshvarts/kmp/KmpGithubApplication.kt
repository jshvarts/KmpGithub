package com.jshvarts.kmp

import android.app.Application
import com.jshvarts.kmp.shared.BuildConfig
import com.jshvarts.kmp.shared.api.GithubApi
import com.jshvarts.kmp.shared.model.DataRepository
import com.jshvarts.kmp.shared.model.MembersDataRepository
import timber.log.Timber

class KmpGithubApplication : Application() {
  val dataRepository: DataRepository by lazy {
    MembersDataRepository(GithubApi())
  }

  override fun onCreate() {
    super.onCreate()
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}
