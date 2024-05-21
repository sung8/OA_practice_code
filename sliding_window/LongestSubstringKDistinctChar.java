import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinctChar {

    // first attempt
    public static String findSubstring(String s, int k) {
        String res = "";
        String currString = "";
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), 1);
                currString += s.charAt(i);
            } else {
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
                currString += s.charAt(i);
            }

            if (hm.size() > k) {
                char currChar = currString.charAt(0);
                int j = 0;
                StringBuilder sb = new StringBuilder(currString);
                while (sb.charAt(j) == currChar && sb.length() > 0) {
                    sb.deleteCharAt(0);
                }
                hm.remove(currChar);
                currString = sb.toString();
            }

            if (currString.length() > res.length()) {
                res = currString;
            }
        }
        return res;
    }

    // fixed solution
    public static String findSubstring2(String s, int k) {
        String res = "";
        String currString = "";
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            currString += currentChar;
            hm.put(currentChar, hm.getOrDefault(currentChar, 0) + 1);

            while (hm.size() > k) {
                char charToRemove = currString.charAt(0);
                hm.put(charToRemove, hm.get(charToRemove) - 1);
                if (hm.get(charToRemove) == 0) {
                    hm.remove(charToRemove);
                }
                currString = currString.substring(1);
            }

            if (currString.length() > res.length()) {
                res = currString;
            }
        }
        return res;
    }

    // Answer key
    public static int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "AAAHHIBC";
        int k = 2;

        String s2 = "AABCAABBCBCCCA";
        System.out.println(findSubstring(s2, k)); // incorrect
        System.out.println(findSubstring2(s2, k)); // correct
        System.out.println(findLength(s2, k)); // given
    }

}
