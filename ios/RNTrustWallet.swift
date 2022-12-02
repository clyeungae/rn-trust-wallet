import Foundation
import WalletCore

@objc(RNTrustWallet)
class RNTrustWallet: NSObject {
  
  @objc static func requiresMainQueueSetup() -> Bool {
        return false
    }

  @objc(generateMnemonic:reject:)
  func generateMnemonic(_ resolve: RCTPromiseResolveBlock, reject: RCTPromiseRejectBlock) -> Void {
    let newWallet = HDWallet(strength: 128, passphrase: "")
    let mnemonic = newWallet?.mnemonic;
    
    let addressETH = newWallet?.getAddressForCoin(coin: .ethereum)
   resolve([mnemonic, addressETH]);
 }
}
