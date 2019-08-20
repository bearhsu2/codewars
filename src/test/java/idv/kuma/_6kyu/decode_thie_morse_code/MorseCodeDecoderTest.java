package idv.kuma._6kyu.decode_thie_morse_code;

import org.junit.Assert;
import org.junit.Test;


public class MorseCodeDecoderTest {
    @Test
    public void testExampleFromDescription() {
        runAndCheck("HEY JUDE", ".... . -.--   .--- ..- -.. .");
    }

    void runAndCheck(String expected, String encoded) {
        Assert.assertEquals(expected,
                MorseCodeDecoder.decode(encoded));
    }
}