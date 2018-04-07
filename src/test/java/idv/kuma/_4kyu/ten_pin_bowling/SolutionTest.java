package idv.kuma._4kyu.ten_pin_bowling;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.runners.JUnit4;

import java.util.Random;


public class SolutionTest {

    @Test
    public void all_zeros() throws Exception {
        assertEquals(0, Solution.bowling_score("00 00 00 00 00 00 00 00 00 00"));

    }

    @Test
    public void all_ones() throws Exception {
        // assertEquals("expected", "actual");
        System.out.println("Maybe this bowler should put bumpers on...\n ");
        assertEquals(20, Solution.bowling_score("11 11 11 11 11 11 11 11 11 11"));
    }

    @Ignore
    @Test
    public void perfect_game() {
        System.out.println("Woah! Perfect game!");
        assertEquals(300, Solution.bowling_score("X X X X X X X X X XXX"));
    }
}