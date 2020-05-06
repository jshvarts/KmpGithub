//
//  ContentView.swift
//  KmpGithub
//
//  Created by James Shvarts on 5/6/20.
//  Copyright © 2020 James Shvarts. All rights reserved.
//

import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        Text(CommonKt.createPlatformMessage())
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
