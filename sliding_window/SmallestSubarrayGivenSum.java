
public class SmallestSubarrayGivenSum {
    public static int findSmallestSubarray(int[] arr, int targetSum) {
        int minWindowSize = Integer.MAX_VALUE; // trying to minimize this
        int currentWindowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentWindowSum += arr[windowEnd];
            // shrink the left hand size to see if we can do better
            while (currentWindowSum >= targetSum) {
                // delta of how large our window is
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                // subtract far left pointer's value from window sum
                currentWindowSum -= arr[windowStart];
                // increment pointer for next iteration
                windowStart++;
            }
        }
        return minWindowSize;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 4, 2, 2, 7, 8, 1, 2, 8, 1, 0 };
        int targetSum = 8;
        System.out.println(findSmallestSubarray(input, targetSum));
    }

}
