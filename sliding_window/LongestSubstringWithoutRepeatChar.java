
/**
 * Neetcode Sliding Window List
 * Longest Substring Without Repeating Characters
 * Leetcode Medium
 */

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatChar {
    // correct 2
    public static int slideTest(String s) {
        int left = 0;
        String longest = "";
        HashSet<Character> hs = new HashSet<>();
        int w = 0;
        String currStr = "";
        for (int right=0; right<s.length();right++){
            //System.out.println(currStr);
            while (hs.contains(s.charAt(right))) {
                hs.remove(s.charAt(left));
                currStr=currStr.substring(1);
                left++;
                //System.out.println(" - " + currStr);
            }
            w = (right-left) + 1; // window size
            currStr = s.substring(left, right+1);
            if (currStr.length()>longest.length()) {
                longest=currStr;
                //System.out.println(" * " + longest);
            }
            hs.add(s.charAt(right));
            //System.out.println(" "+currStr);
        }
        return longest.length();
    }
    // correct
    public static int lengthOfLongestSubstring5(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashSet<Character> hs = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        String longest = "";
        String currStr = "";
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (hs.contains(c)) {
                hs.remove(s.charAt(left));
                currStr = currStr.substring(1);
                left++;
            }
            hs.add(c);
            currStr += c;
            if (currStr.length() > longest.length()) {
                longest = currStr;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            System.out.println(currStr);
            System.out.println(" * " + longest);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring4(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashSet<Character> hs = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (hs.contains(c)) {
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // for test case 1 "abcabcbb", StringIndexOutOfBoundsException
    public static int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        HashSet<Character> hs = new HashSet<>();
        int j = 0;
        String longest = "";
        String currStr = "";
        while (j < s.length()) {
            currStr += s.charAt(j);
            if (hs.add(s.charAt(j)) == false) {
                int i = 0;
                while (i < j && currStr.charAt(i) != s.charAt(j)) { // index out of bounds exception
                    hs.remove(currStr.charAt(i));
                    currStr = currStr.substring(1);
                    i++;
                }
                currStr = currStr.substring(1);
            } else {
                hs.add(s.charAt(j));
            }
            if (currStr.length() > longest.length()) {
                longest = currStr;
            }
            System.out.println(currStr);
            System.out.println(" * " + longest);
            j++;
        }
        return longest.length();
    }

    // 60 / 987 testcases passed
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        HashSet<Character> hs = new HashSet<>();
        int j = 1;
        String longest = "";
        String currStr = "";
        while (j < s.length()) {
            currStr += s.charAt(j);
            if (hs.add(s.charAt(j)) == false) {
                currStr = currStr.substring(1);
            } else {
                hs.add(s.charAt(j));
            }
            if (currStr.length() > longest.length()) {
                longest = currStr;
            }
            System.out.println(currStr);
            System.out.println(" * " + longest);
            j++;
        }
        return longest.length();
    }

    // 407 / 987 testcases passed
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        // character, index in string
        String longest = "";
        String currStr = "";

        for (int i = 0; i < s.length(); i++) {
            if (!hm.containsKey(s.charAt(i))) {
                currStr += s.charAt(i);
                System.out.println(" " + currStr);
                hm.put(s.charAt(i), currStr.length() - 1);
                if (currStr.length() > longest.length()) {
                    longest = currStr;
                }
            } else {
                currStr = "" + s.charAt(i);
                hm.clear();
                hm.put(s.charAt(i), 0);
                System.out.println("Hello " + currStr);
            }
        }
        return longest.length();
    }

    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        String str407 = "dvdf";
        // System.out.println(lengthOfLongestSubstring(str407));
        // System.out.println(lengthOfLongestSubstring2(str407));

        // next attempt
        // System.out.println(lengthOfLongestSubstring3(str3));
        // System.out.println(lengthOfLongestSubstring3(str407));
        // System.out.println(lengthOfLongestSubstring3(" "));
        // System.out.println(lengthOfLongestSubstring3(str1)); //
        // StringIndexOutOfBoundsException

        // attempt from solution
        // Test 1
        // System.out.println(lengthOfLongestSubstring4(str1));
        // System.out.println(lengthOfLongestSubstring5(str1));
        // Test 2
        // System.out.println(lengthOfLongestSubstring4(str3));
        // System.out.println(lengthOfLongestSubstring5(str3));
        // Test 407
        //System.out.println(lengthOfLongestSubstring4(str407));
        //System.out.println(lengthOfLongestSubstring5(str407));


        // slide test
        System.out.println(slideTest(str407));
    }
}
