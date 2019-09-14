package idv.kuma._2kyu.integer_square_root;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class KataTest {


    @Test
    public void _0_0() throws Exception {
        runAndCheck("0", "0");
    }

    @Test
    public void _1_1() throws Exception {
        runAndCheck("1", "1");
    }

    @Test
    public void _4_2() throws Exception {
        runAndCheck("4", "2");
    }

    @Test
    public void _3_1() throws Exception {
        runAndCheck("3", "1");
    }

    @Test
    public void _101_10() throws Exception {
        runAndCheck("101", "10");
    }


    @Test
    public void basicExampleTests() {

        runAndCheck("1", "1");
        runAndCheck("5", "2");
        runAndCheck("17", "4");
        runAndCheck("100", "10");
        runAndCheck("1000", "31");

    }

    @Test
    public void _1_222444666887_findMiddle_Is_aaa() {
        List<Long> middle = Kata.Operator.findMiddle(Collections.singletonList(1L), Arrays.asList(444666887L, 222L));
        Assert.assertEquals("111222333444", Kata.Operator.LongsToString(middle));
    }

    @Test
    public void bigNums() throws Exception {
        runAndCheck("23232328323215435345345345343458098856756556809400840980980980980809092343243243243243098799634", "152421548093487868711992623730429930751178496967");
        runAndCheck("12323309809809534545458098709854808654685688665486860956865654654654324238000980980980", "3510457208086937291253621317073222057793129");

    }
    @Test
    public void realCase() throws Exception {
        runAndCheck("346397429185729221486777470231396322166462901", "18611755134476952963402");

    }

    void runAndCheck(String number, String root) {
        assertEquals(root, Kata.integerSquareRoot(number));
    }
}
