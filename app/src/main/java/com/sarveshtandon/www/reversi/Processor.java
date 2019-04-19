package com.sarveshtandon.www.reversi;





import android.os.CountDownTimer;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

public class Processor {
    int cal=0;
    MoveReturn moveReturn= new MoveReturn();
    ComputerMoveReturn computerMoveReturn = new ComputerMoveReturn();
    public MoveReturn Move(int[][] matrix,int row, int col) {
        int lastRow = row, lastCol = col, count[] = new int[8],totalCount=0;
        boolean temp = true;
        do {
            lastCol++;
            if (lastCol < 8 && lastRow < 8 && lastCol >= 0 && lastRow >= 0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[3]++;
            }
            else {
                temp = false;
                lastCol=7;

            }
        }while((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&(lastCol!=7));
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[3] = 0;
        lastCol = col;
        lastRow = row;
        temp= true;
        do {
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[7]++;
            }
            else {
                temp = false;
                lastCol=0;

            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[7] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[1]++;
            }
            else {
                temp = false;
                lastRow=7;

            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastRow!=7);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[1] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[5]++;
            }
            else {
                temp = false;
                lastRow=0;

            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastRow!=0);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2) {
            count[5] = 0;
            Log.i("Count","lastcol--"+Integer.toString(lastCol)+"lastRow---"+Integer.toString(lastRow));
        }
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            lastCol++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[2]++;
            }
            else {
                temp = false;
                lastCol=7;
                lastRow=7;

            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=7&&lastRow!=7);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[2] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow--;
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[6]++;
            }
            else {
                temp = false;
                lastCol=0;
                lastRow=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0&&lastRow!=0);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[6] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow--;
            lastCol++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[4]++;
            }
            else {
                temp = false;
                lastCol=0;
                lastRow=7;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=7&&lastRow!=0);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[4] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[0]++;
            }
            else {
                temp = false;
                lastCol=7;
                lastRow=0;



            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0&&lastRow!=7);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[0] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;

        for(int i =0;i<8;i++) {
            totalCount = totalCount + count[i];
            Log.i("Count","----"+Integer.toString(count[i])+",");
        }
        if(totalCount!=0) {
            if (count[3] != 0) {
                lastCol++;
                do {
                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                        if (matrix[lastCol][lastRow] == 2) {
                            matrix[lastCol][lastRow] = 1;
                            lastCol++;
                        }
                    }
                    else{
                        temp = false;
                        lastCol=7;
                    }

                }while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8  && lastCol>=0 && lastRow>=0)&&lastCol!=7);
                lastCol = col;
                lastRow = row;
                temp = true;
            }
            if (count[7] != 0) {
                lastCol--;
                do {

                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                        if (matrix[lastCol][lastRow] == 2) {
                            matrix[lastCol][lastRow] = 1;
                            lastCol--;
                        }
                    }
                    else{
                        temp = false;
                        lastCol=0;

                    }

                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8  && lastCol>=0 && lastRow>=0&&lastCol!=0);
                lastCol = col;
                lastRow = row;
                temp = true;
            }
            if (count[1] != 0) {
                lastRow++;
                do {

                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                        if (matrix[lastCol][lastRow] == 2) {
                            matrix[lastCol][lastRow] = 1;
                            lastRow++;
                        }
                    }
                    else{
                        temp = false;
                        lastRow=7;
                    }

                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8  && lastCol>=0 && lastRow>=0 &&lastRow!=7);
                lastCol = col;
                lastRow = row;
                temp = true;
            }
            if (count[5] != 0) {
                lastRow--;
                do {

                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                        if (matrix[lastCol][lastRow] == 2) {
                            matrix[lastCol][lastRow] = 1;
                            lastRow--;
                        }
                    }
                    else{
                        lastRow=0;
                        temp = false;
                    }
                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0 &&lastRow!=0);
                lastCol = col;
                lastRow = row;
                temp = true;
            }
            if (count[2] != 0) {
                lastRow++;
                lastCol++;
                do {

                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                        if (matrix[lastCol][lastRow] == 2) {
                            matrix[lastCol][lastRow] = 1;
                            lastRow++;
                            lastCol++;
                        }
                    }
                    else{
                        temp = false;
                        lastCol=7;
                        lastRow=7;

                    }
                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8  && lastCol>=0 && lastRow>=0 &&lastCol!=7&&lastRow!=7);
                lastCol = col;
                lastRow = row;
                temp = true;
            }
            if (count[6] != 0) {
                lastRow--;
                lastCol--;
                do {
                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                        if (matrix[lastCol][lastRow] == 2){
                            matrix[lastCol][lastRow] = 1;
                            lastRow--;
                            lastCol--;}
                    }
                    else{
                        temp = false;
                        lastCol=0;
                        lastRow=0;

                    }

                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8  && lastCol>=0 && lastRow>=0 && lastCol!=0 && lastRow!=0);
                lastCol = col;
                lastRow = row;
                temp = true;
            }
            if (count[4] != 0) {
                lastRow--;
                lastCol++;
                do {
                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                        if (matrix[lastCol][lastRow] == 2){
                            matrix[lastCol][lastRow] = 1;
                            lastRow--;
                            lastCol++;
                        }
                    }
                    else{
                        temp = false;
                        lastCol=7;
                        lastRow=0;

                    }
                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8  && lastCol>=0 && lastRow>=0 && lastCol!=7 && lastRow!=0);
                lastCol = col;
                lastRow = row;
                temp = true;
            }
            if (count[0] != 0) {
                lastRow++;
                lastCol--;
                do {
                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                        if (matrix[lastCol][lastRow] == 2) {
                            matrix[lastCol][lastRow] = 1;
                            lastRow++;
                            lastCol--;
                        }
                    }
                    else{
                        temp = false;
                        lastCol=0;
                        lastRow=7;

                    }
                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8  && lastCol>=0 && lastRow>=0&& lastCol!=0 &&lastRow!=7);
                lastCol = col;
                lastRow = row;
                temp = true;
            }
            moveReturn.setMatrix(matrix);
            moveReturn.setValid(true);
        }
        else {
            matrix[col][row] = 0;
            moveReturn.setMatrix(matrix);
            moveReturn.setValid(false);
        }
        return moveReturn;
    }
    public ComputerMoveReturn computerMove(int[][] matrix){
        int totalCountMatrix[][]= new int[8][8],strategicMatrix[][]= new int[8][8],riskMatrix[][] = new int[8][8];
        int[][] totaCountMatrix = new int[8][8];
        int row=0,col=0,highestCount =-1000,row2=0,col2=0;
        strategicMatrix = strategic(matrix);
        riskMatrix = risk(matrix);
        for(int i=0;i<8;i++){
            for (int j =0;j<8;j++){

                if(matrix[i][j]==0) {

                    totaCountMatrix[i][j] = returnTotalCount(matrix, i, j);
                    if(totaCountMatrix[i][j]!=0)
                        totalCountMatrix[i][j]=strategicMatrix[i][j]+totaCountMatrix[i][j]+riskMatrix[i][j];
                    if(i==6||i==1||j==6||j==1){
                        if(totalCountMatrix[i][j]!=0 )
                            totalCountMatrix[i][j]-=2;
                    }
                    if(i==7||i==0||j==7||j==0) {
                        if(totalCountMatrix[i][j]!=0)
                            totalCountMatrix[i][j] += 0;
                    }
                    // if((i==7&&(j==6 || j==1))||(i==0&&(j==6||j==1))||(j==7&&(i==6||i==1))||(j==0&&(i==6||i==1))||(j==6&&(i==6||i==1))||(j==1&&(i==1||i==6))){
                    //     if(totalCountMatrix[i][j]!=0)
                    //         totalCountMatrix[i][j]-=20;
                    // }
                    if(totalCountMatrix[i][j]!=0) {
                        if(matrix[0][0]==0) {
                            if (i == 0 && j == 1)
                                totalCountMatrix[i][j]-=10;
                            if (i == 1 && (j == 0 || j == 1))
                                totalCountMatrix[i][j]-=10;
                        }
                        if(matrix[7][0]==0) {
                            if (i == 6 & (j == 0 || j == 1))
                                totalCountMatrix[i][j]-=10;
                            if (i == 7 && j == 1)
                                totalCountMatrix[i][j]-=10;
                        }
                        if(matrix[0][7]==0) {
                            if (i == 0 && j == 6)
                                totalCountMatrix[i][j]-=10;
                            if (i == 1 && (j == 6 || j == 7))
                                totalCountMatrix[i][j]-=10;
                        }
                        if(matrix[7][7]==0) {
                            if (i == 6 && (j == 6 || j == 7))
                                totalCountMatrix[i][j]-=10;
                            if (i == 7 && j == 6)
                                totalCountMatrix[i][j]-=10;
                        }
                    }
                    if(j==7&&(i==0||i==7) || j==0&&(i==0||i==7)){
                        if(totalCountMatrix[i][j]!=0)
                            totalCountMatrix[i][j]+=20;
                    }
                    if(totaCountMatrix[i][j]>0&&totalCountMatrix[i][j]==0)
                        totalCountMatrix[i][j]++;
                    if(totalCountMatrix[i][j]>highestCount&& totalCountMatrix[i][j]!=0 ) {
                        highestCount = totalCountMatrix[i][j];
                        row=i;
                        col=j;
                    }
                }
            }
        }
        String log = "";
        for(int i =0;i<8;i++) {
            for(int j =0;j<8;j++){
                log = log +Integer.toString(totaCountMatrix[i][j])+",";
            }
            log = log +"\n";
        }
        Log.i("Tota Count", log);
        log = "";
        for(int i =0;i<8;i++) {
            for(int j =0;j<8;j++){
                log = log +Integer.toString(strategicMatrix[i][j])+",";
            }
            log = log +"\n";
        }
        Log.i("Strat Count", log);
        log = "";
        for(int i =0;i<8;i++) {
            for(int j =0;j<8;j++){
                log = log +Integer.toString(totaCountMatrix[i][j])+",";
            }
            log = log +"\n";
        }
        Log.i("Total Count", log);
        if(highestCount==0|| highestCount==-1000) {
            computerMoveReturn.setYouWon(-1);
        }
        else {
            matrix[row][col] = 2;
            computerMoveReturn.setRow(row);
            computerMoveReturn.setCol(col);
            Log.i("Computer Move", "  row----" + Integer.toString(row) + "   col---- " + Integer.toString(col));
            Log.i("Computer Move", "  Highest Count----" + Integer.toString(highestCount));
            matrix = compMoveEval(matrix, row, col);
        }
        log="";
        for(int i =0;i<8;i++) {
            for(int j =0;j<8;j++){
                log = log +matrix[i][j]+",";
            }
            log = log +"\n";
        }
        Log.i("Matrix" , log);
        computerMoveReturn.setMatrix(matrix);

        return computerMoveReturn;
    }

    private int[][] risk(int[][] matrix) {
        int riskMatrix[][] = new int[8][8];

        return matrix;
    }

    public int returnTotalCount(int [][] matrix,int col,int row){
        int lastRow = row, lastCol = col, count[] = new int[8],totalCount=0,makeZero[] = new int[8];
        boolean temp = true;
        for(int i =0;i<8;i++)
            makeZero[i]=0;
        do {
            lastCol++;
            if (lastCol < 8 && lastRow < 8 && lastCol >= 0 && lastRow >= 0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[3]++;
            }
            else {
                temp = false;
                lastCol=7;
                count[3] =0;
            }
        }while((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&(lastCol!=7));
        if (matrix[lastCol][lastRow] == 0 || matrix[lastCol][lastRow] ==1) {
            makeZero[3]=1;
        }

        lastCol = col;
        lastRow = row;
        temp= true;
        do {
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[7]++;
            }
            else {
                temp = false;
                lastCol=0;
                count[7]=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0);
        if (matrix[lastCol][lastRow] == 0|| matrix[lastCol][lastRow] ==1) {
            makeZero[7]=1;
            //makeZero[3]=1;
        }
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[1]++;
            }
            else {
                temp = false;
                lastRow=7;
                count[1]=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastRow!=7);
        if (matrix[lastCol][lastRow] == 0|| matrix[lastCol][lastRow] ==1) {
            makeZero[1]=1;
            //    makeZero[5]=1;
        }
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[5]++;
            }
            else {
                temp = false;
                lastRow=0;
                count[5]=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastRow!=0);
        if (matrix[lastCol][lastRow] == 0|| matrix[lastCol][lastRow] ==1) {
            //    makeZero[1]=1;
            makeZero[5]=1;
        }
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            lastCol++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[2]++;
            }
            else {
                temp = false;
                lastCol=7;
                lastRow=7;
                count[2]=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=7&&lastRow!=7);
        if (matrix[lastCol][lastRow] == 0|| matrix[lastCol][lastRow] ==1) {
            makeZero[2]=1;
            //  makeZero[6]=1;
        }
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow--;
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[6]++;
            }
            else {
                temp = false;
                lastCol=0;
                lastRow=0;
                count[6]=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0&&lastRow!=0);
        if (matrix[lastCol][lastRow] == 0|| matrix[lastCol][lastRow] ==1){
            // makeZero[2]=1;
            makeZero[6]=1;
        }
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow--;
            lastCol++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[4]++;
            }
            else {
                temp = false;
                lastCol=0;
                lastRow=7;
                count[4]=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=7&&lastRow!=0);
        if (matrix[lastCol][lastRow] == 0|| matrix[lastCol][lastRow] ==1){
            makeZero[4]=1;
            //makeZero[0]=1;
        }
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[0]++;
            }
            else {
                temp = false;
                lastCol=7;
                lastRow=0;
                count[0]=0;


            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0&&lastRow!=7);
        if (matrix[lastCol][lastRow] == 0|| matrix[lastCol][lastRow] ==1){
            //makeZero[4]=1;
            makeZero[0]=1;
        }
        for(int i =0;i<8;i++)
            if(makeZero[i]==1)
                count[i]=0;
        for(int i =0;i<8;i++) {
            totalCount = totalCount + count[i];
        }
        return totalCount;
    }
    public int[][] compMoveEval(int [][] matrix, int col,int row){
        int lastRow = row, lastCol = col, count[] = new int[8],totalCount=0,check=0;
        boolean temp = true;
        do {
            lastCol++;

            if (lastCol < 8 && lastRow < 8 && lastCol >= 0 && lastRow >= 0) {

                if (matrix[lastCol][lastRow] == 1)
                    count[3]++;

            }
            else {
                temp = false;
                lastCol=7;
            }

        }while((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&(lastCol!=7));
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==1 )
            count[3] = 0;
        lastCol = col;
        lastRow = row;
        temp= true;

        do {
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {

                if (matrix[lastCol][lastRow] == 1)
                    count[7]++;

            }
            else {
                temp = false;
                lastCol=0;

            }


        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==1 )
            count[7] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {

                if (matrix[lastCol][lastRow] == 1) {
                    count[1]++;

                }
            }
            else {
                temp = false;
                lastRow=7;

            }

        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastRow!=7);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==1 )
            count[1] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow--;

            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {

                if (matrix[lastCol][lastRow] == 1)
                    count[5]++;
            }
            else {
                temp = false;
                lastRow=0;

            }


        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastRow!=0);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==1 )
            count[5] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            lastCol++;

            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[2]++;

            }
            else {
                temp = false;
                lastCol=7;
                lastRow=7;

            }


        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=7&&lastRow!=7);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==1 )
            count[2] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;

        do {
            lastRow--;
            lastCol--;

            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {

                if (matrix[lastCol][lastRow] == 1)
                    count[6]++;

            }
            else {
                temp = false;
                lastCol=0;
                lastRow=0;


            }

        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0&&lastRow!=0);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==1 )
            count[6] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;

        do {
            lastRow--;
            lastCol++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[4]++;
            }

            else {
                temp = false;
                lastCol=0;
                lastRow=7;
            }


        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=7&&lastRow!=0);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==1 )
            count[4] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;

        do {
            lastRow++;
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {

                if (matrix[lastCol][lastRow] == 1)
                    count[0]++;

            }
            else {
                temp = false;
                lastCol=7;
                lastRow=0;
            }

        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0&&lastRow!=7);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==1)
            count[0] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;

        for(int i =0;i<8;i++)
            totalCount=totalCount+count[i];

        if(totalCount!=0) {
            if (count[3] != 0) {
                do {
                    if(check!=1){
                        lastCol++;
                    }
                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {

                        if (matrix[lastCol][lastRow] == 1&&lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                            matrix[lastCol][lastRow] = 2;
                            lastCol++;
                            check=1;
                        }
                    }
                    else{
                        temp = false;
                        lastCol=7;
                    }

                }while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8  && lastCol>=0 && lastRow>=0)&&lastCol!=7);
                lastCol = col;
                lastRow = row;
                temp = true;
                check=0;
            }
            if (count[7] != 0) {
                do {
                    if(check!=1) {
                        lastCol--;
                    }
                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {

                        if (matrix[lastCol][lastRow] == 1 && lastCol < 8 && lastRow < 8 && lastCol >= 0 && lastRow >= 0) {
                            matrix[lastCol][lastRow] = 2;
                            lastCol--;
                            check=1;
                        }
                    }
                    else{
                        temp = false;
                        lastCol=0;

                    }

                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8  && lastCol>=0 && lastRow>=0&&lastCol!=0);
                lastCol = col;
                lastRow = row;
                temp = true;
                check=0;
            }
            if (count[1] != 0) {
                do {
                    if(check!=1)
                        lastRow++;
                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {

                        if (matrix[lastCol][lastRow] == 1 && lastCol < 8 && lastRow < 8 && lastCol >= 0 && lastRow >= 0) {
                            matrix[lastCol][lastRow] = 2;
                            lastRow++;
                            check=1;
                        }
                    }
                    else{
                        temp = false;
                        lastRow=7;


                    }

                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0 &&lastRow!=7);
                lastCol = col;
                lastRow = row;
                temp = true;
                check=0;
            }
            if (count[5] != 0) {
                do {
                    if(check!=1){
                        lastRow--;
                    }
                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {

                        if (matrix[lastCol][lastRow] == 1&&lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                            matrix[lastCol][lastRow] = 2;
                            lastRow--;
                            check=1;
                        }
                    }
                    else{
                        lastRow=0;
                        temp = false;
                    }

                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0 &&lastRow!=0);
                lastCol = col;
                lastRow = row;
                temp = true;
                check=0;
            }
            if (count[2] != 0) {
                do {
                    if(check!=1) {
                        lastRow++;
                        lastCol++;
                    }
                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {

                        if (matrix[lastCol][lastRow] == 1&&lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                            matrix[lastCol][lastRow] = 2;
                            lastRow++;
                            lastCol++;
                            check=1;
                        }
                    }
                    else{
                        temp = false;
                        lastCol=7;
                        lastRow=7;

                    }

                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8  && lastCol>=0 && lastRow>=0 &&lastCol!=7&&lastRow!=7);
                lastCol = col;
                lastRow = row;
                temp = true;
                check=0;
            }
            if (count[6] != 0) {
                do {
                    if(check!=1) {
                        lastRow--;
                        lastCol--;
                    }
                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {

                        if (matrix[lastCol][lastRow] == 1&&lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                            matrix[lastCol][lastRow] = 2;
                            lastRow--;
                            lastCol--;
                            check=1;
                        }
                    }
                    else{
                        temp = false;
                        lastCol=0;
                        lastRow=0;

                    }


                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8  && lastCol>=0 && lastRow>=0 && lastCol!=0 && lastRow!=0);
                lastCol = col;
                lastRow = row;
                temp = true;
                check=0;
            }
            if (count[4] != 0) {
                do {
                    if(check!=1) {
                        lastRow--;
                        lastCol++;
                    }
                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                        if (matrix[lastCol][lastRow] == 1&&lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                            matrix[lastCol][lastRow] = 2;
                            lastRow--;
                            lastCol++;
                            check=1;
                        }
                    }
                    else{
                        temp = false;
                        lastCol=7;
                        lastRow=0;

                    }

                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0 && lastCol!=7 && lastRow!=0);
                lastCol = col;
                lastRow = row;
                temp = true;
                check=0;
            }
            if (count[0] != 0) {
                do {
                    if(check!=1) {
                        lastRow++;
                        lastCol--;
                    }
                    if(lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                        if (matrix[lastCol][lastRow] == 1 &&lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0) {
                            matrix[lastCol][lastRow] = 2;
                            lastRow++;
                            lastCol--;
                            check=1;
                        }
                    }
                    else{
                        temp = false;
                        lastCol=0;
                        lastRow=7;

                    }

                }while (matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0&& lastCol!=0 &&lastRow!=7);
                lastCol = col;
                lastRow = row;
                temp = true;
                check=0;
            }
        }
        else
            matrix[col][row]=0;
        return matrix;
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
        return matrix;
    }
    public int[][] strategic(int[][] matrix){
        int strategicCountMatrix[][]= new int[8][8];
        int row=0,col=0,highestCount =-1000;

        for(int i=0;i<8;i++){
            for (int j =0;j<8;j++){
                if(matrix[i][j]==1) {
                    strategicCountMatrix[i][j] = returnStrategicCount(matrix, i, j);

                }
                if(matrix[i][j]==0){
                    strategicCountMatrix[i][j] = returnStrategicCount(matrix, i, j)/5;
                }
            }
        }
        String log = "";
        for(int i =0;i<8;i++) {
            for(int j =0;j<8;j++){
                log = log +Integer.toString(strategicCountMatrix[i][j])+",";
            }
            log = log +"\n";
        }
        Log.i("Strategic Count", log);

        return strategicCountMatrix;
    }
    public int returnStrategicCount(int [][] matrix,int col,int row){ int lastRow = row, lastCol = col, count[] = new int[8],totalCount=0;
        boolean temp = true;
        do {
            lastCol++;
            if (lastCol < 8 && lastRow < 8 && lastCol >= 0 && lastRow >= 0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[3]++;
            }
            else {
                temp = false;
                lastCol=7;
                count[3] =0;
            }
        }while((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&(lastCol!=7));
        if (matrix[lastCol][lastRow] != 0)
            count[3] = 0;
        lastCol = col;
        lastRow = row;
        temp= true;
        do {
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[7]++;
            }
            else {
                temp = false;
                lastCol=0;
                count[7]=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0);
        if (matrix[lastCol][lastRow] !=0)
            count[7] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[1]++;
            }
            else {
                temp = false;
                lastRow=7;
                count[1]=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastRow!=7);
        if (matrix[lastCol][lastRow] !=0) {
            count[1] = 0;
        }
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[5]++;
            }
            else {
                temp = false;
                lastRow=0;
                count[5]=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastRow!=0);
        if (matrix[lastCol][lastRow] !=0)
            count[5] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            lastCol++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[2]++;
            }
            else {
                temp = false;
                lastCol=7;
                lastRow=7;
                count[2]=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=7&&lastRow!=7);
        if (matrix[lastCol][lastRow] !=0)
            count[2] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow--;
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[6]++;
            }
            else {
                temp = false;
                lastCol=0;
                lastRow=0;
                count[6]=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0&&lastRow!=0);
        if (matrix[lastCol][lastRow] !=0)
            count[6] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow--;
            lastCol++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[4]++;
            }
            else {
                temp = false;
                lastCol=0;
                lastRow=7;
                count[4]=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=7&&lastRow!=0);
        if (matrix[lastCol][lastRow] !=0)
            count[4] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 1)
                    count[0]++;
            }
            else {
                temp = false;
                lastCol=7;
                lastRow=0;
                count[0]=0;


            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 2 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0&&lastRow!=7);
        if (matrix[lastCol][lastRow] !=0)
            count[0] = 0;
        cal++;
        for(int i =0;i<8;i++) {
            totalCount = totalCount + count[i];
        }
        return totalCount;
    }
    public boolean userMovePossibility(int [][] matrix,int col, int row){
        boolean validity=false;
        for(int i =0;i<8;i++){
            for(int j=0;j<8;j++){
                if(matrix[j][i]==0) {
                    if (returnUserMovePossibility(matrix, j, i) > 0) {
                        Log.i("User Move Possibility", "i-->" + Integer.toString(i) + " j-->" + Integer.toString(j));
                        validity = true;
                        break;
                    }
                }
            }
        }
        return validity;
    }
    public int returnUserMovePossibility (int [][] matrix,int col, int row){
        int lastRow = row, lastCol = col, count[] = new int[8],totalCount=0;
        boolean temp = true;
        do {
            lastCol++;
            if (lastCol < 8 && lastRow < 8 && lastCol >= 0 && lastRow >= 0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[3]++;
            }
            else {
                temp = false;
                lastCol=7;

            }
        }while((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&(lastCol!=7));
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[3] = 0;
        lastCol = col;
        lastRow = row;
        temp= true;
        do {
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[7]++;
            }
            else {
                temp = false;
                lastCol=0;

            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[7] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[1]++;
            }
            else {
                temp = false;
                lastRow=7;

            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastRow!=7);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[1] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[5]++;
            }
            else {
                temp = false;
                lastRow=0;

            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastRow!=0);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2) {
            count[5] = 0;
            Log.i("Count","lastcol--"+Integer.toString(lastCol)+"lastRow---"+Integer.toString(lastRow));
        }
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            lastCol++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[2]++;
            }
            else {
                temp = false;
                lastCol=7;
                lastRow=7;

            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=7&&lastRow!=7);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[2] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow--;
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[6]++;
            }
            else {
                temp = false;
                lastCol=0;
                lastRow=0;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0&&lastRow!=0);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[6] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow--;
            lastCol++;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[4]++;
            }
            else {
                temp = false;
                lastCol=0;
                lastRow=7;
            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=7&&lastRow!=0);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[4] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;
        do {
            lastRow++;
            lastCol--;
            if(lastCol < 8 &&lastRow <8 && lastCol>=0 && lastRow>=0) {
                if (matrix[lastCol][lastRow] == 2)
                    count[0]++;
            }
            else {
                temp = false;
                lastCol=7;
                lastRow=0;



            }
        } while ((matrix[lastCol][lastRow] != 0 && matrix[lastCol][lastRow] != 1 && lastCol < 8 && lastRow <8 && lastCol>=0 && lastRow>=0)&&temp&&lastCol!=0&&lastRow!=7);
        if (matrix[lastCol][lastRow] == 0||matrix[lastCol][lastRow] ==2)
            count[0] = 0;
        lastCol = col;
        lastRow = row;
        temp = true;

        for(int i =0;i<8;i++) {
            totalCount = totalCount + count[i];
            Log.i("Count","----"+Integer.toString(count[i])+",");
        }
        return totalCount;
    }
}

