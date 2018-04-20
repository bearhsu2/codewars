package idv.kuma._4kyu.sudoku_solution_validator;

import java.util.Arrays;
import java.util.HashSet;

public class SudokuValidator {
    public static boolean check(int[][] sudoku) {
        //do your magic

        return checkRows(sudoku) && checkColumns(sudoku) && checkSubBlocks(sudoku);
    }

    private static boolean checkRows(int[][] sudoku){
        for (int i = 0; i < sudoku.length; i++){
            if (!Arrays.stream(sudoku[i]).allMatch(new HashSet<>()::add) || Arrays.stream(sudoku[i]).anyMatch(e -> e == 0)) return false;
        }
        return true;
    }
    private static boolean checkColumns(int[][] sudoku){

        for (int j = 0; j < sudoku[0].length; j++){

            int[] column = new int[sudoku.length];
            for (int i = 0; i < sudoku.length; i++){
                column[i] = sudoku[i][j];
            }

            if (!Arrays.stream(column).allMatch(new HashSet<>()::add) || Arrays.stream(column).anyMatch(e -> e == 0)) return false;

        }

        return true;
    }

    private static boolean checkSubBlocks(int[][] sudoku){
        return true;
    }
}