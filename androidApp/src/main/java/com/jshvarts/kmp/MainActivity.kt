package com.jshvarts.kmp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jshvarts.kmp.R.string
import com.jshvarts.kmp.shared.api.UpdateDataException
import com.jshvarts.kmp.shared.createPlatformMessage
import com.jshvarts.kmp.shared.model.Member
import com.jshvarts.kmp.shared.presentation.MembersPresenter
import com.jshvarts.kmp.shared.presentation.MembersView

class MainActivity : AppCompatActivity(), MembersView {
  private val repository by lazy {
    (application as KmpGithubApplication).dataRepository
  }

  private val presenter by lazy {
    MembersPresenter(this, repository)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    findViewById<TextView>(R.id.main_text).text = createPlatformMessage()

    presenter.onCreate()
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onDestroy()
  }

  override var isUpdating = false

  override fun onUpdate(members: List<Member>) {
    runOnUiThread {
      Toast.makeText(this, members.toString(), Toast.LENGTH_LONG).show()
    }
  }

  override fun showError(error: Throwable) {
    val errorMessage = when (error) {
      is UpdateDataException -> getString(string.update_problem_message)
      else -> getString(string.unknown_error)
    }
    runOnUiThread {
      Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }
  }
}
