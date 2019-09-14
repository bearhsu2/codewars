package idv.kuma._7kyu.triangle;

import static org.junit.Assert.*;

import static org.junit.Assert.*;
import org.junit.Test;


public class TriangleTesterTest {
    @Test
    public void publicTests() {
        assertEquals(TriangleTester.isTriangle(1,2,2), true);
        assertEquals(TriangleTester.isTriangle(7,2,2), false);
    }
}