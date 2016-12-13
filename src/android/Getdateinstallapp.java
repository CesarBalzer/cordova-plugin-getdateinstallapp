package br.com.balzer.getdateinstallapp.plugin;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.Context;

public class Getdateinstallapp extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
    	Context context=this.cordova.getActivity().getApplicationContext();
        if (action.equals("getdatetime")) {
            String name = data.getString(0);
            getInstallDateTime(callbackContext,name,context);
            return true;
        } else if (action.equals("getupdatetime")) {
        	String name = data.getString(0);
            getInstallUpdateTime(callbackContext,name,context);
            return true;
        } else {
            return false;
        }
    }

    void getInstallDateTime(CallbackContext callbackContext,String packageName, Context context) {
    	String installTime = null;
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    	PackageManager pm = context.getPackageManager();
    	ApplicationInfo appInfo = null;
    	try {
    		appInfo = pm.getApplicationInfo(packageName, 0);
    		PackageInfo packageInfo = pm.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);
    		installTime = dateFormat.format( new Date( packageInfo.firstInstallTime ) );
    	} catch (NameNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	callbackContext.success(installTime);
    	
    }
    
    void getInstallUpdateTime(CallbackContext callbackContext,String packageName, Context context) {
		String updateTime = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		PackageManager pm = context.getPackageManager();
		ApplicationInfo appInfo = null;
		try {
			appInfo = pm.getApplicationInfo(packageName, 0);
			PackageInfo packageInfo = pm.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);
			updateTime = dateFormat.format( new Date( packageInfo.lastUpdateTime ) );
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		callbackContext.success(updateTime);
    	
    }
}
