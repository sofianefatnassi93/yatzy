import org.junit.Test;

import static org.junit.Assert.*;

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

        assertEquals(0, Scores.twoPair(throwDices1));
        assertEquals(0, Scores.twoPair(throwDices2));
        assertEquals(10, Scores.twoPair(throwDices3));
        assertEquals(16, Scores.twoPair(throwDices4));
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

        assertEquals(4, Scores.two(throwDices1));
        assertEquals(2, Scores.two(throwDices2));
        assertEquals(0, Scores.two(throwDices3));
    }

    @Test
    public void threesTest(){
        ThrowDices throwDices1 = new ThrowDices(1,1,3,4,5);
        ThrowDices throwDices2 = new ThrowDices(1,3,3,1,3);
        ThrowDices throwDices3 = new ThrowDices(2,2,1,4,5);

        assertEquals(3, Scores.three(throwDices1));
        assertEquals(9, Scores.three(throwDices2));
        assertEquals(0, Scores.three(throwDices3));
    }

    @Test
    public void foursTest(){
        ThrowDices throwDices1 = new ThrowDices(1,1,3,4,5);
        ThrowDices throwDices2 = new ThrowDices(1,4,3,4,5);
        ThrowDices throwDices3 = new ThrowDices(2,2,3,1,5);

        assertEquals(4, Scores.four(throwDices1));
        assertEquals(8, Scores.four(throwDices2));
        assertEquals(0, Scores.four(throwDices3));
    }

    @Test
    public void fivesTest(){
        ThrowDices throwDices1 = new ThrowDices(1,1,3,4,5);
        ThrowDices throwDices2 = new ThrowDices(1,5,3,1,5);
        ThrowDices throwDices3 = new ThrowDices(2,2,3,4,6);

        assertEquals(5, Scores.five(throwDices1));
        assertEquals(10, Scores.five(throwDices2));
        assertEquals(0, Scores.five(throwDices3));
    }

    @Test
    public void sixsTest(){
        ThrowDices throwDices1 = new ThrowDices(6,1,3,6,6);
        ThrowDices throwDices2 = new ThrowDices(1,1,3,6,5);
        ThrowDices throwDices3 = new ThrowDices(2,2,3,4,5);

        assertEquals(18, Scores.six(throwDices1));
        assertEquals(6, Scores.six(throwDices2));
        assertEquals(0, Scores.six(throwDices3));
    }


}
