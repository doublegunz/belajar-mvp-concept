package com.gungunpriatna.belajarmvp.views.result;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gungunpriatna.belajarmvp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResultFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragment extends Fragment implements ResultView {

    ResultPresenter presenter;

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPresenter();
        onAttachView();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }


    @Override
    public void onShowResult(String text) {
        final TextView textView = getActivity().findViewById(R.id.tv_result);
        textView.setText(text);

    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        setResult();

    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    private void initPresenter() {
        presenter= new ResultPresenter();
    }

    private void setResult() {
        final Bundle bundle = getArguments();
        final String text = bundle.getString("data");

        presenter.showResult(text);
    }

    @Override
    public void onDestroyView() {
        onDetachView();
        super.onDestroyView();
    }

}
