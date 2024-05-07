import java.util.Arrays;
import java.util.function.Function;

/**
 * Given a sorted array,
 * find the number of pairs
 * which have a sum = k.
 * 
 * EX -> A: [1, 4, 4, 5, 5, 5, 6, 6, 11]
 * 0 1 2 3 4 5 6 7 8
 * -> k = 11
 * 5 (index 3), 6 (index 6) -> count = 1
 * 5 (index 3), 6 (index 7) -> count = 2
 * 5 (index 4), 6 (index 6) -> count = 3
 * 5 (index 4), 6 (index 7) -> count = 4
 * 5 (index 5), 6 (index 6) -> count = 5
 * 5 (index 5), 6 (index 7) -> count = 6
 * Total pairs that sum up to 11 = 6
 */
public class SumPairs {
    public static int pairSum(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        int pairCount = 0;

        while (start < end) {
            if ((array[start] + array[end]) > target) {
                end--;
            } else if ((array[start] + array[end]) < target) {
                start++;
            } else {
                if (array[start] != array[end]) {
                    int count1 = 0;
                    int count2 = 0;
                    int left = array[start];
                    int right = array[end];
                    while (array[start] == left) {
                        start++;
                        count1++;
                    }
                    while (array[end] == right) {
                        end--;
                        count2++;
                    }
                    pairCount = pairCount + (count1 * count2);
                }
                if (array[start] == array[end]) {
                    pairCount = pairCount + numberOfPairsForSameNumber(end - start);
                    return pairCount;
                }
            }
        }

        return pairCount;
    }

    public static int numberOfPairsForSameNumber(int n) {
        return (int) Math.floor(n * (n + 1) / 2);
    }

    /**
     * Finds the number of pairs that add up to sum k
     * 
     * @param nums sorted array of numbers in ascending order
     * @return the total number of pairs
     */
    private static int findPairs2(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int pairCount = 0;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < k) {
                start++;
            } else if (sum > k) {
                end--;
            } else {
                int count1 = 1;
                int count2 = 1;
                int num1 = nums[start];
                int num2 = nums[end];
                start++;
                end--;

                while (start <= end && nums[start] == num1) {
                    count1++;
                    start++;
                }
                while (start <= end && nums[end] == num2) {
                    count2++;
                    end--;
                }
                pairCount += count1 * count2;

                if (num1 == num2) {
                    pairCount -= count1 * (count1 - 1) / 2;
                }
            }
        }
        return pairCount;
    }

    private static int findPairs(int[] sortedArray, int k) {
        int start = 0;
        int end = sortedArray.length - 1;
        int pairCount = 0;

        while (start < end) {
            if (sortedArray[start] + sortedArray[end] > k) {
                end--;
            } else if (sortedArray[start] + sortedArray[end] < k) {
                start++;
            } else {
                pairCount++;
                start++;
                end--;
            }
        }
        return pairCount;
    }

    private static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] sortedNums = { 1, 4, 4, 5, 5, 5, 6, 6, 11 };
        printArr(sortedNums);
        int k = 11;
        System.out.println("\n" + findPairs(sortedNums, k));
        System.out.println(findPairs2(sortedNums, k));
        System.out.println(pairSum(sortedNums, k));
    }
}
