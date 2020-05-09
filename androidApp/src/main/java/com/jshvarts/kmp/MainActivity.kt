package com.jshvarts.kmp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jshvarts.kmp.R.layout
import com.jshvarts.kmp.R.string
import com.jshvarts.kmp.shared.api.UpdateDataException
import com.jshvarts.kmp.shared.createPlatformMessage
import com.jshvarts.kmp.shared.model.Member
import com.jshvarts.kmp.shared.presentation.MembersPresenter
import com.jshvarts.kmp.shared.presentation.MembersView
import kotlinx.android.synthetic.main.activity_main.membersRecyclerView
import kotlinx.android.synthetic.main.activity_main.platformMessage

class MainActivity : AppCompatActivity(), MembersView {
  private val repository by lazy {
    (application as KmpGithubApplication).dataRepository
  }

  private val presenter by lazy {
    MembersPresenter(this, repository)
  }

  private lateinit var adapter: MemberAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    platformMessage.text = createPlatformMessage()

    setupRecyclerView()

    presenter.onCreate()
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onDestroy()
  }

  override var isUpdating = false

  override fun onUpdate(members: List<Member>) {
    adapter.members = members

    runOnUiThread {
      adapter.notifyDataSetChanged()
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

  private fun setupRecyclerView() {
    membersRecyclerView.layoutManager = LinearLayoutManager(this)
    adapter = MemberAdapter(emptyList())
    membersRecyclerView.adapter = adapter
  }
}
