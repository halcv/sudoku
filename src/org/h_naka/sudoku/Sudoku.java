package org.h_naka.sudoku;


//1 7 2 0 5 0 0 8 0 0 0 6 8 0 9 0 0 0 0 4 0 3 0 0 0 2 0 0 0 0 0 0 3 0 9 0 2 0 7 0 0 0 6 0 1 0 8 0 6 0 0 0 0 0 0 6 0 0 0 8 0 4 0 0 0 0 7 0 1 9 0 0 0 1 0 0 4 0 2 6 3

public class Sudoku extends SudokuTable {

    public int solve(int column,int row) {
        int value;
        int [][] table = getTable();
        
        if (column == getColumnSize()) {
            column = 0;
            if (++row == getRowSize()) {
                return 1;
            }
        }

        if (table[column][row] != 0) {
            return solve(column + 1, row);
        }

        for (value = 1;value <= getColumnSize();value++) {
            if (legal(column,row,value) == 1) {
                table[column][row] = value;
                if (solve(column + 1,row) == 1) {
                    return 1;
                }
            }
        }
        table[column][row] = 0;
        return 0;
    }

    private int legal(int column,int row,int value) {
        int i;
        int j;
        int boxColumnOffset;
        int boxRowOffset;
        int [][] table = getTable();
        
        for (j = 0;j < getColumnSize();j++) {
            if (value == table[j][row]) {
                return 0;
            }
        }

        for (i = 0;i < getRowSize();i++) {
            if (value == table[column][i]) {
                return 0;
            }
        }

        boxRowOffset = (row / 3) * 3;
        boxColumnOffset = (column / 3) * 3;
        for (j = 0;j < 3;j++) {
            for (i = 0;i < 3;++i) {
                if (value == table[boxColumnOffset + j][boxRowOffset + i]) {
                    return 0;
                }
            }
        }
        return 1;
    }
}