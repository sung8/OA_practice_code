import java.util.ArrayList;
import java.util.List;

/**
 * Max Continuous Series of 1s
 * 
 * You are given with an array of 1s and 0s.
 * And you are given with an integer m, which
 * signifies number of flips allowed.
 * 
 * Find the position of zeros, which when flipped will
 * produce the maximum continuous series of 1s.
 * 
 * For this problem, return the indices of
 * maximum continuous series of 1s in order.
 * 
 * Example:
 * Input: [1, 1, 0, 1, 1, 0, 0, 1, 1, 1]
 * M = 1
 * Output: [0, 1, 2, 3, 4]
 * 
 * If there are multiple possible solutions,
 * return the sequence which has the minimum start index.
 */

/*
 * More of a sliding window problem than a two pointer problem
 */
public class MaxSeriesofOnes {
    public static List<Integer> findMaxSeriesIndices(int[] nums, int m) {
        List<Integer> res = new ArrayList<>();
        int flips = 0;
        int i = 0; // start
        int j = 0; // end
        int ans_j = 0;
        int ans_i = 0;
        while (j < nums.length) {
            // window expansion
            while (j < nums.length && flips <= m) {
                if (nums[j] == 0)
                    flips++;
                if (flips <= m && j - i > ans_j - ans_i) {
                    ans_i = i;
                    ans_j = j;
                }
                j++;
            }
            // window contraction
            while (i < j && flips > m) {
                if (nums[i] == 0)
                    flips--;
                i++;
            }
        }
        for (int k = ans_i; k <= ans_j; k++) {
            res.add(k);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 1, 0, 1, 1, 0, 0, 1, 1, 1 };
        int[] nums2 = new int[] { 1, 1, 0, 0, 1, 1, 0, 1, 1, 1 };
        int M = 1; // number of flips
        List<Integer> ans = findMaxSeriesIndices(nums2, M);
        System.out.println(ans);
    }
}
