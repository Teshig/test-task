package anagram;

import java.util.Arrays;

public class AnagramViaArrays {

  public static void main(String[] args) {
    System.out.println(isAnagram("axy", "xxay"));
    System.out.println(isAnagram("axy", "bay"));
    System.out.println(isAnagram("axy", "xay"));
    System.out.println(isAnagram("", ""));
    System.out.println(isAnagram(null, null));
  }

  /**
   * Time complexity is O(n log n), because Arrays.sort() uses quickSort, which have that complexity.
   */
  private static boolean isAnagram(String first, String second) {
    if (isNotValidParams(first, second)) {
      return false;
    }
    char[] firstCharacters = extractSortedChars(first);
    char[] secondCharacters = extractSortedChars(second);
    return Arrays.equals(firstCharacters, secondCharacters);
  }

  private static char[] extractSortedChars(String first) {
    char[] firstCharacters = first.toCharArray();
    Arrays.sort(firstCharacters);
    return firstCharacters;
  }

  private static boolean isNotValidParams(String first, String second) {
    if (first == null || second == null) {
      throw new IllegalArgumentException("Params shouldn't been null");
    }
    return first.length() != second.length();
  }
}
