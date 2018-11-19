package idv.kuma._2kyu.integer_square_root;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class KataTest {

    @Test
    public void _1_1() throws Exception {
        runAndCheck("1", "1");
    }

    @Test
    public void _4_2() throws Exception {
        runAndCheck("4", "2");
    }


    @Ignore
    @Test
    public void basicTests() {

        runAndCheck("1", "1");
        runAndCheck("5", "2");
        runAndCheck("17", "4");
        runAndCheck("100", "10");
        runAndCheck("1000", "31");
        runAndCheck("23232328323215435345345345343458098856756556809400840980980980980809092343243243243243098799634", "152421548093487868711992623730429930751178496967");
        runAndCheck("12323309809809534545458098709854808654685688665486860956865654654654324238000980980980", "3510457208086937291253621317073222057793129");

    }

    void runAndCheck(String number, String root) {
        assertEquals(root, Kata.integerSquareRoot(number));
    }
}
