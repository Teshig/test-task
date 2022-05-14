package anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramViaSet {

  public static void main(String[] args) {
    System.out.println(isAnagram("axy", "xxay")); //false
    System.out.println(isAnagram("axy", "bay"));  //false
    System.out.println(isAnagram("axy", "xay"));  //true
    System.out.println(isAnagram("", ""));        //true
    System.out.println(isAnagram(null, null));    //throw
  }

  /**
   * Time complexity is O(n).
   */
  private static boolean isAnagram(String first, String second) throws IllegalArgumentException {
    if (isNotValidParams(first, second)) {
      return false;
    }

    Map<Character, Integer> firstWordChars = new HashMap<>();
    Map<Character, Integer> secondWordChars = new HashMap<>();

    for (int i = 0; i < first.length() - 1; i++) {
      firstWordChars.merge(first.charAt(i), 0, (key, value) -> value++);
      firstWordChars.put(first.charAt(i),
          firstWordChars.getOrDefault(first.charAt(i), 0) + 1);
      secondWordChars.put(second.charAt(i),
          secondWordChars.getOrDefault(second.charAt(i), 0) + 1);
    }
    return firstWordChars.equals(secondWordChars);
  }

  private static boolean isNotValidParams(String first, String second) {
    if (first == null || second == null) {
      throw new IllegalArgumentException("Params shouldn't been null");
    }
    return first.length() != second.length();
  }
}
