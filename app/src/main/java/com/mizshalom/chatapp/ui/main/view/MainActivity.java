package com.mizshalom.chatapp.ui.main.view;

import android.os.Bundle;

import com.mizshalom.chatapp.R;
import com.mizshalom.chatapp.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initDependencies() {
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_base;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
