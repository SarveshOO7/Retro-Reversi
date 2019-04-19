package com.sarveshtandon.www.reversi;

public class MoveReturn {
    int matrix[][] = new int[8][8];
    boolean isValid = false;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
