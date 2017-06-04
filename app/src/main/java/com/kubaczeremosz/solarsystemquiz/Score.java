package com.kubaczeremosz.solarsystemquiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Score extends Fragment {


    private OnFragmentInteractionListener mListener;

    public Score() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score, container, false);

        TextView score = (TextView) view.findViewById(R.id.score);
        score.setText("" + Main.variables.points);

        TextView scorePercent = (TextView) view.findViewById(R.id.scorePercent);
        scorePercent.setText(Main.variables.setScorePercent() + " %");

        TextView congrats = (TextView) view.findViewById(R.id.congrats);

        if (Main.variables.setScorePercent() > 50) {
            congrats.setText("Congratulation! your score is :");
            if (Main.variables.setScorePercent() == 100) {
                congrats.setText("Perfect!!! your score is :");
            }
        } else {
            congrats.setText("It Could  be better! your score is :");
        }

        return view;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
