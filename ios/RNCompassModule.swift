//
//  RNCompassModule.swift
//  RNCompassModule
//
//  Copyright © 2022 Dhairya Sharma. All rights reserved.
//

import Foundation

@objc(RNCompassModule)
class RNCompassModule: NSObject {
  @objc
  func constantsToExport() -> [AnyHashable : Any]! {
    return ["count": 1]
  }

  @objc
  static func requiresMainQueueSetup() -> Bool {
    return true
  }
}
