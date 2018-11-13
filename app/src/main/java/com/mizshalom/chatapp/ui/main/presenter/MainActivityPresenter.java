package com.mizshalom.chatapp.ui.main.presenter;

import com.mizshalom.chatapp.ui.main.cantract.MainActivityContract;

import javax.inject.Inject;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    @Inject
    MainActivityContract.View mView;

    @Inject
    public MainActivityPresenter() {
    }

    @Override
    public void onStart() {

        mView.navigateToLoginScreen();
    }
}
