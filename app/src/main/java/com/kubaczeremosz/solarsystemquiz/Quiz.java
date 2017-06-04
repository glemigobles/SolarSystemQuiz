package com.kubaczeremosz.solarsystemquiz;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity
        implements
        Answer_type_ThreeCorrect.OnFragmentInteractionListener,
        Answer_type_WriteDown.OnFragmentInteractionListener,
        Answer_type_OneCorrect.OnFragmentInteractionListener,
        Score.OnFragmentInteractionListener {

    private int currentQuestion = Main.variables.getCurrentQuestion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final boolean questionChecked = false;
        Main.variables.setCurrentQuestionText(Main.questions.get(currentQuestion - 1));

        //setting of UI Views
        final TextView questionNumber = (TextView) findViewById(R.id.questionNumber);
        questionNumber.setText("" + Main.variables.currentQuestion);
        final TextView questionText = (TextView) findViewById(R.id.questionTXT);
        questionText.setText(Main.variables.getCurrentQuestionText());
        final TextView numberOfQuestions = (TextView) findViewById(R.id.numberOfQuestions);
        numberOfQuestions.setText("/  " + Main.questions.size());
        final TextView quesString = (TextView) findViewById(R.id.questionstring);

        if (Main.variables.getCurrentQuestion() == 1) {

            Answer_type_OneCorrect answer = new Answer_type_OneCorrect();
            getSupportFragmentManager().beginTransaction().add(R.id.AnswerContainer, answer).commit();

            //Static object refercence created is set to reffering new fragment object
            Main.currentAnswerOne = answer;

        }

        // Setting "answer" button logic
        final Button nextRound = (Button) findViewById(R.id.nextRound);
        nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // first checking Answer
                checkAnswer();

                //then changing of Question and Answers to next one from specific list
                if (Main.variables.questionChecked) {
                    if (currentQuestion != Main.questions.size()) {

                        currentQuestion++;
                        Main.variables.setCurrentQuestion(currentQuestion);
                        setQuestion(questionText);
                        questionNumber.setText("" + currentQuestion);


                        if (checkingAnswerType(2)) {
                            Answer_type_ThreeCorrect answer = new Answer_type_ThreeCorrect();
                            getSupportFragmentManager().beginTransaction().replace(R.id.AnswerContainer, answer).commit();
                            //Static object refercence created is set to reffering new fragment object
                            Main.currentAnswerThreeCorrect = answer;
                        }
                        if (checkingAnswerType(3)) {
                            Answer_type_WriteDown answer = new Answer_type_WriteDown();
                            getSupportFragmentManager().beginTransaction().replace(R.id.AnswerContainer, answer).commit();
                            //Static object refercence created is set to reffering new fragment object
                            Main.currentAnswerWriteDown = answer;
                        }
                        if (checkingAnswerType(1)) {
                            Answer_type_OneCorrect answer = new Answer_type_OneCorrect();
                            getSupportFragmentManager().beginTransaction().replace(R.id.AnswerContainer, answer).commit();
                            //Static object refercence created is set to reffering new fragment object
                            Main.currentAnswerOne = answer;
                        }
                    }

                    //Thats what happening after answering last question
                    else {
                        nextRound.setText("End Quiz");
                        nextRound.setBackgroundColor(Color.parseColor("#BB2424"));

                        questionText.setTextSize(28);
                        questionText.setText(Main.variables.playerName + "!");
                        Score score = new Score();
                        getSupportFragmentManager().beginTransaction().replace(R.id.AnswerContainer, score).commit();

                        quesString.setText("");
                        questionNumber.setText("");
                        numberOfQuestions.setText("");

                        nextRound.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //clearing lists
                                for (int i = 0; i < Main.globalAnswerList.size(); i++) {
                                    Main.globalAnswerList.get(i).PlayerAnswer1 = null;
                                    Main.globalAnswerList.get(i).PlayerAnswer2 = null;
                                    Main.globalAnswerList.get(i).PlayerAnswer3 = null;
                                }
                                Main.globalAnswerList.clear();
                                Main.questions.clear();
                                //quit to main
                                Intent intent = new Intent(Quiz.this, Main.class);
                                startActivity(intent);
                            }
                        });


                    }
                }

            }
        });

    }

    private void setQuestion(TextView text) {

        Main.variables.setCurrentQuestionText(Main.questions.get(currentQuestion - 1));
        text.setText(Main.variables.getCurrentQuestionText());

    }

    public void checkAnswer() {

        if (checkingAnswerType(1)) {
            Main.currentAnswerOne.getCheckedAnswer();

            //checking if answer is checked
            if (Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 == null) {

                Main.variables.setQuestionChecked(false);
                Toast toast = Toast.makeText(getApplicationContext(), "Check Your answer First! ", Toast.LENGTH_SHORT);
                toast.getGravity();
                toast.show();
            } else {
                //checking if answer is correct
                Main.variables.setQuestionChecked(true);

                if ((Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1).equals(Main.globalAnswerList.get(currentQuestion - 1).CorrectAnswer1)) {

                    Main.variables.points++;
                    Toast toast = Toast.makeText(getApplicationContext(), "Correct Answer!", Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                } else {
                    String message = "Incorrect Answer! You should check: " + Main.globalAnswerList.get(currentQuestion - 1).CorrectAnswer1;
                    Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                }
            }

        }

        if (checkingAnswerType(2)) {
            Main.currentAnswerThreeCorrect.getCheckedAnswer();

            //checking if answers are checked
            if (Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 == null
                    || Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 == null
                    || Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 == null) {

                Main.variables.setQuestionChecked(false);
                Toast toast = Toast.makeText(getApplicationContext(), "Check 3 answers! ", Toast.LENGTH_SHORT);
                toast.getGravity();
                toast.show();
            } else {
                //checking if answers are correct
                Main.variables.setQuestionChecked(true);

                if ((Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1 == (Main.globalAnswerList.get(currentQuestion - 1).CorrectAnswer1)) &&
                        (Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer2 == (Main.globalAnswerList.get(currentQuestion - 1).CorrectAnswer2)) &&
                        (Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer3 == (Main.globalAnswerList.get(currentQuestion - 1).CorrectAnswer3))) {

                    Main.variables.points++;
                    Toast toast = Toast.makeText(getApplicationContext(), "Correct Answer!", Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                } else {
                    String message = "Incorrect Answer! You should check: " + Main.globalAnswerList.get(currentQuestion - 1).CorrectAnswer1
                            + ", " + Main.globalAnswerList.get(currentQuestion - 1).CorrectAnswer2
                            + ", " + Main.globalAnswerList.get(currentQuestion - 1).CorrectAnswer3;
                    Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                }
            }

        }

        if (checkingAnswerType(3)) {
            Main.currentAnswerWriteDown.getCheckedAnswer();

            //checking if answer is wrote
            if (Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1.equals("")) {

                Main.variables.setQuestionChecked(false);
                Toast toast = Toast.makeText(getApplicationContext(), "Write down Your answer! ", Toast.LENGTH_SHORT);
                toast.getGravity();
                toast.show();
            } else {
                //checking if answer is correct
                Main.variables.setQuestionChecked(true);

                if (Main.globalAnswerList.get(currentQuestion - 1).PlayerAnswer1.equals(Main.globalAnswerList.get(currentQuestion - 1).Answer1)) {
                    Main.variables.points++;
                    Toast toast = Toast.makeText(getApplicationContext(), "Correct Answer!", Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                } else {
                    String message = "Incorrect Answer! You should write down: " + Main.globalAnswerList.get(currentQuestion - 1).Answer1;
                    Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                    toast.getGravity();
                    toast.show();
                }
            }

        }

    }

    //There is 3 type of answers: 1st is radioButton ,2nd is checkbox and 3rd is Edittext
    boolean checkingAnswerType(int type) {

        if (type == currentQuestion || (currentQuestion - type) % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

}
