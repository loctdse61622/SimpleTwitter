package com.loctd.coderschool.simpletwitter.application;

import android.app.Application;
import android.content.Context;

import com.loctd.coderschool.simpletwitter.model.User;
import com.loctd.coderschool.simpletwitter.rest.RestClient;

public class RestApplication extends Application {
    private static Context context;
    public static User mUser;
    public static int MODE = 0;
    @Override
    public void onCreate() {
        super.onCreate();

//        FlowManager.init(new FlowConfig.Builder(this).build());
//        FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);

        RestApplication.context = this;
    }

    public static RestClient getRestClient() {
        return (RestClient) RestClient.getInstance(RestClient.class, RestApplication.context);
    }
}
