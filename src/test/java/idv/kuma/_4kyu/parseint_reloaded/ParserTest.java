package idv.kuma._4kyu.parseint_reloaded;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ParserTest {

    @Test
    public void fixedTests() {
        runAndCheck("one", 1);
    }

    void runAndCheck(String input, int expectedOutput) {
        assertEquals(expectedOutput, Parser.parseInt(input));
    }

    @Test
    public void twenty() {
        runAndCheck("twenty", 20);


    }

    @Test
    public void two_hundered_forty_six() {
        runAndCheck("two hundred forty-six", 246);

    }
}