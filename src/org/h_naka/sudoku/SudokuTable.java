package org.h_naka.sudoku;

public class SudokuTable {
    public static final int TABLE_SIZE = 9 * 9;
    private final int COLUMN_SIZE = 9;
    private final int ROW_SIZE = 9;
    private int [][] m_table;

    public SudokuTable() {
        m_table = new int[9][9];
    }

    public int [][] getTable() {
        return m_table;
    }

    public int getColumnSize() {
        return COLUMN_SIZE;
    }

    public int getRowSize() {
        return ROW_SIZE;
    }

    public boolean setTable(String args[]) {
        int k = 0;
        for (int j = 0;j < COLUMN_SIZE;j++) {
            for (int i = 0;i < ROW_SIZE;i++) {
                try {
                    m_table[j][i] = Integer.parseInt(args[k]);
                    k++;
                    if (m_table[j][i] < 0 || m_table[j][i] > 9) {
                        return false;
                    }
                } catch(NumberFormatException e) {
                    return false;
                }
            }
        }
        return true;
    }

    public void dispTable() {
        for (int j = 0;j < COLUMN_SIZE;j++) {
            for (int i = 0;i < ROW_SIZE;i++) {
                if (m_table[j][i] == 0) {
                    System.out.printf("* ");
                } else {
                    System.out.printf("%d ",m_table[j][i]);
                }
            }
            System.out.println("");
        }
    }
}