package com.mizshalom.chatapp.ui.main.view;

import android.os.Bundle;
import com.mizshalom.chatapp.R;
import com.mizshalom.chatapp.application.ChatApplication;
import com.mizshalom.chatapp.di.components.DaggerMainActivityComponent;
import com.mizshalom.chatapp.di.modules.MainActivityModule;
import com.mizshalom.chatapp.ui.base.BaseActivity;
import com.mizshalom.chatapp.ui.base.BaseFragment;
import com.mizshalom.chatapp.ui.flow.lobby.login_module.view.LoginFragment;
import com.mizshalom.chatapp.ui.main.cantract.MainActivityContract;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainActivityContract.View {

    @Inject
    LoginFragment mLoginFragment;

    @Inject
    MainActivityContract.Presenter mPresenter;

    @Inject
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.onStart();
    }

    @Override
    protected void initDependencies() {
        DaggerMainActivityComponent.builder()
                .applicationComponent(((ChatApplication)getApplication()).getApplicationComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void initViews() {
    }

    @Override
    public void navigateToLoginScreen(){
        replaceFragment(getSupportFragmentManager(),R.id.contentContainer, mLoginFragment,false,null);
    }

    public void replaceFragment(BaseFragment fragment, String tag, boolean addToBackStack) {
        replaceFragment(getSupportFragmentManager(), R.id.contentContainer, fragment, addToBackStack, tag);
    }

    @Override
    public void displayProgressBar() {
    }

    @Override
    public void hideProgressBar() {
    }
}
