package idv.kuma._6kyu.decode_thie_morse_code;

import org.junit.Assert;
import org.junit.Test;


public class MorseCodeDecoderTest {
    @Test
    public void testExampleFromDescription() {
        Assert.assertEquals("HEY JUDE",
                MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."));
    }
}