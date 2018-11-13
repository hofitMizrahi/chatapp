package com.mizshalom.chatapp.ui.flow.lobby.login_module.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mizshalom.chatapp.R;
import com.mizshalom.chatapp.ui.base.BaseFragment;

import javax.inject.Inject;

public class LoginFragment extends BaseFragment {

    public static LoginFragment newInstance(){
        return new LoginFragment();
    }

    @Inject
    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    protected void initDependencies() {
    }
}
