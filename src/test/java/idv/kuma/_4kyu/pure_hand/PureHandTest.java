package idv.kuma._4kyu.pure_hand;

import org.junit.Assert;
import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class PureHandTest {
    @Test
    public void sampleTest1() {
        assertEquals("89", PureHand.solution("1113335557779"));
    }

    @Test
    public void sampleTest2() {
        assertEquals("258", PureHand.solution("1223334455678"));
    }




    @Test
    public void ToIntegerList() throws Exception {

        List<Integer> expected = new ArrayList<>(
                Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 8));

        List<Integer> integers = PureHand.toIntegerList("1223334455678");


        Assert.assertEquals(expected, integers);

    }

    @Test
    public void When_Find_Eyes_For_12233344556788_Then_22_33_44_55_88() throws Exception {

        List<Integer> tiles = new ArrayList<>(
                Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 8, 8));

        List<PureHand.Hand> hands = PureHand.findCandidateHands(tiles);

        Assert.assertNotNull(hands);
        Assert.assertEquals(5, hands.size());
        checkHand(hands.get(0), 2, Arrays.asList(1, 3, 3, 3, 4, 4, 5, 5, 6, 7, 8, 8));
        checkHand(hands.get(1), 3, Arrays.asList(1, 2, 2, 3, 4, 4, 5, 5, 6, 7, 8, 8));
        checkHand(hands.get(2), 4, Arrays.asList(1, 2, 2, 3, 3, 3, 5, 5, 6, 7, 8, 8));
        checkHand(hands.get(3), 5, Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 6, 7, 8, 8));
        checkHand(hands.get(4), 8, Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7));
    }

    @Test
    public void When_Find_Eyes_For_12233344556782_Then_22_33_44_55() throws Exception {

        List<Integer> tiles = new ArrayList<>(
                Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 8, 2));

        List<PureHand.Hand> hands = PureHand.findCandidateHands(tiles);

        Assert.assertNotNull(hands);
        Assert.assertEquals(4, hands.size());
        checkHand(hands.get(0), 2, Arrays.asList(1, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 8));
        checkHand(hands.get(1), 3, Arrays.asList(1, 2, 2, 2, 3, 4, 4, 5, 5, 6, 7, 8));
        checkHand(hands.get(2), 4, Arrays.asList(1, 2, 2, 2, 3, 3, 3, 5, 5, 6, 7, 8));
        checkHand(hands.get(3), 5, Arrays.asList(1, 2, 2, 2, 3, 3, 3, 4, 4, 6, 7, 8));
    }

    private void checkHand(PureHand.Hand hand, int eye, List<Integer> remains) {

        Assert.assertEquals(eye, hand.getEye().intValue());
        Assert.assertEquals(remains, hand.getRemains());
    }

    @Test
    public void When_99_123_Then_IsRemainingsAllMelds_True() throws Exception {

        PureHand.Hand hand = new PureHand.Hand(Integer.valueOf(9), new ArrayList<>(Arrays.asList(9, 9, 1, 2, 3)));

        Assert.assertTrue(PureHand.isRemainingsAllMelds(hand));
    }

    @Test
    public void When_99_112233_Then_IsRemainingsAllMelds_True() throws Exception {

        PureHand.Hand hand = new PureHand.Hand(Integer.valueOf(9), new ArrayList<>(Arrays.asList(9, 9, 1, 1, 2, 2, 3, 3)));

        Assert.assertTrue(PureHand.isRemainingsAllMelds(hand));
    }
}
