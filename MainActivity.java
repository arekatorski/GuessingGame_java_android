package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtGuess;
    private Button btnGuess;
    private TextView lblOutput;
    int numberOfTry = 0;
    int theNumber;

    public void newGame() {
        theNumber = (int)(Math.random() * 100 + 1);
    }

    public void checkGuess(){
        String guesstext = txtGuess.getText().toString();
        String message = "";
        try{
            numberOfTry++;
            int guess = Integer.parseInt(guesstext);
            if(guess < theNumber)
                message = guess + " jest za małą! Spróbuj ponownie\n Number próby: " + numberOfTry;
            else if(guess > theNumber)
                message = guess + " jest za duża! Spróbuj ponownie\n Number próby: " + numberOfTry;
            else if(guess == theNumber)
                message = guess + " jest poprawna! Number próby: \n" + numberOfTry;
            else message = "Nie rozpoznano znaku! Spróbuj ponownie!";

        } catch(Exception e){
            message = "Wpisz dowolną liczbę między 1 a 100";
        }finally{
            lblOutput.setText(message);
            txtGuess.requestFocus();
            txtGuess.selectAll();
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtGuess = (EditText) findViewById(R.id.txtGuess);
        btnGuess = (Button) findViewById(R.id.btnGuess);
        lblOutput = (TextView) findViewById(R.id.lblOutput);
        newGame();
        btnGuess.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                checkGuess();
            }
        });
    }
}
