/**
 * Find the max sum subarray of a fixed size k
 * 
 * Example input:
 * [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
 */
public class MaxSumSubarray {

    public static int findMaxSumSubarray(int[] arr, int k) {
        int maxValue = Integer.MIN_VALUE;
        int currentRunningSum = 0;

        for (int i = 0; i < arr.length; i++) {
            // add current element to the running sum
            currentRunningSum += arr[i];
            // i is how far we are in the array
            // value of k is the size of window
            if (i >= k - 1) {
                // update maxValue if the current window sum is greater
                maxValue = Math.max(maxValue, currentRunningSum);
                // subtract the element that is left behind as the window slides
                currentRunningSum -= arr[i - (k - 1)]; // ???
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSumSubarray(new int[] { 4, 2, 1, 7, 8, 1, 2, 8, 1, 0 }, 3));
    }
}
