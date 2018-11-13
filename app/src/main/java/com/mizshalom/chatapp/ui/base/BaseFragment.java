package com.mizshalom.chatapp.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import com.mizshalom.chatapp.ui.main.view.MainActivity;
import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    private BaseActivity mBaseActivity;

    public BaseFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initDependencies();
    }

    protected abstract void initDependencies();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents(view);
    }

    private void initComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            mBaseActivity = (BaseActivity) getActivity();

        }
    }

    public void replaceFragment(BaseFragment fragment, boolean addToBackStack, String tag) {

        if (getActivity() instanceof MainActivity && isAdded()) {
            MainActivity activity = (MainActivity) getActivity();
            activity.replaceFragment(fragment, tag, addToBackStack);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        //Log.d(TAG, getClass().getSimpleName() + ": on stop");
    }
}
