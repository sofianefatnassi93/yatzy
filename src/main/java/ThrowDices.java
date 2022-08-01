import java.util.*;
import java.util.stream.Collectors;

public class ThrowDices {

    private final List<Integer> throwResult;
    public static final List<Integer> SMALL_STRAIGHT = Arrays.asList(1,2,3,4,5);
    public static final List<Integer> LARGE_STRAIGHT = Arrays.asList(2,3,4,5,6);

    /**
     * @param dice1
     * @param dice2
     * @param dice3
     * @param dice4
     * @param dice5
     */
    public ThrowDices(int dice1, int dice2, int dice3, int dice4, int dice5) {
        throwResult = Arrays.asList(dice1, dice2, dice3, dice4, dice5);
    }

    /**
     * @return the sum of dices
     */
    public int sumDices() {
        return throwResult.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * @return true if the throwDice is Yatzy, false if not
     */
    public boolean isYatzy() {
      return throwResult.stream().allMatch(s-> s.equals(throwResult.get(0)));
    }

    /**
     * @param categoryNumber : the category number can be (1, 2, 3, 4, 5 or 6)
     * @return the sum of all dices equal to categoryNumber
     */
    public int findSingleNumberChoice(int categoryNumber) {
        return throwResult.stream().filter(s -> s == categoryNumber).mapToInt(Integer::intValue).sum();
    }

    /**
     * @return sorted list of duplicated dices
     */
    public List<Integer> findPairsDices() {
        Set<Integer> result = findDuplicatedDices(throwResult);
        List<Integer> sortedList = new ArrayList<>(result);
        sortedList.sort(Collections.reverseOrder());
        return sortedList;
    }

    /**
     * @param list : the list of all dices
     * @param <T> : specified type of object
     * @return list of duplicated dices
     */
    public static <T> Set<T> findDuplicatedDices(List<T> list) {
        Set<T> items = new HashSet<>();
        return list.stream()
                .filter(n -> !items.add(n))
                .collect(Collectors.toSet());
    }

    /**
     * @param repetitionNb : the frequence of dice can be repeated
     * @return sorted List of duplicated dices
     */
    public List<Integer> findThreeofKindDices(int repetitionNb) {
        Set<Integer> result = findListDicesByFrequency(throwResult, repetitionNb);
        List<Integer> sortedList = new ArrayList<>(result);
        sortedList.sort(Collections.reverseOrder());
        return sortedList;
    }

    /**
     * @param list : the list of all dices
     * @param repetitionNb : the frequence if dice can be repeated
     * @param <T> : specified type of object
     * @return list of repeated dices
     */
    public static <T> Set<T> findListDicesByFrequency(List<T> list, int repetitionNb) {
        return list.stream()
                .filter(entry -> Collections.frequency(list, entry) > repetitionNb)
                .collect(Collectors.toSet());
    }

    /**
     * @param list : the list of all dices
     * @param <T> : specified type of object
     * @return true if the list contain a fullhouse
     */
    public static <T> boolean isFullHouse(List<T> list) {
        List<T> uniq = new ArrayList<T>(new TreeSet<T>(list));
        boolean result = false;
        if(uniq.size() == 2) {
            result =
                    Collections.frequency(list, uniq.get(0)) >= 2
                            && (Collections.frequency(list, uniq.get(1)) >= 2);
        }
        return result;
    }

    /**
     * @return the sum of all dices if is fullHouse and 0 if not
     */
    public int findFullHouseDices() {
         return isFullHouse(throwResult) ? sumDices() : 0;
    }

    /**
     * @return true if the sorted list of dices is small straight
     */
    public boolean isSmallStraight(){
        return throwResult.stream().sorted().collect(Collectors.toList()).equals(SMALL_STRAIGHT);
    }

    /**
     * @return true if the sorted list of dices is large straight
     */
    public boolean isLargeStraight(){
        return throwResult.stream().sorted().collect(Collectors.toList()).equals(LARGE_STRAIGHT);
    }


}
