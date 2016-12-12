package br.com.balzer.getdateinstallapp.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import android.content.ComponentName;
import android.content.Context;
import java.io.File;

public class Getdateinstallapp extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("getdate")) {
            String name = data.getString(0);
            String message = "Hello, " + name;
            callbackContext.success(message);
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

    void getInstallDate(CallbackContext callbackContext) {
        String errMsg = null;
        PackageManager pm = context.getPackageManager();
        ApplicationInfo appInfo = pm.getApplicationInfo("br.com.balzer.getdateinstallapp", 0);
        String appFile = appInfo.sourceDir;
        long installed = new File(appFile).lastModified();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String installTime = dateFormat.format(new Date(packageInfo.firstInstallTime));
        callbackContext.success(installTime);
    }
}
