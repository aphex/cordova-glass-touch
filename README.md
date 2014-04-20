##Cordova Glass Touch Plugin##
---

### **This plugin will *not* get further updates as it has been merged into the [Cordova Glass Plugin](https://github.com/aphex/cordova-glass) that contains all the same features plus voice triggering, voice prompting and gesture event processing.** ###

---

This plugin adds basic touch events from the Google Glass Touchpad to your Cordova based application. If you need greater gesture support then basic touch events you will then want to look at the [CordovaGlassGesture Plugin](https://github.com/aphex/cordova-glass-gesture).


###Events###
- touchstart
- touchend


###Usage###

Add plugin via Node

`cordova plugin add https://github.com/aphex/cordova-glass-touch`

Add an event listener to the document of your web application

```
document.addEventListener('touchstart', 
	function() {
		console.log('onTouchStart');
	}
);
```