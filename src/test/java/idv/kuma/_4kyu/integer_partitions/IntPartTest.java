package idv.kuma._4kyu.integer_partitions;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IntPartTest {

    @Ignore
    @Test
    public void Numbers_Small() {
        assertEquals("Range: 1 Average: 1.50 Median: 1.50", IntPart.part(2));
//        assertEquals("Range: 2 Average: 2.00 Median: 2.00", IntPart.part(3));
//        assertEquals("Range: 3 Average: 2.50 Median: 2.50", IntPart.part(4));
//        assertEquals("Range: 5 Average: 3.50 Median: 3.50", IntPart.part(5));
    }



    @Test
    public void partition_1() {
        List<List<Long>> p1 = Arrays.asList(Arrays.asList(1L));
        assertEquals(p1,IntPart.findPartitions(1) );
    }


    @Ignore
    @Test
    public void partition_2() {
        List<List<Long>> p1 = Arrays.asList(Arrays.asList(2L), Arrays.asList(1L, 1L));
        assertEquals(p1,IntPart.findPartitions(2) );
    }
}
