/*
 * Given T sorted array. 
 * A: {1, 4, 5, 8, 10, 100}
 * B: {6, 9, 15, 200}
 * C: {2, 3, 6, 6, 300}
 * 
 * Minimize the following expression:
 * |max(a,b,c) - min(a,b,c)|
 * where... "number a is a member of set (or array) A" and so on...
 * a ∈ A
 * b ∈ B
 * c ∈ C
 * "∈" = "member of"
 * 
 * EX ->
 * a=1
 * b=6
 * c=2 
 * |max(1,6,2) - min(1,6,2)|
 * = |6 - 1| = 5
 * 
 * a=5
 * b=6
 * c=6
 * |max(5,6,6) - min(5,6,6)|
 * = |6 - 5| = 1 (the correct answer for this set, absolute minimum)
 * 
 */

// STATUS: Got answer wrong. Come back and fix. 

public class MinimizeSetValueDiff {

    private static void ansCheck(int[] a, int[] b, int[] c) {
        int i = 0;
        int j = 0;
        int k = 0;
        int possible_ans = Integer.MAX_VALUE;
        while (i < a.length && j < b.length && k < c.length) {
            if (i == a.length - 1) {
                break;
            } else if (j == b.length - 1) {
                break;
            } else if (k == c.length - 1) {
                break;
            }
            int maximum = Integer.max(Integer.max(a[i], b[j]), c[k]);
            int minimum = Integer.min(Integer.min(a[i], b[j]), c[k]);

            // who will be incrementing
            if (minimum == a[i]) {
                i++;
            } else if (minimum == b[j]) {
                j++;
            } else {
                k++;
            }

            possible_ans = Integer.min(maximum - minimum, possible_ans);
            System.out.println("max " + maximum + " min " + minimum + " : " + possible_ans);

        }
        System.out.println(possible_ans);
    }

    private static int[] minimize(int[] A, int[] B, int[] C) {
        int[] res = new int[4]; // res[3] = minimized difference
        int i = 0;
        int j = 0;
        int k = 0;
        // System.out.println(currStateMin[0] + " " + currStateMin[1]);
        int currDiff = 0;
        int ans = 2147483647;

        // will not work if end of arr is the answer
        while (i < A.length - 1 && j < B.length - 1 && k < C.length - 1) {
            currDiff = Math.abs(Math.max(Math.max(A[i], B[j]), C[k]) - Math.min(Math.min(A[i], B[j]), C[k]));
            // currStateMin = getIndexOfMin(A, B, C, i, j, k);
            // System.out.println(currStateMin[0] + " " + currStateMin[1]);
            // System.out.println("i=" + i + ", j=" + j + ", k=" + k + ", val: " +
            // currDiff);

            ans = Math.min(ans, currDiff);

            System.out.println("i=" + i + ", j=" + j + ", k=" + k + ", val: " + currDiff + " ans: " + ans);
            // ++the index which is the min is the least
            int minVal = Math.min(Math.min(A[i], B[j]), C[k]);
            if (minVal == A[i]) {
                i++;
            } else if (minVal == B[j]) {
                j++;
            } else {
                k++;
            }
        }
        res[0] = A[i];
        res[1] = B[j];
        res[2] = C[k];
        res[3] = ans;
        return res;
    }

    private static int[] getIndexOfMin(int[] A, int[] B, int[] C, int i, int j, int k) {
        int currMinOfThree = min(A[i], B[j], C[k]);
        int[] ArrAndIndex = new int[2];
        // A = 1, B = 2, C = 3
        if (currMinOfThree == A[i]) {
            ArrAndIndex[0] = 1;
            ArrAndIndex[1] = i;
            // minIndex = i;
            // minArray = 'A';
        } else if (currMinOfThree == B[j]) {
            ArrAndIndex[0] = 2;
            ArrAndIndex[1] = j;
            // minIndex = j;
            // minArray = 'B';
        } else {
            ArrAndIndex[0] = 3;
            ArrAndIndex[1] = k;
            // minIndex = k;
            // minArray = 'C';
        }
        return ArrAndIndex;
    }

    private static int[] getIndexOfMax(int[] A, int[] B, int[] C, int i, int j, int k) {
        int currMaxOfThree = max(A[i], B[j], C[k]);
        int[] ArrAndIndex = new int[2];
        // A = 1, B = 2, C = 3
        if (currMaxOfThree == A[i]) {
            ArrAndIndex[0] = 1;
            ArrAndIndex[1] = i;
            // minIndex = i;
            // minArray = 'A';
        } else if (currMaxOfThree == B[j]) {
            ArrAndIndex[0] = 2;
            ArrAndIndex[1] = j;
            // minIndex = j;
            // minArray = 'B';
        } else {
            ArrAndIndex[0] = 3;
            ArrAndIndex[1] = k;
            // minIndex = k;
            // minArray = 'C';
        }
        return ArrAndIndex;
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private static int smallest(int x, int y, int z) {
        int c = 0;
        while (x != 0 && y != 0 && z != 0) {
            x--;
            y--;
            z--;
            c++;
        }
        return c;
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
        int[] A = { 1, 4, 5, 8, 10, 100 };
        int[] B = { 6, 9, 15, 200 };
        int[] C = { 2, 3, 6, 6, 300 };

        System.out.print("A: ");
        printArr(A);
        System.out.print("B: ");
        printArr(B);
        System.out.print("C: ");
        printArr(C);
        // System.out.println(findMinOfThree(1, 2, 2));
        // System.out.println("==== TEST MIN AND MAX FUNCTIONS ====");
        // System.out.println(min(1, 2, 4));
        // System.out.println(max(1, 2, 4));

        // System.out.println("==== TEST STATE FUNCTIONS ====");
        // System.out.println("1=A, 2=B, 3=B");
        // System.out.println("[1, 0] == A[0]");
        // System.out.println("[B, 2] == B[2]");
        // printArr(getIndexOfMin(A, B, C, 0, 0, 0));
        // printArr(getIndexOfMax(A, B, C, 0, 0, 0));

        System.out.println("==== LENA TEST MAIN MINIMIZE FUNCTION ====");
        int[] ans = minimize(A, B, C);
        printArr(ans);

        // System.out.println("==== ANSWER CHECK ====");
        // ansCheck(A, B, C);
    }
}
