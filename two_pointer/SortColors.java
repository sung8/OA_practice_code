/*
 * Sort by Colors 
 * InterviewBit
 * Problem 4: https://youtu.be/ijKmiFqjzi4?si=pxcJNHJCNJFWKk2Y 
 * 
 * Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.
 * Note: Using the library sort function is not allowed.
 * 
 * Constraints
 * 1 <= N <= 1000000
 * 0 <= A[i] <= 2
 * 
 * Input Format
 * First and only argument of input contains an integer array A.
 * Output Format
 * Return an integer array in asked order
 * 
 * EXAMPLE 1
 * Input 1
 * A = [0 1 2 0 1 2]
 * Output 1
 * [0 0 1 1 2 2]
 * 
 * EXAMPLE 2
 * Input 2 
 * A = [0]
 * Output 2
 * [0]
 *  li        r
 * [0 1 2 0 1 2]
 *  i l     r  
 * [0 1 2 0 1 2]
 *    l i   r
 * [0 1 2 0 1 2]
 * [0 1 1 0 2 2]
 *    l   ir
 * [0 1 1 0 2 2]
 * [0 0 1 1 2 2]
 *      l r i    (i>r, break)
 * [0 0 1 1 2 2]
 *  
 * [0 0 1 1 2 2]
 */
/*
// APPROACH // 
three pointers: one to handle the next zero position one to handle the next 2 position and one to iterate (zero, twos, i) respectively
zero handler should only ++ when we hit a zero at that index 
two handler should only -- when we hit a 2 at that index
if i == 0 do zero handler swap if i == 2 do two handler swap 
if our iterator is greater then the two handler then that means everything on the right must be 2's
*/

import java.util.*;

public class SortColors {
    /**
     * @param A : list of numbers representing colors
     * @return void. just modifies the args passed by reference.
     */
    public static void sortColors(List<Integer> A) {
        // int l = 0;
        // int r = A.size() - 1;

        // for (int i = 0; i < r; i++) {
        // while (A.get(r) == 2)
        // r--;
        // if (A.get(l) == 0)
        // l++;
        // if (i > l) {
        // if (A.get(i) == 2) {
        // A.set(i, A.get(r));
        // A.set(r, 2);
        // } else if (A.get(i) == 0) {
        // A.set(i, A.get(l));
        // A.set(l, 0);
        // }
        // }
        // System.out.println(A);
        // }

        int zero = 0;
        int one = 0;

        for (int i : A) {
            if (i == 0)
                zero++;
            if (i == 1)
                one++;
        }
        for (int i = 0; i < A.size(); i++) {
            if (zero > 0) {
                A.set(i, 0);
                zero--;
            }
            if (zero == 0 && one > 0) {
                A.set(i, 1);
                one--;
            }
            if (zero == 0 && one == 0)
                A.set(i, 2);
        }
    }

    public static void main(String[] args) {
        List<Integer> colors = new ArrayList<>(List.of(0, 1, 2, 0, 1, 2));
        System.out.println(colors);
        sortColors(colors);
        System.out.println(colors);

    }
}
