package idv.kuma._4kyu.strings_mix;

import org.junit.Test;

import static idv.kuma._4kyu.strings_mix.Mixing.mix;
import static org.junit.Assert.assertEquals;

public class MixingTestNonMocking {

    @Test
    public void When_bb_aaa_Then_2_aaa_1_bb() throws Exception {
        assertEquals("2:aaa/1:bb", mix("bb","aaa"));
    }

    @Test
    public void When_aaa_bb_Then_1_aaa_2_bb() throws Exception {
        assertEquals("1:aaa/2:bb", mix("aaa", "bb"));
    }

    @Test
    public void When_bb_aa_Then_1_aa_2_bb() throws Exception {
        assertEquals("1:bb/2:aa", mix("bb", "aa"));
    }


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
