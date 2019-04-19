package com.sarveshtandon.www.reversi;

public class ComputerMoveReturn {
    int matrix[][] = new int[8][8],youWon=0;
    boolean isValid;
    int row, col;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getYouWon() {
        return youWon;
    }

    public void setYouWon(int youWon) {
        this.youWon = youWon;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public ComputerMoveReturn() {
        this.youWon = 0;
    }
}
