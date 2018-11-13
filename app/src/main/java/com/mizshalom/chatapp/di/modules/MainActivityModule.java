package com.mizshalom.chatapp.di.modules;

import android.content.Context;
import com.mizshalom.chatapp.di.qualifier.ActivityContext;
import com.mizshalom.chatapp.di.scopes.PerActivity;
import com.mizshalom.chatapp.ui.flow.lobby.login_module.view.LoginFragment;
import com.mizshalom.chatapp.ui.main.cantract.MainActivityContract;
import com.mizshalom.chatapp.ui.main.presenter.MainActivityPresenter;
import com.mizshalom.chatapp.ui.main.view.MainActivity;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private final MainActivityContract.View mView;
    private final Context mActivityContext;


    public MainActivityModule(MainActivityContract.View mView) {
        this.mView = mView;
        mActivityContext = (MainActivity) mView;
    }

    @Provides
    @PerActivity
    MainActivityContract.View provideView(){
        return mView;
    }

    @Provides
    @PerActivity
    MainActivityContract.Presenter providePresenter(MainActivityPresenter presenter) {
        return presenter;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivityContext;
    }


    @Provides
    @PerActivity
    LoginFragment provideDashboardFragment() {
        return LoginFragment.newInstance();
    }
}
