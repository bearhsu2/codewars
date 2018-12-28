package idv.kuma._2kyu.integer_square_root;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class OperatorTest {

    @Test
    public void _11_Multiply_By_12_Is_132() throws Exception {
        runAndCheck("11", "12", 132L);
    }

    void runAndCheck(String str1, String str2, long expect) {
        List<Long> actual = Kata.Operator.multiply(Kata.Separator.separate(str1), Kata.Separator.separate(str2));
        Assert.assertEquals(Collections.singletonList(expect), actual);
    }


}