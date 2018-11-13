package com.mizshalom.chatapp.ui.main.cantract;

import com.mizshalom.chatapp.ui.base.BasePresenter;
import com.mizshalom.chatapp.ui.base.BaseView;

public interface MainActivityContract {

    interface View extends BaseView {

        void initViews();
        void navigateToLoginScreen();
    }

    interface Presenter extends BasePresenter {
    }
}
