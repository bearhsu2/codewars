package idv.kuma._6kyu.your_order_please;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bearhsu2 on 3/25/2018.
 */
public class OrderTest {

    @Test
    public void order_simple() throws Exception {
        assertEquals("1ff 2ss ff3 ff4", Order.order("1ff 2ss ff4 ff3"));
    }

    @Test
    public void test1() {
        assertEquals("Thi1s is2 3a T4est", Order.order("is2 Thi1s T4est 3a"));
    }

    @Test
    public void test2() {
        assertEquals("Fo1r the2 g3ood 4of th5e pe6ople", Order.order("4of Fo1r pe6ople g3ood th5e the2"));
    }


    @Test
    public void test_easy() throws Exception {
        assertEquals("ok1", Order.order("ok1"));
    }

    @Test
    public void test3() {
        assertEquals("Empty input should return empty string", "", Order.order(""));
    }
}