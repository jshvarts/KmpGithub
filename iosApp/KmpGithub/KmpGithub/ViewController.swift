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
  
  let memberList = MemberList()
  
  lazy var presenter: MembersPresenter = {
    MembersPresenter(view: self, repository: AppDelegate.appDelegate.dataRepository)
  }()
  
  @IBOutlet weak var platformName: UILabel!
  
  @IBOutlet weak var membersTableView: UITableView!
  
  // TODO: handle loading UI
  var isUpdating = false
  
  func onUpdate(members: [Member]) {
    print(members)
    self.memberList.updateMembers(members)
    self.membersTableView.reloadData()
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
    
    membersTableView.register(UINib(nibName: "MemberCellTableViewCell", bundle: nil), forCellReuseIdentifier: "MemberCell")
  }
}

extension ViewController : UITableViewDataSource {
  func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
    return self.memberList.members.count 
  }
  
  func numberOfSections(in tableView: UITableView) -> Int {
    return self.memberList.members.count
  }
  
  func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
    let cell = tableView.dequeueReusableCell(withIdentifier: "MemberCell", for: indexPath) as! MemberCellTableViewCell
    
    let member = self.memberList.members[indexPath.row]
    cell.memberLogin.text = member.login
    cell.memberAvatar.load(url: URL(string: member.avatarUrl)!)
    return cell
  }
}

// in a prod app, you'd use SDWebImage or similar library
extension UIImageView {
  func load(url: URL) {
    DispatchQueue.global().async { [weak self] in
      if let data = try? Data(contentsOf: url) {
        if let image = UIImage(data: data) {
          DispatchQueue.main.async {
            self?.image = image
          }
        }
      }
    }
  }
}
