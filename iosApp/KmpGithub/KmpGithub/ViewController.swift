//
//  ViewController.swift
//  KmpGithub
//
//  Created by James Shvarts on 5/7/20.
//  Copyright © 2020 James Shvarts. All rights reserved.
//

import UIKit
import shared

class ViewController: UIViewController {

  @IBOutlet weak var platformName: UILabel!
  
  override func viewDidLoad() {
    super.viewDidLoad()
    platformName.text = CommonKt.createPlatformMessage()
  }
}
