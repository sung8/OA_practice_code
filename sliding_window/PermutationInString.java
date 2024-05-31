import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Neetcode Sliding Window
 * 
 */

public class PermutationInString {
    // david's solution
    public static boolean checkInclusion2(String s1, String s2) {
        List<Character> list = s1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> clist = new ArrayList<>(list);
        for (char c : s2.toCharArray()) {
            if (clist.contains(c)) {
                int index = clist.indexOf(c);
                clist.remove(index);
            } else {
                clist.clear();
                clist.addAll(list);
            }
            if (clist.isEmpty())
                return true;
        }
        return false;
    }

    // my solution
    public static boolean checkInclusion(String s1, String s2) {
        int[] counts_1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            // a = 97, b = 98, ..., z = 122
            int ascii_dec = s1.charAt(i) - 97;
            counts_1[ascii_dec] += 1;
        }
        int w_size = s1.length();

        int left = 0;
        int right = 0;
        for (int j = s2.length() - w_size; j >= 0; j--) {
            int[] counts_2 = new int[26];
            left = s2.length() - j - w_size;
            right = s2.length() - j - 1;
            int k = left;
            while (k <= right) {
                int ascii_dec = s2.charAt(k) - 97;
                counts_2[ascii_dec] += 1;
                k++;
            }
            if (checkEquality(counts_1, counts_2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkEquality(int[] array1, int[] array2) {
        // if different lengths, not equal
        if (array1.length != array2.length) {
            return false;
        }
        // compare elements
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
        s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
        // ----------------------------------
        // char var = 'a'; // ascii value 97
        // System.out.println((int)var);

        char[] aa = s2.toCharArray();
        int w_size = s1.length(); // window size

        ///// TEST 1 /////
        // int j = aa.length-w_size;
        // int j = 0;
        // int left = s2.length() - j - w_size;
        // int right = s2.length() - j - 1;
        // System.out.println("l: " + left + " r: " + right);
        // for (char ch : aa) {
        // System.out.print(ch + " ");
        // }
        // System.out.println();
        // for (int i=0; i<s2.length();i++) {
        // System.out.print(i + " ");
        // }

        ///// TEST 2 /////
        int left = 0;
        int right = 0;
        System.out.println();
        for (int j = s2.length() - w_size; j >= 0; j--) {
            left = s2.length() - j - w_size;
            right = s2.length() - j - 1;
            System.out.println("l: " + left + "   r: " + right);
            for (char ch : aa) {
                System.out.print(ch + " ");
            }
            System.out.println();
            for (int i = 0; i < s2.length(); i++) {
                System.out.print(i + " ");
            }
            System.out.println("\n");
        }
    }
}
