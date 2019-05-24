package com.gungunpriatna.belajarmvp.views.result;

import com.gungunpriatna.belajarmvp.views.base.Presenter;

public class ResultPresenter implements Presenter<ResultView> {
    private ResultView resultView;
    @Override
    public void onAttach(ResultView view) {
        resultView = view;
    }

    @Override
    public void onDetach() {
        resultView = null;
    }

    public void showResult(final String text) {
        resultView.onShowResult(text);
    }
}
