package idv.kuma._4kyu.strings_mix;


import idv.kuma._4kyu.strings_mix.Mixing.CharStat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;
import java.util.stream.Collectors;

import static idv.kuma._4kyu.strings_mix.Mixing.FrequencyMaker;
import static idv.kuma._4kyu.strings_mix.Mixing.mix;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Mixing.class})
public class MixingTestMocking {


    @Mock
    private FrequencyMaker mockedFrequencyMaker;


    @Test
    public void MockedTest_When_ccccddddd_aabbb_Then_1ddddd_1cccc_2bbb_2aa() throws Exception {

        replaceFrequencyMakerWithMock();

        String s1 = "ccccddddd";
        String s2 = "aabbb";

        prepareMockedFrequencyMaker(s1, "1",
                new CharStat('d', 5, "1"),
                new CharStat('c', 4, "1"));

        prepareMockedFrequencyMaker(s2, "2",
                new CharStat('b', 3, "2"),
                new CharStat('a', 2, "2"));


        runAndCheck("1:ddddd/1:cccc/2:bbb/2:aa", s1, s2);

    }


    @Test
    public void MockedTest_When_ccccaa_bbbddddd_Then_2ddddd_1cccc_2bbb_1aa() throws Exception {

        replaceFrequencyMakerWithMock();

        String s1 = "ccccaa";
        String s2 = "dddddbbb";

        prepareMockedFrequencyMaker(s1, "1",
                new CharStat('c', 4, "1"),
                new CharStat('a', 2, "1"));

        prepareMockedFrequencyMaker(s2, "2",
                new CharStat('d', 5, "2"),
                new CharStat('b', 3, "2"));


        runAndCheck("2:ddddd/1:cccc/2:bbb/1:aa", s1, s2);

    }


    @Test
    public void MockedTest_When_cccczz_aabbbddddd_Then_2ddddd_1cccc_2bbb_1zz_2aa() throws Exception {

        replaceFrequencyMakerWithMock();

        String s1 = "cccczz";
        String s2 = "aadddddbbb";

        prepareMockedFrequencyMaker(s1, "1",
                new CharStat('c', 4, "1"),
                new CharStat('z', 2, "1"));

        prepareMockedFrequencyMaker(s2, "2",
                new CharStat('d', 5, "2"),
                new CharStat('b', 3, "2"),
                new CharStat('a', 2, "2"));


        runAndCheck("2:ddddd/1:cccc/2:bbb/1:zz/2:aa", s1, s2);

    }

    @Test
    public void MockedTest_When_ccccaa_aabbbddddd_Then_2ddddd_1cccc_2bbb_Eaa() throws Exception {

        replaceFrequencyMakerWithMock();

        String s1 = "ccccaa";
        String s2 = "aadddddbbb";

        prepareMockedFrequencyMaker(s1, "1",
                new CharStat('c', 4, "1"),
                new CharStat('a', 2, "1"));

        prepareMockedFrequencyMaker(s2, "2",
                new CharStat('d', 5, "2"),
                new CharStat('b', 3, "2"),
                new CharStat('a', 2, "2"));

        runAndCheck("2:ddddd/1:cccc/2:bbb/=:aa", s1, s2);

    }


    @Test
    public void MockedTest_When_ccccaa_aaccbbbddddd_Then_2ddddd_1cccc_2bbb_Eaa() throws Exception {

        replaceFrequencyMakerWithMock();

        String s1 = "ccccaa";
        String s2 = "aaccdddddbbb";

        prepareMockedFrequencyMaker(s1, "1",
                new CharStat('c', 4, "1"),
                new CharStat('a', 2, "1"));

        prepareMockedFrequencyMaker(s2, "2",
                new CharStat('d', 5, "2"),
                new CharStat('c', 2, "2"),
                new CharStat('b', 3, "2"),
                new CharStat('a', 2, "2"));

        runAndCheck("2:ddddd/1:cccc/2:bbb/=:aa", s1, s2);

    }


    void runAndCheck(String expected, String s1, String s2) {
        Assert.assertEquals(expected, mix(s1, s2));
    }

    void replaceFrequencyMakerWithMock() throws Exception {
        Whitebox.setInternalState(Mixing.class, "frequencyMaker", mockedFrequencyMaker);
    }

    void prepareMockedFrequencyMaker(String str, String strName, CharStat... charStats) {

        when(mockedFrequencyMaker.makeStatics(str, strName)).thenReturn(
                Arrays.stream(charStats).collect(Collectors.toList())
        );

    }


}