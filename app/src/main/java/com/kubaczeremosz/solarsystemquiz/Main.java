package com.kubaczeremosz.solarsystemquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Main extends AppCompatActivity {


    //declaring new static VariableContainer object
    public static VariableContainer variables =new VariableContainer();

    //static list of questions <String>
    static public ArrayList<String> questions=new ArrayList<String>();

    //static list of answer objects <Answers>
    static public ArrayList<Answers> globalAnswerList=new ArrayList<>();

    //static object references that contain reference to instances of Answers fragments
    public static Answer_type_OneCorrect currentAnswerOne;
    public static Answer_type_WriteDown currentAnswerWriteDown;
    public static Answer_type_ThreeCorrect currentAnswerThreeCorrect;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        variables.points=0;
        variables.addQuestions(questions);
        variables.addAnswers(globalAnswerList);


        //edit text field
        final EditText playername=(EditText) findViewById(R.id.playerName);

        //button "start quiz"
        Button start=(Button) findViewById(R.id.buttonStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                variables.setPlayerName(playername.getText().toString());

                if(TextUtils.isEmpty(variables.getPlayerName())) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Type Player name first!", Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                }
                else{
                    variables.setCurrentQuestion(1);
                    Intent intent = new Intent(Main.this, Quiz.class);
                    startActivity(intent);
                }
            }
        });

    }


}
