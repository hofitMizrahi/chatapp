package com.mizshalom.chatapp.di.modules;

import android.app.Application;
import android.content.Context;

import com.mizshalom.chatapp.di.qualifier.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application aApplication) {
        this.mApplication = aApplication;
    }

    @Provides
    @ApplicationContext
    Context appContext() {
        return mApplication;
    }
}
