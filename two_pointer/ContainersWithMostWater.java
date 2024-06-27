public class ContainersWithMostWater {
    //// HELPER METHODS ////
    /**
     * Function to scale a value proportionally
     * 
     * @param value
     * @param max
     * @param maxLength
     * @return
     */
    private static int scale(int value, int max, int maxLength) {
        return (int) (((double) value / max) * maxLength);
    }

    /**
     * Function to visualize the bars along the x-axis (horizontal)
     * 
     * @param nums array of numbers representing length of bars in a graph
     */
    @SuppressWarnings("unused")
    private static void printHori(int[] nums) {
        System.out.println("Bar Graph:");
        // Find the maximum value in nums array to determine scaling
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        // Print bars for each element in nums
        for (int i = 0; i < nums.length; i++) {
            StringBuilder bar = new StringBuilder();
            // Calculate length of the bar based on scaling to fit console
            int scaledLength = scale(nums[i], maxVal, 20); // Adjust 20 for desired width
            for (int j = 0; j < scaledLength; j++) {
                bar.append("*");
            }
            System.out.println("Index " + i + ": " + bar.toString());
        }
    }

    /**
     * Function to visualize the bars along the y-axis (vertical)
     * 
     * @param nums array of numbers representing length of bars in a graph
     */
    private static void printVert(int[] nums) {
        System.out.println("Vertical Bar Graph:");
        // Find the maximum value in nums array to determine scaling
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        // Print bars vertically
        for (int row = maxVal; row > 0; row--) {
            StringBuilder line = new StringBuilder();
            for (int num : nums) {
                if (num >= row) {
                    line.append("* ");
                } else {
                    line.append("  ");
                }
            }
            System.out.println(line.toString());
        }
        // Print x-axis labels
        for (int i = 0; i < nums.length; i++) {
            System.out.print("--");
        }
        System.out.println();
        // Print indices below x-axis
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    //// END OF HELPER METHODS ////

    //////
    // Container with the Most Water
    // Problem 3: https://youtu.be/ijKmiFqjzi4?si=rxkd7VkX-Bd2G3Ma
    //////
    ////////////////////////
    // LEET CODE SUBMISSION
    ////////////////////////
    public static int getArea(int i1, int h1, int i2, int h2) {
        // int x = Math.abs(i2-i1)
        if (h1 >= h2) {
            return h2 * (Math.abs(i2 - i1));
        } else {
            return h1 * (Math.abs(i2 - i1));
        }
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int currArea = getArea(i, height[i], j, height[j]);
            if (currArea > max) {
                max = currArea;
            }
            if (height[j] >= height[i]) {
                i++;
            } else {
                j--;
            }

        }
        return max;
    }
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////

    /* PREVIOUS ATTEMPTS */
    /**
     * Closest answer
     * 
     * @param h an array of height of bars of a bar graph
     * @return an answer set of max area and max area info
     */
    public static int[] findMaxArea(int[] bars) {
        int maxArea = 0;
        int[] ans = new int[5];
        // ans[0] = index 1
        // ans[1] = index 2
        // ans[2] = area
        // ans[3] = x
        // ans[4] = y
        int minLeft = 0;
        for (int k = 0; k < bars.length - 1; k++) {
            if (bars[k] > bars[minLeft]) {
                minLeft = k;
            }
        }

        for (int i = minLeft; i < bars.length; i++) {
            // int start = i;
            int end = bars.length - 1;

            while (i < end) {
                // if h[j] >= h[i]
                if (bars[end] >= bars[i]) {
                    break;
                } else {
                    end--;
                }
            }

            if (bars[minLeft] * bars[end] > maxArea) {
                int x = Math.abs(end - minLeft);
                int diff = Math.abs(bars[end] - bars[minLeft]);
                int y = 0;
                if (bars[minLeft] <= bars[end]) {
                    y = bars[end] - diff;
                } else {
                    y = bars[minLeft] - diff;
                }
                maxArea = x * y;
                ans[0] = minLeft;
                ans[1] = end;
                ans[2] = maxArea;
                ans[3] = x;
                ans[4] = y;

            }
        }
        return ans;
    }

    // Worse than findMaxArea
    public static int[] findMaxArea2(int[] h) {
        int i = 0;
        int j = h.length - 1;
        int maxArea = 0;
        int[] ans = new int[5];
        // ans[0] = index 1
        // ans[1] = index 2
        // ans[2] = area
        // ans[3] = x
        // ans[4] = y

        while (i < j) {
            if ((i + 1) > (h.length - 1)) {
                break;
            }

            if (h[i] <= h[j] && h[i] > h[i + 1]) {
                int x = Math.abs(j - i);
                int ydiff = Math.abs(h[j] - h[i]);
                int y = h[j] - ydiff;

                if (x * y > maxArea) {
                    maxArea = x * y;
                    ans[0] = i;
                    ans[1] = j;
                    ans[2] = maxArea;
                    ans[3] = x;
                    ans[4] = y;
                }
                j--;
            } else if (h[i] < h[i + 1]) {
                i++;
                // j--;
            } else {
                j--;
            }
        }
        return ans;
    }

    // This one is worse than findMaxArea2
    public static int[] findMaxArea3(int[] h) {
        int i = 0;
        int j = h.length - 1;
        int maxArea = 0;
        int[] ans = new int[5];
        // ans[0] = index 1
        // ans[1] = index 2
        // ans[2] = area
        // ans[3] = x
        // ans[4] = y

        while (i < j) {
            if ((i + 1) > (h.length - 1)) {
                break;
            }
            if (h[i + 1] >= h[i]) {
                i++;
            }
            if (h[i] >= h[j]) {
                int x = Math.abs(j - i);
                // int ydiff = Math.abs(h[j] - h[i]);
                int y = h[j];
                System.out.println(h[j]);
                // System.out.println(ydiff);

                if (x * y > maxArea) {
                    maxArea = x * y;
                    ans[0] = i;
                    ans[1] = j;
                    ans[2] = maxArea;
                    ans[3] = x;
                    ans[4] = y;
                }
                return ans;
            }
            j--;
        }
        return ans;
    }

    private static int bruteForce(int[] h) {
        int maxArea = 0;
        for (int i = 0; i < h.length; i++) {
            for (int j = h.length - 1; j > 0; j--) {
                int area = (j - i) * Math.min(h[i], h[j]);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int[] arr2 = { 1, 2, 6, 8, 5, 4, 8, 3, 7 };
        // Print bar graphs horizontally
        // printHori(arr);
        // Print bar graphs vertically
        printVert(arr);
        int[] res = findMaxArea(arr);
        System.out.println("===VERSION 1===");
        System.out.println("Results \nindex1: " + res[0]
                + "\nindex2: " + res[1]
                + "\nmax area: " + res[2]
                + "\nx: " + res[3]
                + "\ny: " + res[4]);

        // int[] minLeft = findMaxArea2(arr);
        // System.out.println(minLeft[0]);

        int[] test = findMaxArea2(arr2);
        System.out.println("===VERSION 2===");
        System.out.println("Results \nindex1: " + test[0] + "\nindex2: " + test[1] + "\nmax area: " + test[2] + "\nx: "
                + test[3] + "\ny: " + test[4]);

        ////////////////////////
        System.out.println("Leetcode");
        System.out.println(maxArea(arr)); // expected = 49
        System.out.println(maxArea(arr2)); // expected = 36

        System.out.println("Brute Force (check answers)");
        System.out.println(bruteForce(arr));
        System.out.println(bruteForce(arr2));
    }

}
