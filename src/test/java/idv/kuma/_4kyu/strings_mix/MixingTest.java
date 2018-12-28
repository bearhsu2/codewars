package idv.kuma._4kyu.strings_mix;


import idv.kuma._4kyu.strings_mix.Mixing.CharStat;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.stream.Collectors;

import static idv.kuma._4kyu.strings_mix.Mixing.FrequencyMaker;
import static idv.kuma._4kyu.strings_mix.Mixing.mix;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Mixing.class})
public class MixingTest {


    private FrequencyMaker mockedFrequencyMaker = mock(FrequencyMaker.class);


    @Test
    public void MockedTest_When_ccccddddd_aabbb_2ddddd_2cccc_1bbb_1aa() throws Exception {

        replaceFrequencyMakerWithMock();

        prepareMockedFrequencyMaker("ccccddddd", "1",
                new CharStat('d', 5, "1"),
                new CharStat('c', 4, "1"));

        prepareMockedFrequencyMaker("aabbb", "2",
                new CharStat('b', 3, "2"),
                new CharStat('a', 2, "2"));


        runAndCheck("1:ddddd/1:cccc/2:bbb/2:aa", "ccccddddd", "aabbb");

    }

    void runAndCheck(String expected, String s1, String s2) {
        Assert.assertEquals(expected, mix(s1, s2));
    }

    void replaceFrequencyMakerWithMock() throws Exception {
        PowerMockito.whenNew(FrequencyMaker.class).withNoArguments().thenReturn(mockedFrequencyMaker);
    }

    void prepareMockedFrequencyMaker(String str, String strName, CharStat... charStats) {

        when(mockedFrequencyMaker.makeStatics(str, strName)).thenReturn(
                Arrays.stream(charStats).collect(Collectors.toList())
        );
//        when(mockedFrequencyMaker.makeStatics(str, strName)).thenReturn(
//                new ArrayList<>(
//                        Arrays.asList(
//                                new CharStat('d', 5, "1"),
//                                new CharStat('c', 4, "1")
//                        )));
    }

    @Test
    public void When_aaa_bb_Then_1_aaa_2_bb() throws Exception {
        assertEquals("1:aaa/2:bb", mix("aaa", "bb"));
    }

    @Ignore
    @Test
    public void When_bb_aa_Then_1_aa_2_bb() throws Exception {
        assertEquals("1:aa/2:bb", mix("bb", "aa"));
    }

    @Ignore
    @Test
    public void test() {
        System.out.println("Mix Fixed Tests");
        assertEquals("2:eeeee/2:yy/=:hh/=:rr", mix("Are they here", "yes, they are here"));
        assertEquals("1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg",
                mix("looping is fun but dangerous", "less dangerous than coding"));
        assertEquals("1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt",
                mix(" In many languages", " there's a pair of functions"));
        assertEquals("1:ee/1:ll/1:oo", mix("Lords of the Fallen", "gamekult"));
        assertEquals("", mix("codewars", "codewars"));
        assertEquals("1:nnnnn/1:ooooo/1:tttt/1:eee/1:gg/1:ii/1:mm/=:rr",
                mix("A generation must confront the looming ", "codewarrs"));
    }

}