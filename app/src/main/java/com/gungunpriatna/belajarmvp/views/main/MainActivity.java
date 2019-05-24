package com.gungunpriatna.belajarmvp.views.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.gungunpriatna.belajarmvp.R;
import com.gungunpriatna.belajarmvp.internal.model.Data;
import com.gungunpriatna.belajarmvp.views.result.ResultFragment;

public class MainActivity extends AppCompatActivity implements MainView {
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        onAttachView();
    }

    private void initPresenter() {
        presenter = new MainPresenter();
    }

    private void initToolbar() {
        final Toolbar toolbar = findViewById(R.id.toolbar_main);
        toolbar.setTitle(getTitle());
        setSupportActionBar(toolbar);
    }

    private void addButtonListener() {
        final Button button = findViewById(R.id.btn_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setVisibility(View.GONE);
                presenter.showFragment();
            }
        });
    }

    @Override
    public void onShowFragment(final Data data) {
        final Bundle bundle = new Bundle();
        bundle.putString("data", data.getText());

        //show fragment with data
        final String tag = ResultFragment.class.getSimpleName();
        final Fragment fragment = ResultFragment.newInstance();
        fragment.setArguments(bundle);

        //Begin frament transaction
        final FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_main, fragment, tag);
        fragmentTransaction.commit();

    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        initToolbar();
        addButtonListener();


    }

    @Override
    public void onDetachView() {
        presenter.onDetach();

    }
}
