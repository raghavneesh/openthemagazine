package com.pdfviewer.openthemagazine;

import java.io.File;

import com.artifex.mupdf.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
//TODO Use Log  for exception logging.
//Dont use printStackTrace or System.out.println to print exceptions 
public class SplashActivity extends Activity {
	//Why the name of this variable is 'b' ??
	Boolean b;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        //Try to do these type of things declaratively.
        //Get the file path from some openthemagazine.properties file
        File appDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.pdfviewer.openthemagazine/files");
		if(!appDir.isDirectory()){
			appDir.mkdirs();
		}
        Thread start_splash = new Thread(){
        	public void run(){
        		try{
        			sleep(1000);
        			finish();
        		} catch(InterruptedException e){
        			e.printStackTrace();
        		} finally{
        			//Intent start_main_activity = new Intent("cx.hell.android.pdfviewpro.CHOOSEFILEACTIVITY");
        			//Intent start_main_activity = new Intent("android.intent.action.FRONTSCREEN");
        			
        			//Change this variable name to camelCase
        			Intent start_main_activity =
        					//String should not be here. Either pass the class, or get this string from xml file
        					new Intent("android.intent.action.FRONTSCREEN");
        			
        			startActivity(start_main_activity);
        		}
        	}
        };
        start_splash.start();
    }
}
