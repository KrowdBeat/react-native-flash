# react-native-flash (android-only)

Simple API to turn on and off flash in react native (anroid only)

[![npm version](https://img.shields.io/npm/v/react-native-onesignal.svg?style=flat-square)](https://www.npmjs.com/package/react-native-flash)
[![npm downloads](https://img.shields.io/npm/dm/react-native-onesignal.svg?style=flat-square)](https://www.npmjs.com/package/react-native-flash)

## Installation
`npm install react-native-flash`

## Android Installation
In your `AndroidManifest.xml`

```xml
.....
    <uses-permission android:name="android.permission.CAMERA" />
    <uses-permission android:name="android.hardware.camera" />
```

In `android/settings.gradle`
```gradle
...
include ':RNFlash'
project(':RNFlash').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-flash/android')
```

In `android/app/build.gradle`

```gradle
...

dependencies {
    ...

    compile project(':RNFlash')
}
```

Register module (in `MainApplication.java`)

```java
import com.lcd344.reactnativeflash.ReactNativeFlashPackage;  // <--- Import

public class MainApplication extends Application implements ReactApplication {

	private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
  		......

	      /**
	     * A list of packages used by the app. If the app uses additional views
	     * or modules besides the default ones, add more packages here.
	     */
	    @Override
	    protected List<ReactPackage> getPackages() {
	        ...
	        return Arrays.<ReactPackage>asList(
	                new MainReactPackage(),
                  new ReactNativeFlashPackage() // Add this line
	        );
	    }
	};
	......
	@Override
	public ReactNativeHost getReactNativeHost() {
    	return mReactNativeHost;
	}
};

```

## Android Usage

In your `index.android.js`:
```javascript

import RNFlash from 'react-native-flash';


		RNFlash.turnOnFlash(); // turn on flash
		
		RNFlash.turnOffFlash(); // turn off flash
});
```

## TODO
 * [ ] IOS Support
 * [ ] Check if flash is abailable.
