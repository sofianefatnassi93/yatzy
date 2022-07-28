import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThrowDices {

    private final List<Integer> throwResult;

    public ThrowDices(int dice1, int dice2, int dice3, int dice4, int dice5) {
        throwResult = Arrays.asList(dice1, dice2, dice3, dice4, dice5);
    }

    public int sumDices() {
        return throwResult.stream().mapToInt(Integer::intValue).sum();
    }

    public boolean isYatzy() {
      return throwResult.stream().allMatch(s-> s.equals(throwResult.get(0)));
    }

    public int findSingleNumberChoice(int categoryNumber) {
        return throwResult.stream().filter(s -> s == categoryNumber).mapToInt(Integer::intValue).sum();
    }

    public List<Integer> findDicePairs() {
        Set<Integer> result = findDuplicateInList(throwResult);
        List<Integer> sortedList = new ArrayList<>(result);
        sortedList.sort(Collections.reverseOrder());
        return sortedList;
    }

    public List<Integer> findDiceThreeofKind(int count) {
        Set<Integer> result = findDuplicateInListFrequency(throwResult, count);
        List<Integer> sortedList = new ArrayList<>(result);
        sortedList.sort(Collections.reverseOrder());
        return sortedList;
    }

    public static <T> Set<T> findDuplicateInList(List<T> list) {
        Set<T> items = new HashSet<>();
        return list.stream()
                .filter(n -> !items.add(n))
                .collect(Collectors.toSet());
    }

    public static <T> Set<T> findDuplicateInListFrequency(List<T> list, int count) {
        return list.stream()
                .filter(entry -> Collections.frequency(list, entry) > count)
                .collect(Collectors.toSet());
    }




}