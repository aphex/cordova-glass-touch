package com.rossgerbasi.cordova.glass;

import android.util.Log;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

public class GlassTouchPlugin extends CordovaPlugin implements View.OnGenericMotionListener {
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        //Log.d("GlassTouchPlugin", "Glass Touch Initialize");
        super.initialize(cordova, webView);

        CordovaPlugin glassCore = this.webView.pluginManager.getPlugin("GlassCore");
        if(glassCore != null) {
            glassCore.onMessage("setMotionListener", this);
        } else {
            Log.d("GlassTouchPlugin", "Unable to find GlassCore Plugin to attach listener");
        }
    }

    @Override
    public boolean onGenericMotion(View v, MotionEvent event) {
//        Log.d("GlassTouchPlugin", "Generic Motion Caught");

        // Maps from Input space to WebView space
        Float rangeX = InputDevice.getDevice(event.getDeviceId()).getMotionRange(MotionEvent.AXIS_X).getRange();
        Float rangeY = InputDevice.getDevice(event.getDeviceId()).getMotionRange(MotionEvent.AXIS_Y).getRange();
        Float screenX = (event.getAxisValue(MotionEvent.AXIS_X)/rangeX) * webView.getWidth();
        Float screenY = (event.getAxisValue(MotionEvent.AXIS_Y)/rangeY) * webView.getHeight();
        event.setLocation(screenX, screenY);

        this.webView.dispatchTouchEvent(event);
        return true;
    }
}