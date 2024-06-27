package left_rotation;

import java.io.*;
import java.util.*;

public class LeftRotation {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY a
     * 2. INTEGER d
     */
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int n = a.size();
        List<Integer> b = new ArrayList<>(n);

        // Perform left rotation by copying elements from 'a' to 'b' in the rotated
        // order
        for (int i = d; i < n + d; i++) {
            int index = i % n; // Calculate the original index in 'a' using modulo
            b.add(a.get(index));
        }

        return b;
    }

    public static List<Integer> rotLeft2(List<Integer> a, int d) {
        int n = a.size();
        int i = 0;
        List<Integer> b = new ArrayList<>(n);
        int rotate_index = d;

        while (rotate_index < n) {
            b.set(i, a.get(rotate_index));
            i++;
            rotate_index++;
        }

        rotate_index = 0;
        while (rotate_index < d) {
            b.set(i, a.get(rotate_index));
            i++;
            rotate_index++;
        }
        return b;
    }

    public static List<Integer> rotLeft1(List<Integer> a, int d) {
        // Write your code here
        int i = 0;
        d = d % a.size();
        while (i < d) {
            // List<Integer> numbers = new ArrayList<>();
            // numbers.set(indexToReplace, newValue);

            int temp = a.get(0);
            for (int j = 0; j < a.size() - 1; j++) {
                // a[j] = a[j + 1];
                a.set(j, a.get(j + 1));
            }
            a.set(a.size() - 1, temp);

            // Right rotation
            // int temp = a.get(a.size() - 1);
            // for (int j = a.size() - 1; j > 0; j--) {
            // a.set(j, a.get(j - 1));
            // }
            // a.set(0, temp);

            i++;
        }
        return a;
    }

    private static List<List<Integer>> parseInputFile(String filePath) {
        List<List<Integer>> input = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read the first line to get n and d
            String firstLine = reader.readLine();
            if (firstLine != null) {
                String[] ndTokens = firstLine.trim().split("\\s+");
                int n = Integer.parseInt(ndTokens[0]);
                int d = Integer.parseInt(ndTokens[1]);

                // Read the second line to get the list a
                String secondLine = reader.readLine();
                if (secondLine != null) {
                    String[] aTokens = secondLine.trim().split("\\s+");
                    List<Integer> a = new ArrayList<>();
                    for (String token : aTokens) {
                        a.add(Integer.parseInt(token));
                    }

                    // Add n, d, and list a to the input
                    input.add(Arrays.asList(n, d));
                    input.add(a);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle file I/O exception
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Handle parsing exception
        }

        return input;
    }

    @SuppressWarnings("unused")
    private static void printInput(List<List<Integer>> parsedInput) {
        // Display the parsed input
        if (parsedInput.size() == 2) {
            List<Integer> nd = parsedInput.get(0);
            List<Integer> a = parsedInput.get(1);

            int n = nd.get(0);
            int d = nd.get(1);

            System.out.println("n = " + n);
            System.out.println("d = " + d);
            System.out.println("List a = " + a);
        } else {
            System.out.println("Invalid input format.");
        }
    }

    private static void printList(List<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1)
                System.out.print(", ");
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        List<List<Integer>> contents = parseInputFile("input00.txt");
        List<Integer> t = contents.get(0);
        List<Integer> arr = contents.get(1);
        // int n = 0;
        // while (n < arr.size()) {
        // System.out.print(arr.get(n) + ", ");
        // n++;
        // }
        printList(arr);
        System.out.println("");
        int d = t.get(1);
        System.out.println("d = " + d);

        arr.clear();
        arr.addAll(List.of(1, 2, 3, 4, 5, 6));
        printList(arr);
        d = 3;

        // printInput(contents);
        List<Integer> rotatedArr = rotLeft(arr, d);
        printList(rotatedArr);
    }
}
