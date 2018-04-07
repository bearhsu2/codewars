package idv.kuma._4kyu.longest_common_subsequence;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class SolutionTest {

    @Test
    public void longExample() throws Exception {
        assertEquals("MJAU", Solution.lcs("XMJYAUZ","MZJAWXU"));
    }

    @Test
    public void zero_inputs() throws Exception {
        assertEquals("", Solution.lcs("", "aabbcc"));
        assertEquals("", Solution.lcs("aabbcc", ""));
    }

    @Test
    public void exampleTests() {
        assertEquals("", Solution.lcs("a", "b"));
        assertEquals("abc", Solution.lcs("abcdef", "abc"));
    }
}