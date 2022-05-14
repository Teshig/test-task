import java.util.stream.IntStream;

/**
 * Palindrome: Is a string which reads the same backward as forward, such as madam.
 */
public class Palindrome {

  public static void main(String[] args) {
    System.out.println(isPalindromeStreams("racecar"));
    System.out.println(isPalindromeStreams("raccar"));
    System.out.println(isPalindromeStreams("racecaq"));
    System.out.println(isPalindromeStreams("raccaq"));
  }

  /**
   * Time complexity is O(n).
   */
  private static boolean isPalindrome(String text) {
    String pureString = text.replaceAll("\\s+", "").toLowerCase();
    int forward = 0;
    int backward = pureString.length() - 1;

    while (backward > forward) {
      if (pureString.charAt(forward++) != pureString.charAt(backward--)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Time complexity is O(n).
   */
  private static boolean isPalindromeReverse(String text) {
    String pureString = text.replaceAll("\\s+", "").toLowerCase();
    StringBuilder stringBuilder = new StringBuilder(pureString);
    return pureString.equals(stringBuilder.reverse().toString());
  }

  /**
   * Time complexity is O(n).
   */
  private static boolean isPalindromeStreams(String text) {
    String pureString = text.replaceAll("\\s+", "").toLowerCase();
    return IntStream.range(0, pureString.length() / 2)
        .noneMatch(i -> pureString.charAt(i) != pureString.charAt(pureString.length() - 1 -i));
  }
}
