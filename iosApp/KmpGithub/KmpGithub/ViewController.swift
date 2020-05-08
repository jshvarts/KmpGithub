//
//  ViewController.swift
//  KmpGithub
//
//  Created by James Shvarts on 5/7/20.
//  Copyright © 2020 James Shvarts. All rights reserved.
//

import UIKit
import shared

class ViewController: UIViewController, MembersView {
  lazy var presenter: MembersPresenter = {
    MembersPresenter(view: self, repository: AppDelegate.appDelegate.dataRepository)
  }()
  
  @IBOutlet weak var platformName: UILabel!
  
  // TODO: handle loading UI
  var isUpdating = false
  
  func onUpdate(members: String) {
    print(members)
  }
  
  override func viewWillAppear(_ animated: Bool) {
    presenter.onCreate()
  }
  
  override func viewWillDisappear(_ animated: Bool) {
    presenter.onDestroy()
  }
  
  override func viewDidLoad() {
    super.viewDidLoad()
    platformName.text = CommonKt.createPlatformMessage()
  }
}
