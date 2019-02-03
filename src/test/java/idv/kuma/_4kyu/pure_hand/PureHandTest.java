package idv.kuma._4kyu.pure_hand;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class PureHandTest {
    @Test
    public void sampleTest1() {
        assertEquals("89", PureHand.solution("1113335557779"));
    }

    @Test
    public void sampleTest2() {
        assertEquals("258", PureHand.solution("1223334455678"));
    }


    @Test
    public void ToIntegerList() throws Exception {

        List<Integer> expected = new ArrayList<>(
                Arrays.asList(1,2,2,3,3,3,4,4,5,5,6,7,8));

        List<Integer> integers = PureHand.toIntegerList("1223334455678");


        Assert.assertEquals(expected, integers);

    }
}
