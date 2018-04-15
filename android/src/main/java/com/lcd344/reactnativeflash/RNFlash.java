package com.lcd344.reactnativeflash;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.bridge.Callback;

import org.json.JSONObject;
import org.json.JSONException;


public class RNFlash extends ReactContextBaseJavaModule {

	private ReactContext mReactContext;
	private Camera mCamera;

	public RNFlash(ReactApplicationContext reactContext) {
		super(reactContext);
		mReactContext = reactContext;
	}


	@Override
	public String getName() {
		return "RNFlash";
	}

	private Camera getCamera() {
		Camera camera;

		if (mCamera == null) {
			try {
				mCamera = Camera.open();
			} catch (RuntimeException e) {
				Log.e("Camera Error. Failed to Open. Error: ", e.getMessage());
			}
		}

		return mCamera;
	}

	@ReactMethod
	public void turnOnFlash() {
    Camera camera = getCamera();
		Parameters params;

		if (camera == null || !mReactContext.getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
			return;
		}

		params = camera.getParameters();
		params.setFlashMode(Parameters.FLASH_MODE_TORCH);
		camera.setParameters(params);
		camera.startPreview();
	}


	@ReactMethod
	public void turnOffFlash() {
    Camera camera = getCamera();
		Parameters params;

		if (camera == null || !mReactContext.getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
			return;
		}

		params = camera.getParameters();
		params.setFlashMode(Parameters.FLASH_MODE_OFF);
		camera.setParameters(params);
		camera.stopPreview();
	}

	@ReactMethod
	public void hasFlash(Callback successCallback, Callback errorCallback) {

		if (mReactContext.getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
			successCallback.invoke();
		} else {
			errorCallback.invoke();
		}
	}
}
