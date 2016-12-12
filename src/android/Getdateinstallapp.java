package br.com.balzer.getdateinstallapp.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.Date;
import java.text.DateFormat;

public class Getdateinstallapp extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("getdate")) {
            String name = data.getString(0);
            getInstallDate(callbackContext,name);
            return true;
        } else if (action.equals("getteste")) {
            String name = data.getString(0);
            String message = "Ola , " + name;
            callbackContext.success(message);
            return true;
        } else {
            return false;
        }
    }

    void getInstallDate(CallbackContext callbackContext,String name) {
        String errMsg = null;
        try {
            String message = "Hello, " + name;
            callbackContext.success(message);
            
        } catch (Exception e) {
            errMsg = e.getMessage();
            e.printStackTrace();
            callbackContext.error(errMsg);
        }
    }
}
