
# react-native-flash (android-only)

Simple API to turn on and off flash in react native (anroid only)

[![npm version](https://img.shields.io/npm/v/react-native-flash.svg?style=flat-square)](https://www.npmjs.com/package/react-native-flash)
[![npm downloads](https://img.shields.io/npm/dm/react-native-flash.svg?style=flat-square)](https://www.npmjs.com/package/react-native-flash)

It works (at least for the react-native version it was built for) and as that it will be left here. 

## Installation
`npm install react-native-flash`

## Android Installation
In your `AndroidManifest.xml`

```xml
.....
    <uses-permission android:name="android.permission.CAMERA" />a
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
		
		/*Has flash checks if the phone has flash available.
		  Since all communication between react native and native modules is asychrounous, it takes a success callback, and failure callback. atm both callbacks are necessary.
		 
		   */
		RNFlash.hasFlash(function(){
			RNFlash.turnOnFlash();
		},function(){
			alert("You do not have flash")
		});
});
```

## TODO
 * [ ] IOS Support - I do not currently own a mac - so anyone who could offer help on this is welcome.
 * [ ] Any Suggestions?
