package idv.kuma._4kyu.sudoku_solution_validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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


        int length = sudoku.length;
        List<Integer>[][] subArrays = new ArrayList[3][3];
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                int indexI = i/3;
                int indexJ = j/3;
                if (subArrays[indexI][indexJ] == null){
                    subArrays[indexI][indexJ] = new ArrayList<>();
                }
                subArrays[i/3][j/3].add(sudoku[i][j]);
            }
        }

        for (int i = 0; i < subArrays.length; i++){
            for (int j = 0; j < subArrays[0].length; j++){
                List<Integer> list = subArrays[i][j];

                if (!list.stream().allMatch(new HashSet<>()::add) || list.stream().anyMatch(e -> e == 0)) return false;
            }
        }


        return true;
    }
}