//
//  AppDelegate.swift
//  KmpGithub
//
//  Created by James Shvarts on 5/7/20.
//  Copyright © 2020 James Shvarts. All rights reserved.
//

import UIKit
import shared

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
  public lazy var dataRepository = { MembersDataRepository(api: GithubApi()) }()
  
  var window: UIWindow?
  
  static var appDelegate: AppDelegate {
    return UIApplication.shared.delegate as! AppDelegate
  }
}

