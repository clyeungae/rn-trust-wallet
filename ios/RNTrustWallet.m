#import <Foundation/Foundation.h>
#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(RNTrustWallet, NSObject)

RCT_EXTERN_METHOD(generateMnemonic:(RCTPromiseResolveBlock)resolve reject:(RCTPromiseRejectBlock)reject)

@end
