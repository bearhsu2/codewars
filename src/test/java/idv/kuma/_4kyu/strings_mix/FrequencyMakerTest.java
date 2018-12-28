package idv.kuma._4kyu.strings_mix;

import idv.kuma._4kyu.strings_mix.Mixing.CharStat;
import idv.kuma._4kyu.strings_mix.Mixing.FrequencyMaker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FrequencyMakerTest {

    @Test
    public void makeFrequencyMap() throws Exception {

        String string = "AAbbbbcccaaDDe";

        FrequencyMaker frequencyMaker = new FrequencyMaker();

        List<CharStat> charStats = frequencyMaker.makeStatics(string, "1");

        Assert.assertEquals(
                Arrays.asList(
                        new CharStat('a', 2, "1"),
                        new CharStat('b', 4, "1"),
                        new CharStat('c', 3, "1")),
                charStats
        );
    }
}