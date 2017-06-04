package com.kubaczeremosz.solarsystemquiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;



public class Answer_type_ThreeCorrect extends Fragment {


    private OnFragmentInteractionListener mListener;

    public Answer_type_ThreeCorrect() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_answer_three_correct, container, false);
//
        int currentQuestion=Main.variables.getCurrentQuestion();

        CheckBox box1 = (CheckBox) view.findViewById(R.id.checkBox1);
        CheckBox box2 = (CheckBox) view.findViewById(R.id.checkBox2);
        CheckBox box3 = (CheckBox) view.findViewById(R.id.checkBox3);
        CheckBox box4 = (CheckBox) view.findViewById(R.id.checkBox4);
        CheckBox box5 = (CheckBox) view.findViewById(R.id.checkBox5);
        CheckBox box6 = (CheckBox) view.findViewById(R.id.checkBox6);

        box1.setText(Main.globalAnswerList.get(currentQuestion-1).answerList.get(0));
        box2.setText(Main.globalAnswerList.get(currentQuestion-1).answerList.get(1));
        box3.setText(Main.globalAnswerList.get(currentQuestion-1).answerList.get(2));
        box4.setText(Main.globalAnswerList.get(currentQuestion-1).answerList.get(3));
        box5.setText(Main.globalAnswerList.get(currentQuestion-1).answerList.get(4));
        box6.setText(Main.globalAnswerList.get(currentQuestion-1).answerList.get(5));


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

        CheckBox box1 = (CheckBox) getView().findViewById(R.id.checkBox1);
        CheckBox box2 = (CheckBox) getView().findViewById(R.id.checkBox2);
        CheckBox box3 = (CheckBox) getView().findViewById(R.id.checkBox3);
        CheckBox box4 = (CheckBox) getView().findViewById(R.id.checkBox4);
        CheckBox box5 = (CheckBox) getView().findViewById(R.id.checkBox5);
        CheckBox box6 = (CheckBox) getView().findViewById(R.id.checkBox6);


        if(box1.isChecked()){
            if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer1==null) {
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = box1.getText().toString();

            }
            else if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer2==null){
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 = box1.getText().toString();
            }
            else if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer3==null){
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 = box1.getText().toString();
            }
        }
        if(box2.isChecked()){
            if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer1==null) {
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = box2.getText().toString();

            }
            else if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer2==null){
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 = box2.getText().toString();
            }
            else if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer3==null){
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 = box2.getText().toString();
            }
        }
        if(box3.isChecked()){
            if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer1==null) {
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = box3.getText().toString();

            }
            else if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer2==null){
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 = box3.getText().toString();
            }
            else if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer3==null){
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 = box3.getText().toString();
            }
        }
        if(box4.isChecked()){
            if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer1==null) {
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = box4.getText().toString();

            }
            else if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer2==null){
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 = box4.getText().toString();
            }
            else if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer3==null){
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 = box4.getText().toString();
            }
        }
        if(box5.isChecked()){
            if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer1==null) {
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = box5.getText().toString();

            }
            else if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer2==null){
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 = box5.getText().toString();
            }
            else if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer3==null){
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 = box5.getText().toString();
            }
        }
        if(box6.isChecked()){
            if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer1==null) {
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 = box6.getText().toString();

            }
            else if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer2==null){
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 = box6.getText().toString();
            }
            else if(Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer3==null){
                Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 = box6.getText().toString();
            }
        }

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
