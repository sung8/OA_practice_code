package minimum_swaps2;

public class MinimumSwapsTwo {

    // answer
    public static int minimumSwaps(int[] arr) {
        int count = 0;
        int i = 0;
        while (i < arr.length) {
            int j = arr[i] - 1;
            if (arr[i] != arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                count++;
            } else {
                i++;
            }
            printArr(arr);
        }
        return count;
    }

    // binary swap
    public static int binarySwapCount(int[] nums) {
        return 0;
    }

    // problem does NOT use bubble sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    // Swap array[i-1] and array[i]
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                    printArr(array);
                }
            }
            n--; // Reduce the range of the array each iteration
        } while (swapped);
    }

    /**
     * Function prints the array
     * 
     * @param arr an array of numbers
     */
    private static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        int[] arr = { 7, 1, 3, 2, 4, 5, 6 };

        System.out.println("Array before sorting:");
        printArr(arr);
        System.out.println("Sorting ... ");
        // bubbleSort(arr);

        // System.out.println("\nArray after sorting:");
        // printArr(arr);
        System.out.println(minimumSwaps(arr));
    }
}
