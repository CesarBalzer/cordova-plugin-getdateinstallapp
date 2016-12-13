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
        if (action.equals("getdate")) {
            String name = data.getString(0);
            getInstallDate(callbackContext,name,context);
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

    void getInstallDate(CallbackContext callbackContext,String name, Context context) {
    	
		String installTime = null;
		Date updateTime = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		//context context = null;
		
		PackageManager pm = context.getPackageManager();
		ApplicationInfo appInfo = null;
		String packageName = "com.example.appplugin";
		
		try {
			appInfo = pm.getApplicationInfo("com.example.appplugin", 0);
			System.out.println("--------------"+appInfo);
			PackageInfo packageInfo = pm.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);
			installTime = dateFormat.format( new Date( packageInfo.firstInstallTime ) );
			updateTime = new Date( packageInfo.lastUpdateTime );
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String appFile = appInfo.sourceDir;
		long installed = new File(appFile).lastModified();
		
		System.out.println("DATA DE INSTALACAO-------"+installed);
		
		System.out.println("DATA DE INSTALACAO-------"+installTime);
		System.out.println("DATA DE ATUALIZACAO-------"+updateTime);
		callbackContext.success(installTime);
    	
//        String errMsg = null;
//        try {
//            String message = "Hello, " + name;
//            callbackContext.success(message);
//            
//        } catch (Exception e) {
//            errMsg = e.getMessage();
//            e.printStackTrace();
//            callbackContext.error(errMsg);
//        }
    }
}
