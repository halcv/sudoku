package org.h_naka.sudoku;

public class SudokuMain {
    public static void main(String args[]) {
        if (args.length != Sudoku.TABLE_SIZE) {
            System.out.println("引数が足りません。");
            return;
        }

        Sudoku sudoku = new Sudoku();
        if (sudoku.setTable(args) == false) {
            System.out.println("引数が正しくありません。\n0から9までの数を半角スペース区切りで入力してください。");
            return;
        }

        System.out.println("----- 問題 -----");
        sudoku.dispTable();
        sudoku.solve(0,0);
        System.out.println("----- 解答 -----");
        sudoku.dispTable();
    }
}
