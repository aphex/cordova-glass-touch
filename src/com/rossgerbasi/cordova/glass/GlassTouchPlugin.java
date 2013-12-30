package com.rossgerbasi.cordova.glass;

import android.util.Log;
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
        //Log.d("GlassTouchPlugin", "Generic Motion");
        this.webView.dispatchTouchEvent(event);
        return true;
    }
}
