package idv.kuma._2kyu.integer_square_root;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;


public class KataTest {

    @Test
    public void one_one() throws Exception {
        assertEquals("1", Kata.integerSquareRoot("1"));


    }

    @Ignore
    @Test
    public void basicTests() {

        assertEquals("1", Kata.integerSquareRoot("1"));
        assertEquals("2", Kata.integerSquareRoot("5"));
        assertEquals("4", Kata.integerSquareRoot("17"));
        assertEquals("10", Kata.integerSquareRoot("100"));
        assertEquals("31", Kata.integerSquareRoot("1000"));
        assertEquals("152421548093487868711992623730429930751178496967",
                Kata.integerSquareRoot("23232328323215435345345345343458098856756556809400840980980980980809092343243243243243098799634"));
        assertEquals("3510457208086937291253621317073222057793129",
                Kata.integerSquareRoot("12323309809809534545458098709854808654685688665486860956865654654654324238000980980980"));

    }
}