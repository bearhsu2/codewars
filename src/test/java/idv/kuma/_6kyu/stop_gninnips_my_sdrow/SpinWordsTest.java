package idv.kuma._6kyu.stop_gninnips_my_sdrow;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SpinWordsTest {
    @Test
    public void test() {
        assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
    }

}