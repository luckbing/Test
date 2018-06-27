package com.example.admin.mytestgit.bean;

import android.app.Application;
import android.content.Context;

/**
 * Created by LgAdmin511 on 2018/6/26.
 */

public class MyApplication extends Application {
    private static Context sContext;


    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static Context getMyBaseContext(){
        return sContext;
    }
}
