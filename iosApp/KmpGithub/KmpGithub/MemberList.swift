//
//  MemberList.swift
//  KmpGithub
//
//  Created by James Shvarts on 5/9/20.
//  Copyright © 2020 James Shvarts. All rights reserved.
//

import Foundation
import shared

class MemberList {
  var members: [Member] = []
  
  func updateMembers(_ newMembers: [Member]) {
    members.removeAll()
    members.append(contentsOf: newMembers)
  }
}
