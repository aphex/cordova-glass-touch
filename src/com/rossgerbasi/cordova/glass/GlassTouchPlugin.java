package com.rossgerbasi.cordova.glass;

// import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class GlassTouchPlugin extends CordovaPlugin implements View.OnGenericMotionListener {

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
       // Log.d("GlassTouchPlugin", "Glass Touch Initialize");
       super.initialize(cordova, webView);
       this.webView.setOnGenericMotionListener(this);
    }

    @Override
    public boolean onGenericMotion(View v, MotionEvent event) {
        this.webView.dispatchTouchEvent(event);
        return true;
    }
}
