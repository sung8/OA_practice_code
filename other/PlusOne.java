package other;

public class PlusOne {
    public static int[] plusOne3(int[] digits) {
        int n = digits.length;

        // Start from the rightmost digit
        for (int i = n - 1; i >= 0; i--) {
            // If the digit is less than 9, simply increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // Otherwise, set the digit to 0 and continue propagating the carry
            digits[i] = 0;
        }

        // If we are here, it means all digits were 9
        // Create a new array with one more digit and set the first digit to 1
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static int[] plusOne2(int[] digits) {
        int last = digits[digits.length - 1] + 1;
        if (last > 9) {
            int[] newDigits = new int[digits.length + 1];
            int i = digits.length - 1;
            while (i >= 0) {
                if (digits[i] < 9) {
                    newDigits[i] = digits[i] + 1;
                    break;
                }
                if (digits[i] == 9) {
                    newDigits[i] = 0;
                    i--;
                }
            }
            // If the loop exited before i becomes less than 0, it means all digits were 9.
            // So, we set the first digit to 1 and return the new array.
            if (i < 0) {
                newDigits[0] = 1;
                return newDigits;
            }
            // Copy the remaining digits as they are
            while (i >= 0) {
                newDigits[i] = digits[i];
                i--;
            }
            return newDigits;
        } else {
            digits[digits.length - 1] = last;
        }
        return digits;
    }

    public static int[] plusOne(int[] digits) {
        int last = digits[digits.length - 1] + 1;
        if (last > 9) {
            int[] newDigits = new int[digits.length + 1];
            // for (int i=digits.length-1; i>=0; i--) {}
            int i = digits.length - 1;
            while (i >= 0) {
                System.out.println(newDigits[i]);
                if (digits[i] < 9) {
                    newDigits[i] = digits[i] + 1;
                    break;
                }
                if (digits[i] == 9) {
                    newDigits[i] = 0;
                    newDigits[i-1] = digits[i-1] + 1;
                }
                i--;
            }
            return newDigits;
        } else {
            digits[digits.length - 1] = last;
        }
        return digits;
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
        int[] nums = {9, 8, 9, 9};
        int[] res = plusOne(nums);
        printArr(res);
        res = plusOne2(nums);
        printArr(res);
        res = plusOne3(nums);
        printArr(res);
    }
}
