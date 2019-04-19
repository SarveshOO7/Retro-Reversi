package com.sarveshtandon.www.reversi;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    Button squares[][]= new Button[8][8],restartButton;
    int matrix[][] = new int[8][8];
    int col = 0, row = 0;
    public Boolean firstTime  = null;
    String TAG = GameActivity.class.getSimpleName();
    Drawable userButtonIcon, computerButtonIcon, emptyButtonIcon, lastMoveButtonIcon;
    Processor processor = new Processor();
    MoveReturn moveReturn= new MoveReturn();
    ComputerMoveReturn computerMoveReturn = new ComputerMoveReturn();
    TextView textView,computerScore,madeByView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Button level1,level2;
        level1 = findViewById(R.id.level1button);
        level2 = findViewById(R.id.level2button);*/
        setContentView(R.layout.opening);

        new CountDownTimer(1000,100){
            public void onFinish(){
                setContentView(R.layout.activity_game);

                //if(isFirstTime()){
                AlertDialogFragment dialog = new AlertDialogFragment();
                AlertDialogFragmentWin victoryDialog = new AlertDialogFragmentWin();
                dialog.show(getFragmentManager(), "error_dialog");
                //}
                //madeByView = findViewById(R.id.textView2);
                //madeByView.setText(R.string.dark_sky_message);
                //madeByView.setMovementMethod(LinkMovementMethod.getInstance());
                userButtonIcon = findViewById(R.id.button).getBackground();
                computerButtonIcon =findViewById(R.id.button4).getBackground();
                emptyButtonIcon = findViewById(R.id.button2).getBackground();
                lastMoveButtonIcon = findViewById(R.id.button3).getBackground();
                textView = findViewById(R.id.textView);
                computerScore = findViewById(R.id.computerScore);
                restartButton = findViewById(R.id.restartButton);
                restartButton.setClickable(true);
                restartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        restartBoard(matrix);
                        Log.i("restart","ON click listener set.");
                    }
                });
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startBoard();
                    }
                });

            }
            public void onTick(long millisUntilFinished) {

            }
        }.start();
        Toast.makeText(this, "Completed by Sarvesh Tandon on              14th August, 2018", Toast.LENGTH_LONG).show();


    }
    public int[][] restartBoard(int[][] matrix) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = 0;
            }
        }
        matrix[3][3]=1;
        matrix[4][3]=2;
        matrix[3][4]=2;
        matrix[4][4]=1;
        Toast.makeText(this, "Board reset", Toast.LENGTH_SHORT).show();
        setBoard(matrix);
        return matrix;
    }

    @Override
    public void onClick(final View v) {
        {
            int k = 0;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (v.getId() == squares[i][j].getId()) {
                        k++;
                        col = i;      //Possible logical error check values of col and row
                        row = j;      //Possible logical error check values of col and row
                        break;
                    }

                }
                if (k > 0)
                    break;
            }

            if (matrix[col][row]==0) {
                if (processor.userMovePossibility(matrix, 0, 0)) {
                    matrix[col][row] = 1; // Possible logical error check values of col and row
                    moveReturn = processor.Move(matrix, row, col);
                    Log.i("Position", "row--" + row + "col--" + col);
                    matrix = moveReturn.getMatrix();
                    setBoard(matrix);
                    String log = "";
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            log = log + matrix[i][j] + ",";
                        }
                        log = log + "\n";
                    }
                    Log.i("Matrix After User Move", log);
                    if (moveReturn.isValid()||!processor.userMovePossibility(matrix, 0, 0)) {
                        //do {
                        if (!processor.userMovePossibility(matrix, 0, 0))
                            Toast.makeText(this, "User Move Skipped", Toast.LENGTH_SHORT);
                        computerMoveReturn = processor.computerMove(matrix);
                        matrix = computerMoveReturn.getMatrix();
                        //Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
                        if (computerMoveReturn.getYouWon() != -1) {
                            computerMoveReturn.setYouWon(1);
                            matrix[computerMoveReturn.getRow()][computerMoveReturn.getCol()] = 5;
                            new CountDownTimer(750, 150) {
                                public void onFinish() {

                                    setBoard(matrix);
                                    Log.i("Check","OK");
                                }

                                public void onTick(long millisUntilFinished) {

                                }
                            }.start();

                            new CountDownTimer(1000, 100) {
                                public void onFinish() {

                                    matrix[computerMoveReturn.getRow()][computerMoveReturn.getCol()] = 2;
                                    setBoard(matrix);


                                }

                                public void onTick(long millisUntilFinished) {

                                }
                            }.start();
                        } else {
                            int temp=0;
                            for(int i =0;i<8;i++){
                                for(int j =0;j<8;j++){
                                    if(matrix[i][j]==2){
                                        temp++;
                                        break;
                                    }
                                }
                            }
                            if(temp==0)
                                Toast.makeText(this, "You WON!", Toast.LENGTH_SHORT).show();

                            else
                                Toast.makeText(this, "Computer Move Skipped", Toast.LENGTH_SHORT).show();
                            computerMoveReturn.setYouWon(1);

                        }

                        // }while(!processor.userMovePossibility(matrix, col, row));


                    } else
                        Toast.makeText(this, "Illegeal Move!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "User Move Skipped", Toast.LENGTH_SHORT).show();
                    computerMoveReturn = processor.computerMove(matrix);
                    matrix = computerMoveReturn.getMatrix();
                    if (computerMoveReturn.getYouWon() != -1) {
                        computerMoveReturn.setYouWon(1);
                        matrix[computerMoveReturn.getRow()][computerMoveReturn.getCol()] = 5;
                        new CountDownTimer(750, 150) {
                            public void onFinish() {

                                setBoard(matrix);
                                Log.i("Check","OK");
                            }

                            public void onTick(long millisUntilFinished) {

                            }
                        }.start();

                        new CountDownTimer(1000, 100) {
                            public void onFinish() {

                                matrix[computerMoveReturn.getRow()][computerMoveReturn.getCol()] = 2;
                                setBoard(matrix);


                            }

                            public void onTick(long millisUntilFinished) {

                            }
                        }.start();
                    }
                }
            }
            else
                Toast.makeText(this, "Illegeal Move!", Toast.LENGTH_SHORT).show();

        }
    }

    public void setBoard ( int[][] matrix){

        int userScore=0,computer=0,left=0;
        String score;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (matrix[i][j]) {
                    case 1:
                        squares[i][j].setBackground(userButtonIcon);
                        userScore++;
                        break;
                    case 2:
                        squares[i][j].setBackground(computerButtonIcon);
                        computer++;
                        break;
                    case 5:
                        squares[i][j].setBackground(lastMoveButtonIcon);
                        computer++;
                        break;
                    default:
                        squares[i][j].setBackground(emptyButtonIcon);
                        left++;
                        break;
                }

            }
        }
        score=Integer.toString(userScore);
        textView.setText(score);
        score=Integer.toString(computer);
        computerScore.setText(score);
        if(left==0){
            if(computer<userScore){
                Toast.makeText(this, "YOU WON!", Toast.LENGTH_SHORT).show();
            }
            else if(computer>userScore){

                Toast.makeText(this, "YOU LOST!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "It's a draw!", Toast.LENGTH_SHORT).show();
            }
        }
        Log.i(TAG, "Board set");
    }
    private boolean isFirstTime() {
        if (!firstTime) {
            SharedPreferences mPreferences = this.getSharedPreferences("first_time", Context.MODE_PRIVATE);
            firstTime = mPreferences.getBoolean("firstTime", true);
            if (firstTime) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putBoolean("firstTime", false);
                editor.commit();
            }
        }
        return firstTime;
    }


    private void startBoard () {

        squares[0][0] = findViewById(R.id.square1x1);
        squares[0][1] = findViewById(R.id.square1x2);
        squares[0][2] = findViewById(R.id.square1x3);
        squares[0][3] = findViewById(R.id.square1x4);
        squares[0][4] = findViewById(R.id.square1x5);
        squares[0][5] = findViewById(R.id.square1x6);
        squares[0][6] = findViewById(R.id.square1x7);
        squares[0][7] = findViewById(R.id.square1x8);

        squares[1][0] = findViewById(R.id.square2x1);
        squares[1][1] = findViewById(R.id.square2x2);
        squares[1][2] = findViewById(R.id.square2x3);
        squares[1][3] = findViewById(R.id.square2x4);
        squares[1][4] = findViewById(R.id.square2x5);
        squares[1][5] = findViewById(R.id.square2x6);
        squares[1][6] = findViewById(R.id.square2x7);
        squares[1][7] = findViewById(R.id.square2x8);

        squares[2][0] = findViewById(R.id.square3x1);
        squares[2][1] = findViewById(R.id.square3x2);
        squares[2][2] = findViewById(R.id.square3x3);
        squares[2][3] = findViewById(R.id.square3x4);
        squares[2][4] = findViewById(R.id.square3x5);
        squares[2][5] = findViewById(R.id.square3x6);
        squares[2][6] = findViewById(R.id.square3x7);
        squares[2][7] = findViewById(R.id.square3x8);

        squares[3][0] = findViewById(R.id.square4x1);
        squares[3][1] = findViewById(R.id.square4x2);
        squares[3][2] = findViewById(R.id.square4x3);
        squares[3][3] = findViewById(R.id.square4x4);
        squares[3][4] = findViewById(R.id.square4x5);
        squares[3][5] = findViewById(R.id.square4x6);
        squares[3][6] = findViewById(R.id.square4x7);
        squares[3][7] = findViewById(R.id.square4x8);

        squares[4][0] = findViewById(R.id.square5x1);
        squares[4][1] = findViewById(R.id.square5x2);
        squares[4][2] = findViewById(R.id.square5x3);
        squares[4][3] = findViewById(R.id.square5x4);
        squares[4][4] = findViewById(R.id.square5x5);
        squares[4][5] = findViewById(R.id.square5x6);
        squares[4][6] = findViewById(R.id.square5x7);
        squares[4][7] = findViewById(R.id.square5x8);

        squares[5][0] = findViewById(R.id.square6x1);
        squares[5][1] = findViewById(R.id.square6x2);
        squares[5][2] = findViewById(R.id.square6x3);
        squares[5][3] = findViewById(R.id.square6x4);
        squares[5][4] = findViewById(R.id.square6x5);
        squares[5][5] = findViewById(R.id.square6x6);
        squares[5][6] = findViewById(R.id.square6x7);
        squares[5][7] = findViewById(R.id.square6x8);

        squares[6][0] = findViewById(R.id.square7x1);
        squares[6][1] = findViewById(R.id.square7x2);
        squares[6][2] = findViewById(R.id.square7x3);
        squares[6][3] = findViewById(R.id.square7x4);
        squares[6][4] = findViewById(R.id.square7x5);
        squares[6][5] = findViewById(R.id.square7x6);
        squares[6][6] = findViewById(R.id.square7x7);
        squares[6][7] = findViewById(R.id.square7x8);

        squares[7][0] = findViewById(R.id.square8x1);
        squares[7][1] = findViewById(R.id.square8x2);
        squares[7][2] = findViewById(R.id.square8x3);
        squares[7][3] = findViewById(R.id.square8x4);
        squares[7][4] = findViewById(R.id.square8x5);
        squares[7][5] = findViewById(R.id.square8x6);
        squares[7][6] = findViewById(R.id.square8x7);
        squares[7][7] = findViewById(R.id.square8x8);

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                squares[i][j].setOnClickListener(this);
                squares[i][j].setBackground(findViewById(R.id.button2).getBackground());
                Log.i(TAG, "OnCLickListener set");
            }
        squares[3][3].setBackground(userButtonIcon);
        squares[3][4].setBackground(computerButtonIcon);
        squares[4][3].setBackground(computerButtonIcon);
        squares[4][4].setBackground(userButtonIcon);

        matrix[3][3] = 1;
        matrix[4][3] = 2;
        matrix[3][4] = 2;
        matrix[4][4] = 1;


    }

}
