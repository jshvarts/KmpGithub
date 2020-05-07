package com.jshvarts.kmp.shared.presentation

interface MembersView : BaseView {
  var isUpdating: Boolean

  fun onUpdate(members: String)
}
