package com.kubaczeremosz.solarsystemquiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class Answer_type_WriteDown extends Fragment {


    private OnFragmentInteractionListener mListener;

    public Answer_type_WriteDown() {
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
        View view=inflater.inflate(R.layout.fragment_write_down, container, false);

        final EditText editText=(EditText) view.findViewById(R.id.writeDown);

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
        EditText text=(EditText) getView().findViewById(R.id.writeDown);
        String answer=text.getText().toString();
        Main.globalAnswerList.get(currentQuestion-1).PlayerAnswer1=answer;

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
