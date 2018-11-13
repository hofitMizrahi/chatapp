package com.mizshalom.chatapp.di.components;

import com.mizshalom.chatapp.di.modules.MainActivityModule;
import com.mizshalom.chatapp.di.scopes.PerActivity;
import com.mizshalom.chatapp.ui.main.view.MainActivity;
import dagger.Component;

@PerActivity
@Component(modules = MainActivityModule.class ,dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
