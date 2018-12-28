package idv.kuma._2kyu.integer_square_root;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class OperatorTest {

    @Test
    public void name() throws Exception {
        List<Long> actual = Kata.Operator.multiply(Kata.Separator.separate("11"), Kata.Separator.separate("12"));
        Assert.assertEquals(Collections.singletonList(132L), actual);
    }
}