package com.example.mytestmap.Utils;

import android.app.Application;

public class App extends Application {

    private static MethodCollection methodCollection;

    @Override
    public void onCreate() {
        super.onCreate();
        methodCollection = new MethodCollection(getApplicationContext());

    }

    public static MethodCollection getMethodCollection(){
        return methodCollection;
    }
}
