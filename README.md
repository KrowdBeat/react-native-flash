# react-native-flash

Simple API to turn on and off flash in react native

[![npm version](https://img.shields.io/npm/v/react-native-flash.svg?style=flat-square)](https://www.npmjs.com/package/react-native-flash)
[![npm downloads](https://img.shields.io/npm/dm/react-native-flash.svg?style=flat-square)](https://www.npmjs.com/package/react-native-flash)

## Installation

    npm install react-native-flash
    react-native link react-native-flash

## Usage

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

* [ ] Any Suggestions?
