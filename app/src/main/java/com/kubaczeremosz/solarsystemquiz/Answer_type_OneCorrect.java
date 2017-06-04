package com.kubaczeremosz.solarsystemquiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;



public class Answer_type_OneCorrect extends Fragment {


    private OnFragmentInteractionListener mListener;


    public Answer_type_OneCorrect() {
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
        View view=inflater.inflate(R.layout.fragment_answer_one_correct, container, false);

        int currentQuestion=Main.variables.currentQuestion;

        final RadioButton radio1=(RadioButton) view.findViewById(R.id.radioButton1);
        final RadioButton radio2=(RadioButton) view.findViewById(R.id.radioButton2);
        final RadioButton radio3=(RadioButton) view.findViewById(R.id.radioButton3);

        radio1.setText(Main.globalAnswerList.get(currentQuestion-1).answerList.get(0));
        radio2.setText(Main.globalAnswerList.get(currentQuestion-1).answerList.get(1));
        radio3.setText(Main.globalAnswerList.get(currentQuestion-1).answerList.get(2));


        return view;

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

    public void getCheckedAnswer(){

        int currentQuestion=Main.variables.getCurrentQuestion();
        final RadioButton radio1=(RadioButton) getView().findViewById(R.id.radioButton1);
        final RadioButton radio2=(RadioButton) getView().findViewById(R.id.radioButton2);
        final RadioButton radio3=(RadioButton) getView().findViewById(R.id.radioButton3);

        if(radio1.isChecked()){
            Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer1=radio1.getText().toString();
        }
        if(radio2.isChecked()){
            Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer1=radio2.getText().toString();
        }
        if(radio3.isChecked()){
            Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer1=radio3.getText().toString();
        }

    }



    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);

    }

}
