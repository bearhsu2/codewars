package idv.kuma._4kyu.strings_mix;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Mixing.class})
public class MixingTest {

    @Test
    public void MockedTest_When_ccccddddd_aabbb_2ddddd_2cccc_1bbb_1aa() throws Exception {

        Mixing.FrequencyMaker mockedFrequencyMaker = mock(Mixing.FrequencyMaker.class);
        when(mockedFrequencyMaker.makeStatics("ccccddddd", "1")).thenReturn(
                new ArrayList<>(
                        Arrays.asList(
                                new Mixing.CharStat('d', 5, "1"),
                                new Mixing.CharStat('c', 4, "2")
                        )));
        when(mockedFrequencyMaker.makeStatics("aabbb", "2")).thenReturn(
                new ArrayList<>(
                        Arrays.asList(
                                new Mixing.CharStat('b', 3, "2"),
                                new Mixing.CharStat('a', 2, "2")

                        )));

        PowerMockito.whenNew(Mixing.FrequencyMaker.class).withNoArguments().thenReturn(mockedFrequencyMaker);


        Assert.assertEquals("2:ddddd/2:cccc/1:bbb/1:aa", Mixing.mix("ccccddddd", "aabbb"));

    }

    @Test
    public void When_aaa_bb_Then_1_aaa_2_bb() throws Exception {
        assertEquals("1:aaa/2:bb", Mixing.mix("aaa", "bb"));
    }

    @Ignore
    @Test
    public void When_bb_aa_Then_1_aa_2_bb() throws Exception {
        assertEquals("1:aa/2:bb", Mixing.mix("bb", "aa"));
    }

    @Ignore
    @Test
    public void test() {
        System.out.println("Mix Fixed Tests");
        assertEquals("2:eeeee/2:yy/=:hh/=:rr", Mixing.mix("Are they here", "yes, they are here"));
        assertEquals("1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg",
                Mixing.mix("looping is fun but dangerous", "less dangerous than coding"));
        assertEquals("1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt",
                Mixing.mix(" In many languages", " there's a pair of functions"));
        assertEquals("1:ee/1:ll/1:oo", Mixing.mix("Lords of the Fallen", "gamekult"));
        assertEquals("", Mixing.mix("codewars", "codewars"));
        assertEquals("1:nnnnn/1:ooooo/1:tttt/1:eee/1:gg/1:ii/1:mm/=:rr",
                Mixing.mix("A generation must confront the looming ", "codewarrs"));
    }

}