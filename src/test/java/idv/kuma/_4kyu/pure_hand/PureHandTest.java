package idv.kuma._4kyu.pure_hand;

import org.junit.Test;

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
}
