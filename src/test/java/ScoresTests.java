import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class ScoresTests {

    @Test
    public void chanceTest(){
        ThrowDices throwDices1 = new ThrowDices(1,2,3,4,5);
        assertEquals(15, Scores.chances(throwDices1));
    }

    @Test
    public void yatzyTest_valid(){
        ThrowDices throwDices1 = new ThrowDices(2,2,2,2,2);
        assertTrue(throwDices1.isYatzy());
        assertEquals(50, Scores.yatzy(throwDices1));
    }

    @Test
    public void yatzyTest_not_valid(){
        ThrowDices throwDices1 = new ThrowDices(2,2,3,2,2);
        assertFalse(throwDices1.isYatzy());
        assertEquals(0, Scores.yatzy(throwDices1));
    }

    @Test
    public void pairTest(){
        ThrowDices throwDices1 = new ThrowDices(1,2,3,4,5);
        ThrowDices throwDices2 = new ThrowDices(2,4,3,1,3);
        ThrowDices throwDices3 = new ThrowDices(2,5,3,5,3);

        assertEquals(0, Scores.pair(throwDices1));
        assertEquals(6, Scores.pair(throwDices2));
        assertEquals(10, Scores.pair(throwDices3));

    }

    @Test
    public void twoPairTest(){
        ThrowDices throwDices1 = new ThrowDices(1,1,3,4,5);
        ThrowDices throwDices2 = new ThrowDices(1,2,3,4,5);
        ThrowDices throwDices3 = new ThrowDices(2,4,3,2,3);
        ThrowDices throwDices4 = new ThrowDices(2,5,3,5,3);

        assertEquals(0, Scores.twoPairs(throwDices1));
        assertEquals(0, Scores.twoPairs(throwDices2));
        assertEquals(10, Scores.twoPairs(throwDices3));
        assertEquals(16, Scores.twoPairs(throwDices4));
    }

    @Test
    public void threeOfKindTest() {
        ThrowDices throwDices1 = new ThrowDices(2,5,5,5,3);
        ThrowDices throwDices2 = new ThrowDices(3,2,3,2,3);
        ThrowDices throwDices3 = new ThrowDices(2,4,3,2,3);

        assertEquals(15, Scores.threeOfKind(throwDices1));
        assertEquals(9, Scores.threeOfKind(throwDices2));
        assertEquals(0, Scores.threeOfKind(throwDices3));
    }

    @Test
    public void onesTest(){
        ThrowDices throwDices1 = new ThrowDices(1,1,3,4,5);
        ThrowDices throwDices2 = new ThrowDices(1,1,3,1,5);
        ThrowDices throwDices3 = new ThrowDices(2,2,3,4,5);

        assertEquals(2, Scores.ones(throwDices1));
        assertEquals(3, Scores.ones(throwDices2));
        assertEquals(0, Scores.ones(throwDices3));
    }

    @Test
    public void twosTest(){
        ThrowDices throwDices1 = new ThrowDices(1,1,2,2,5);
        ThrowDices throwDices2 = new ThrowDices(1,1,2,1,5);
        ThrowDices throwDices3 = new ThrowDices(6,6,3,4,5);

        assertEquals(4, Scores.twos(throwDices1));
        assertEquals(2, Scores.twos(throwDices2));
        assertEquals(0, Scores.twos(throwDices3));
    }

    @Test
    public void threesTest(){
        ThrowDices throwDices1 = new ThrowDices(1,1,3,4,5);
        ThrowDices throwDices2 = new ThrowDices(1,3,3,1,3);
        ThrowDices throwDices3 = new ThrowDices(2,2,1,4,5);

        assertEquals(3, Scores.threes(throwDices1));
        assertEquals(9, Scores.threes(throwDices2));
        assertEquals(0, Scores.threes(throwDices3));
    }

    @Test
    public void foursTest(){
        ThrowDices throwDices1 = new ThrowDices(1,1,3,4,5);
        ThrowDices throwDices2 = new ThrowDices(1,4,3,4,5);
        ThrowDices throwDices3 = new ThrowDices(2,2,3,1,5);

        assertEquals(4, Scores.fours(throwDices1));
        assertEquals(8, Scores.fours(throwDices2));
        assertEquals(0, Scores.fours(throwDices3));
    }

    @Test
    public void fivesTest(){
        ThrowDices throwDices1 = new ThrowDices(1,1,3,4,5);
        ThrowDices throwDices2 = new ThrowDices(1,5,3,1,5);
        ThrowDices throwDices3 = new ThrowDices(2,2,3,4,6);

        assertEquals(5, Scores.fives(throwDices1));
        assertEquals(10, Scores.fives(throwDices2));
        assertEquals(0, Scores.fives(throwDices3));
    }

    @Test
    public void sixsTest(){
        ThrowDices throwDices1 = new ThrowDices(6,1,3,6,6);
        ThrowDices throwDices2 = new ThrowDices(1,1,3,6,5);
        ThrowDices throwDices3 = new ThrowDices(2,2,3,4,5);

        assertEquals(18, Scores.sixs(throwDices1));
        assertEquals(6, Scores.sixs(throwDices2));
        assertEquals(0, Scores.sixs(throwDices3));
    }

    @Test
    public void fullHouseTest(){
        ThrowDices throwDices1 = new ThrowDices(6,3,3,6,6);
        ThrowDices throwDices2 = new ThrowDices(1,1,3,6,5);
        ThrowDices throwDices3 = new ThrowDices(5,5,5,5,5);

        assertEquals(24, Scores.fullHouse(throwDices1));
        assertEquals(0, Scores.fullHouse(throwDices2));
        assertEquals(0, Scores.fullHouse(throwDices3));
    }

    @Test
    public void smallStraightTest(){
        ThrowDices throwDices1 = new ThrowDices(1,2,3,4,5);
        ThrowDices throwDices2 = new ThrowDices(1,1,3,6,5);

        assertEquals(15, Scores.smallStraight(throwDices1));
        assertEquals(0, Scores.smallStraight(throwDices2));
    }

    @Test
    public void largeStraightTest(){
        ThrowDices throwDices1 = new ThrowDices(2,3,4,5,6);
        ThrowDices throwDices2 = new ThrowDices(1,1,3,6,5);

        assertEquals(20, Scores.largeStraight(throwDices1));
        assertEquals(0, Scores.largeStraight(throwDices2));
    }

}
