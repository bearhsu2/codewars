package idv.kuma._2kyu.insane_colored_triangle;

import org.junit.Test;

import static org.junit.Assert.*;


public class ExampleTests {

    @Test
    public void One_Line_B_B() throws Exception {
        assertEquals('B', Kata.triangle("B"));
    }

    @Test
    public void One_Line_R_R() throws Exception {
        assertEquals('R', Kata.triangle("R"));
    }

    @Test
    public void One_Line_G_G() throws Exception {
        assertEquals('G', Kata.triangle("G"));
    }

    @Test
    public void Two_Lines_RR_R() throws Exception {
        assertEquals('R', Kata.triangle("RR"));
    }

    @Test
    public void Two_Lines_BB_B() throws Exception {
        assertEquals('B',  Kata.triangle("BB"));
    }

    @Test
    public void Two_Lines_GG_G() throws Exception {
        assertEquals('G',  Kata.triangle("GG"));
    }

    @Test
    public void Two_Lines_RB_G() throws Exception {
        assertEquals('G',  Kata.triangle("RB"));
    }

    @Test
    public void Two_Lines_BG_R() throws Exception {
        assertEquals('R',  Kata.triangle("GB"));
        assertEquals('R',  Kata.triangle("BG"));
    }


    @Test
    public void Three_Lines_RRR_R() throws Exception {
        assertEquals('R',  Kata.triangle("RRR"));
    }




    @Test
    public void examples() {
        assertEquals('B',  Kata.triangle("RGBG"));
        assertEquals('G',  Kata.triangle("RBRGBRB"));
        assertEquals('G', Kata.triangle("RBRGBRBGGRRRBGBBBGG"));

    }
}