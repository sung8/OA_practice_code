/**
 * Neetcode Sliding Window List
 * Longest Repeating Character Replacement
 * Leetcode Medium
 */

public class LongestRepeatCharWithKReplace {
    private static int longestSubstringAfterReplacements(char[] s, int replacementsAllowed) {
        final int N = s.length;
        int answer = 0;
        int distinctOccurrences = 0;
        int[] count = new int[26];

        for (int l = 0, r = 0; r < N; r++) {
            // Process incoming character and "build" the window around the most frequent
            // one
            int incomingCharIdx = s[r] - 'A';
            count[incomingCharIdx]++;
            distinctOccurrences = Math.max(distinctOccurrences, count[incomingCharIdx]);

            int currWindowLength = r - l + 1;
            if (currWindowLength - distinctOccurrences > replacementsAllowed) {
                // Invalid window, so try the same length ending at `r+1`
                count[s[l] - 'A']--;
                l++;
            } else {
                // Valid window, this is the longest we've seen so far
                answer = currWindowLength;
            }
        }

        return answer;
    }

    public static int characterReplacement(String s, int k) {
        return longestSubstringAfterReplacements(s.toCharArray(), k);
    }

    public static void main(String[] args) {
        String str1 = "AABABBA";
        String str2 = "AABAAC";
        System.out.println(characterReplacement(str1, 0));
        System.out.println(characterReplacement(str1, 1));
        System.out.println(characterReplacement(str1, 2));
        //
        System.out.println(characterReplacement(str2, 1));
        System.out.println(characterReplacement(str2, 2));
    }
}
