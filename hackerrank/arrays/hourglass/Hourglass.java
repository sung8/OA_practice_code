import java.io.*;
import java.util.*;

class Hourglass {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int[] maxHourglass = new int[7];
        int maxSum = -Integer.MAX_VALUE;
        int currSum = 0;

        for (int i = 0; i < arr.size() - 2; i++) {
            // currSum = arr[i][i] + arr[i][i+1] + a[i][i+2] + arr[i+1][i+1] + arr[i+2][i] +
            // arr[i+2][i+1] + arr[i+2][i+2];
            for (int j = 0; j < arr.size() - 2; j++) {
                currSum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2) + arr.get(i + 1).get(j + 1)
                        + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
                if (currSum > maxSum) {
                    maxSum = currSum;
                    maxHourglass[0] = arr.get(i).get(j);
                    maxHourglass[1] = arr.get(i).get(j + 1);
                    maxHourglass[2] = arr.get(i).get(j + 2);
                    maxHourglass[3] = arr.get(i + 1).get(j + 1);
                    maxHourglass[4] = arr.get(i + 2).get(j);
                    maxHourglass[5] = arr.get(i + 2).get(j + 1);
                    maxHourglass[6] = arr.get(i + 2).get(j + 2);
                }
            }
        }
        // System.out.println("Hourglass: ");
        // for (int num : maxHourglass) {
        // System.out.print(num + " ");
        // }
        // System.out.println("\n");
        printHourglass(maxHourglass);
        return maxSum;

    }

    private static List<List<Integer>> parseInputFile(String filePath) {
        List<List<Integer>> grid = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by spaces to get individual integer tokens
                String[] tokens = line.trim().split("\\s+");

                List<Integer> row = new ArrayList<>();
                for (String token : tokens) {
                    // Convert each token to an integer and add to the row list
                    row.add(Integer.parseInt(token));
                }
                // Add the row to the grid
                grid.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return grid;
    }

    public static void print2d(List<List<Integer>> grid) {
        for (List<Integer> row : grid) {
            for (Integer value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void printHourglass(int[] hourglass) {
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            System.out.print(hourglass[i] + "  ");
        }
        System.out.println("");
        System.out.println("   " + hourglass[3] + "  ");
        for (int i = 4; i < hourglass.length; i++) {
            System.out.print(hourglass[i] + "  ");
        }
        System.out.println("");
    }

    public static void main(String[] args) throws IOException {
        String filePath = "input03.txt";
        List<List<Integer>> grid = parseInputFile(filePath);
        print2d(grid);

        int ans = hourglassSum(grid);
        System.out.println(ans);
    }
}
