package com.mizshalom.chatapp.ui.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.mizshalom.chatapp.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseView{

    private ProgressBar mProgressBar = null;
    private ViewGroup mContainer = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setContainerView();
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initDependencies();

    }

    protected abstract void initDependencies();

    protected abstract int getLayoutResource();

    private void setContainerView() {
        View contentView = getLayoutInflater().inflate(getLayoutResource(), null);
        mContainer = findViewById(R.id.contentContainer);
        mProgressBar = findViewById(R.id.main_progressbar);
        mContainer.addView(contentView);
    }

    protected void replaceFragment(FragmentManager fragmentManager, int containerId, BaseFragment fragment, boolean addToBackStack, String tag) {
        if (!isFinishing()) {
            FragmentTransaction transaction = fragmentManager.beginTransaction().replace(containerId, fragment);
            if (addToBackStack) {
                transaction.addToBackStack(tag);
            }
            transaction.commit();
        }
    }


}
