package com.jshvarts.kmp.shared.presentation

import com.jshvarts.kmp.shared.model.Member

interface MembersView : BaseView {
  var isUpdating: Boolean

  fun onUpdate(members: List<Member>)
}
