package com.mizshalom.chatapp.di.components;

import android.content.Context;
import com.mizshalom.chatapp.di.modules.ApplicationModule;
import com.mizshalom.chatapp.di.qualifier.ApplicationContext;

import dagger.Component;

@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    @ApplicationContext
    Context provideAppContext();
}
