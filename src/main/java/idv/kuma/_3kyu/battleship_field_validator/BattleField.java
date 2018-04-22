package idv.kuma._3kyu.battleship_field_validator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BattleField {


//    https://stackoverflow.com/questions/7501344/how-to-validate-battleship-field

    public static boolean fieldValidator(int[][] field) {

        if (!preCheck(field)) return false;

        occupied = new int[field.length][field[0].length];

        doProcess(field);


        return false;
    }

    private  static boolean preCheck(int[][] field){
        return true;
    }

    private static void doProcess(int[][] field){
        for (){

        }
    }

}