import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * FrequencySort: You should sort elements in a list by decreasing frequency of elements. If two
 * elements have the same frequency, sort them by increasing value.
 */
public class FrequencySort {

  public static void main(String[] args) {
    System.out.println(frequencySort(Arrays.asList(4, 10, 3, 6, 4, 4, 8, 8, 6)));
  }

  public static List<Integer> frequencySort(List<Integer> arr) {
    Map<Integer, Integer> frequencyCollection = new HashMap<>();
    for (Integer number : arr) {
      frequencyCollection.put(number,
          frequencyCollection.getOrDefault(number, 0) + 1);
    }

    arr.sort(getFrequencyComparator(frequencyCollection));
    return arr;
  }

  private static Comparator<Integer> getFrequencyComparator(final Map<Integer, Integer> frequencyCollection) {
    return (o1, o2) -> {
      Integer firstElementFrequency = frequencyCollection.get(o1);
      Integer secondElementFrequency = frequencyCollection.get(o2);
      int frequency = secondElementFrequency.compareTo(firstElementFrequency);
      return frequency == 0 ? o1.compareTo(o2) : frequency;
    };
  }

}
