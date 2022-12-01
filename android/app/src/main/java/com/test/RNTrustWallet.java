package com.test;
import androidx.annotation.NonNull;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.Promise;

import wallet.core.jni.CoinType;
import wallet.core.jni.HDWallet;

public class RNTrustWallet extends ReactContextBaseJavaModule {

  RNTrustWallet(ReactApplicationContext context) {
    super(context);
    System.loadLibrary("TrustWalletCore");
  }

  @NonNull
  @Override
  public String getName() {
    return "RNTrustWallet";
  }

  @ReactMethod
  public void generateMnemonic(Promise promise) {
   try {
      HDWallet newWallet = new HDWallet(128, "");
      String mnemonic = newWallet.mnemonic();

      String addressETH = newWallet.getAddressForCoin(CoinType.ETHEREUM);
      WritableNativeArray array = new WritableNativeArray();
      array.pushString(mnemonic);
      array.pushString(addressETH);
      promise.resolve(array);
   } catch (Exception e) {
    promise.reject(e);
   }
  }
}