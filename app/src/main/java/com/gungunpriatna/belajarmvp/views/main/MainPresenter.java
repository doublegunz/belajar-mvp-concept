package com.gungunpriatna.belajarmvp.views.main;

import com.gungunpriatna.belajarmvp.internal.model.Data;
import com.gungunpriatna.belajarmvp.views.base.Presenter;

public class MainPresenter implements Presenter<MainView> {
    private MainView mainVIew;
    @Override
    public void onAttach(MainView view) {
        this.mainVIew = view;
    }

    @Override
    public void onDetach() {
        mainVIew = null;

    }

    public void showFragment() {
        final Data data = new Data();
        data.setText("Hello from data!");

        mainVIew.onShowFragment(data);
    }
}
