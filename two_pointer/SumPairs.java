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
 * 
 * Source: https://youtu.be/ijKmiFqjzi4?si=z0ugDwjY4Ls0FnnI
 */
public class SumPairs {
    /**
     * Correct Soln: Function to count pairs in the array whose sum is equal to
     * target
     *
     * @param array  sorted array of numbers in ascending order
     * @param target the target sum
     * @return the total number of pairs
     */
    public static int pairSum(int[] array, int target) {
        int start = 0; // Initialize start pointer
        int end = array.length - 1; // Initialize end pointer
        int pairCount = 0; // Initialize pair count

        // Loop until start pointer is less than end pointer
        while (start < end) {
            // If sum of elements at start and end pointers is greater than target
            if ((array[start] + array[end]) > target) {
                end--; // Decrement end pointer
            }
            // If sum of elements at start and end pointers is less than target
            else if ((array[start] + array[end]) < target) {
                start++; // Increment start pointer
            }
            // If sum of elements at start and end pointers is equal to target
            else {
                // If elements at start and end pointers are different
                if (array[start] != array[end]) {
                    int count1 = 0; // Initialize count1 to count occurrences of leftElement
                    int count2 = 0; // Initialize count2 to count occurrences of rightElement
                    int left = array[start]; // Store element at start pointer
                    int right = array[end]; // Store element at end pointer

                    // Count occurrences of left element
                    while (array[start] == left) {
                        start++;
                        count1++;
                    }
                    // Count occurrences of right element
                    while (array[end] == right) {
                        end--;
                        count2++;
                    }

                    // Add count of pairs for different elements to pairCount
                    pairCount = pairCount + (count1 * count2);
                }
                // If elements at start and end pointers are same
                if (array[start] == array[end]) {
                    // Calculate count of pairs for same elements and return
                    pairCount = pairCount + numberOfPairsForSameNumber(end - start);
                    return pairCount;
                }
            }
        }

        return pairCount; // Return total pair count
    }

    // public static int pairSum2(int[] arr, int k) {
    // int left = 0;
    // int right = arr.length - 1;
    // int count = 0;
    // int newRight = right;
    // // [1, 4, 4, 5, 5, 5, 6, 6, 11]
    // while (left < newRight - 1) {
    // System.out.println("test:" + left + " newRight: " + newRight);
    // System.out.println("test:" + (left + newRight));
    // if (arr[left] + arr[newRight] == k) {
    // if (arr[left] == arr[right]) {
    // int n = right - left + 1;
    // count = count + (n * (n + 1) / 2);
    // return count;
    // } else {
    // right = newRight;
    // while (arr[left] + arr[right] == k) {
    // count++;
    // right--;
    // }
    // }
    // } else if (arr[left] + arr[right] > k) {
    // right--;
    // newRight = right;
    // }
    // if (arr[left] + arr[right] < k) {
    // left++;
    // }
    // }
    // return count;
    // }

    /**
     * Function to calculate number of pairs for same number using formula
     * 
     * @param n number of same number elements
     * @return the calculated number of pairs
     */
    public static int numberOfPairsForSameNumber(int n) {
        return (int) Math.floor(n * (n + 1) / 2);
    }

    /**
     * Finds the number of pairs that add up to sum k
     * 
     * @param nums sorted array of numbers in ascending order
     * @param k    the target sum
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
        int k = 10;
        System.out.println("\n" + findPairs(sortedNums, k));
        System.out.println(findPairs2(sortedNums, k));
        System.out.println(pairSum(sortedNums, k));
        // System.out.println(pairSum2(sortedNums, k));
    }
}
