package idv.kuma._6kyu.numericals_of_a_string;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.runners.JUnit4;

public class SolutionTest {


    @Test
    public void abc_111() throws Exception {
        assertEquals("111", JomoPipi.numericals("abc"));
    }

    @Test
    public void abcc_1112() throws Exception {
        assertEquals("1112", JomoPipi.numericals("abcc"));
    }


    @Ignore
    @Test
    public void basicTest1() {
        assertEquals("1112111121311", JomoPipi.numericals("Hello, World!"));
    }


    @Ignore
    @Test
    public void basicTest2() {
        assertEquals("11121111213112111131224132411122", JomoPipi.numericals("Hello, World! It's me, JomoPipi!"));
    }

    @Ignore
    @Test
    public void basicTest3() {
        assertEquals("11121122342", JomoPipi.numericals("hello hello"));
    }

}