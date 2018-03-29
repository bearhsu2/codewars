package idv.kuma._4kyu.next_smaller_number_with_the_same_digits;

/**
 * Created by bearhsu2 on 3/29/2018.
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void basicTests() {
        assertEquals(45321, Kata.nextSmaller(54321));
        assertEquals(790, Kata.nextSmaller(907));
        assertEquals(513, Kata.nextSmaller(531));
        assertEquals(-1, Kata.nextSmaller(1027));
        assertEquals(414, Kata.nextSmaller(441));
        assertEquals(123456789, Kata.nextSmaller(123456798));
    }
}