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

    public static int calculate(int[] arr, int k) {
        int maxValue = Integer.MIN_VALUE;
        int currentRunningSum = 0;

        // sum of first k
        for (int i = 0; i < k; i++) {
            currentRunningSum += arr[i];
        }

        // start from the (k+1)th element and slide the window
        for (int i = k; i < arr.length; i++) {
            // add current element
            // subtract the far left element out of bounds of window
            currentRunningSum += arr[i] - arr[i - k];
            maxValue = Math.max(maxValue, currentRunningSum);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSumSubarray(new int[] { 4, 2, 1, 7, 8, 1, 2, 8, 1, 0 }, 3));
        System.out.println(calculate(new int[] { 4, 2, 1, 7, 8, 1, 2, 8, 1, 0 }, 3));
    }
}
