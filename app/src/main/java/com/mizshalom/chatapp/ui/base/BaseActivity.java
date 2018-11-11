package com.mizshalom.chatapp.ui.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.mizshalom.chatapp.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressBar mProgressBar = null;
    private ViewGroup mContainer = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        ButterKnife.bind(this);
        initDependencies();

        //all app orientation will be portrait
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    private void setContentView() {

        View root = getLayoutInflater().inflate(R.layout.activity_base, null);
        setContentView(root);

        View contentView = getLayoutInflater().inflate(getLayoutResource(), null);
        mContainer = findViewById(R.id.contentContainer);
        mProgressBar = findViewById(R.id.main_progressbar);
        mContainer.addView(contentView);
    }

    protected abstract void initDependencies();

    protected abstract int getLayoutResource();
}
