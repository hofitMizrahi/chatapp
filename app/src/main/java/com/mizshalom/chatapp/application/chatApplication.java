package com.mizshalom.chatapp.application;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.mizshalom.chatapp.di.components.ApplicationComponent;
import com.mizshalom.chatapp.di.components.DaggerApplicationComponent;
import com.mizshalom.chatapp.di.modules.ApplicationModule;
import com.mizshalom.chatapp.ui.main.view.MainActivity;
import java.net.URISyntaxException;
import io.socket.client.IO;
import io.socket.client.Socket;

public abstract class chatApplication extends Application implements Application.ActivityLifecycleCallbacks{

    private final String TAG = "chatApp";
    private Socket mSocket;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Application Start");
        initSingletonDependencies();
        registerToServer();
    }

    private void initSingletonDependencies() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    private void registerToServer(){

        try {
            mSocket = IO.socket(Constants.IP_LOCAL_HOST);
        } catch (URISyntaxException e) {
            Log.i(MainActivity.class.getSimpleName(), e.getMessage());
            e.printStackTrace();
        }
        mSocket.connect();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        mSocket.disconnect();
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}
