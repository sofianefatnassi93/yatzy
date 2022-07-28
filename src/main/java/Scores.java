public class Scores {

    /**
     * @param throwDice
     * @return the score of chances
     */
    public static int chances(ThrowDices throwDice) {
        return throwDice.sumDices();
    }

    /**
     * @param throwDice
     * @return the score of yatzy
     */
    public static int yatzy(ThrowDices throwDice) {
        return throwDice.isYatzy() ? 50 : 0;
    }

    /**
     * @param throwDices
     * @return the score of ones category
     */
    public static int ones(ThrowDices throwDices) {
        return throwDices.findSingleNumberChoice(1);
    }

    /**
     * @param throwDices
     * @return the score of twos category
     */
    public static int twos(ThrowDices throwDices) {
        return throwDices.findSingleNumberChoice(2);
    }

    /**
     * @param throwDices
     * @return the score of threes category
     */
    public static int threes(ThrowDices throwDices) {
        return throwDices.findSingleNumberChoice(3);
    }

    /**
     * @param throwDices
     * @return the score of fours category
     */
    public static int fours(ThrowDices throwDices) {
        return throwDices.findSingleNumberChoice(4);
    }

    /**
     * @param throwDices
     * @return the score of fives category
     */
    public static int fives(ThrowDices throwDices) {
        return throwDices.findSingleNumberChoice(5);
    }

    /**
     * @param throwDices
     * @return the score of sixs category
     */
    public static int sixs(ThrowDices throwDices) {
        return throwDices.findSingleNumberChoice(6);
    }

    /**
     * @param throwDice
     * @return the score of pair
     */
    public static int pair(ThrowDices throwDice) {
        return throwDice.findPairsDices().isEmpty() ? 0 : throwDice.findPairsDices().get(0) * 2;
    }

    /**
     * @param throwDice
     * @return the score of two pairs
     */
    public static int twoPairs(ThrowDices throwDice) {
        return throwDice.findPairsDices().isEmpty() || throwDice.findPairsDices().size() < 2
                ? 0 : throwDice.findPairsDices().get(0) * 2 + throwDice.findPairsDices().get(1) * 2;
    }

    /**
     * @param throwDice
     * @return the score of threeOfKind
     */
    public static int threeOfKind(ThrowDices throwDice) {
        return throwDice.findThreeofKindDices(2).isEmpty() ? 0 : throwDice.findThreeofKindDices(2).get(0) * 3;
    }

    /**
     * @param throwDice
     * @return the score of fullHouse
     */
    public static int fullHouse(ThrowDices throwDice) {
        return throwDice.findFullHouseDices();
    }

    /**
     * @param throwDice
     * @return the score of smallStraight
     */
    public static int smallStraight(ThrowDices throwDice) {
        return throwDice.isSmallStraight() ? 15 : 0;
    }

    /**
     * @param throwDice
     * @return the score of largeStraight
     */
    public static int largeStraight(ThrowDices throwDice) {
        return throwDice.isLargeStraight() ? 20 : 0;
    }


}
