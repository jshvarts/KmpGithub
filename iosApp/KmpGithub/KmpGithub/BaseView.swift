//
//  BaseView.swift
//  KmpGithub
//
//  Created by James Shvarts on 5/7/20.
//  Copyright © 2020 James Shvarts. All rights reserved.
//

import UIKit
import shared

extension UIViewController: BaseView {
  public func showError(error: KotlinThrowable) {
    let title: String = "Error"
    var errorMessage: String? = nil
    
    switch error {
    case is UpdateDataException:
      errorMessage = "Failed to get data from server. Check your connection."
    default:
      errorMessage = "Unknown error"
    }
    
    if let message = errorMessage {
      self.showError(title:title, message: message)
    }
  }
  
  private func showError(title: String, message: String) {
    let alertController = UIAlertController(title: title, message: message, preferredStyle: UIAlertController.Style.alert)
    
    alertController.addAction(UIAlertAction(title: "Dismiss", style: UIAlertAction.Style.default, handler: nil))

    self.present(alertController, animated: true, completion: nil)
  }
}
