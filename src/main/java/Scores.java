public class Scores {

    public Scores() {
    }

    public static int chances(ThrowDices throwDice){
        return throwDice.sumDices();
    }

    public static int yatzy(ThrowDices throwDice){
        return throwDice.isYatzy()? 50 : 0;
    }

    public static int ones(ThrowDices throwDices){
        return throwDices.findSingleNumberChoice(1);
    }

    public static int two(ThrowDices throwDices){
        return throwDices.findSingleNumberChoice(2);
    }

    public static int three(ThrowDices throwDices){
        return throwDices.findSingleNumberChoice(3);
    }

    public static int four(ThrowDices throwDices){
        return throwDices.findSingleNumberChoice(4);
    }

    public static int five(ThrowDices throwDices){
        return throwDices.findSingleNumberChoice(5);
    }

    public static int six(ThrowDices throwDices){
        return throwDices.findSingleNumberChoice(6);
    }

    public static int pair(ThrowDices throwDice){
        return throwDice.findDicePairs().isEmpty()? 0 : throwDice.findDicePairs().get(0) * 2;
    }

    public static int twoPair(ThrowDices throwDice){
        return throwDice.findDicePairs().isEmpty() || throwDice.findDicePairs().size() < 2
                ? 0 : throwDice.findDicePairs().get(0) * 2 + throwDice.findDicePairs().get(1) * 2;
    }

    public static int threeOfKind(ThrowDices throwDice){
        return throwDice.findDiceThreeofKind(2).isEmpty() ? 0: throwDice.findDiceThreeofKind(2).get(0) * 3;
    }

    public static int fullHouse(){
        return 0;
    }

    public static int smallStraight(){
        return 0;
    }

    public static int largeStraight(){
        return 0;
    }


}
