package idv.kuma._2kyu.insane_colored_triangle;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleTests {

    @Test
    public void One_Line_B_B() throws Exception {
        assertEquals('B', Kata.triangle("B"));
    }

    @Ignore
    @Test
    public void examples() {
        assertEquals('R', Kata.triangle("GB"));
        assertEquals('R', Kata.triangle("RRR"));
        assertEquals('B', Kata.triangle("RGBG"));
        assertEquals('G', Kata.triangle("RBRGBRB"));
        assertEquals('G', Kata.triangle("RBRGBRBGGRRRBGBBBGG"));

    }
}