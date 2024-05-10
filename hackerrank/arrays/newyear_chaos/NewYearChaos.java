package newyear_chaos;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewYearChaos {
    public static void minimumBribes(int[] q) {
        int swaps = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] != i + 1) {
                if ((i - 1) >= 0 && q[i - 1] == i + 1) {
                    int temp = q[i - 1];
                    q[i - 1] = q[i];
                    q[i] = temp;
                    swaps++;
                } else if ((i - 2) >= 0 && q[i - 2] == i + 1) {
                    q[i - 2] = q[i - 1];
                    q[i - 1] = q[i];
                    q[i] = q[i - 2];
                    swaps += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swaps);
    }

    public static void minimumBribes(List<Integer> q) {
        int swaps = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            int current = q.get(i);
            if (current != (i + 1)) {
                if (i > 0 && q.get(i - 1) == (i + 1)) {
                    // swap with the previous element
                    int temp = q.get(i - 1);
                    q.set(i - 1, current);
                    q.set(i, temp);
                    swaps++;
                } else if (i > 1 && q.get(i - 2) == (i + 1)) {
                    // swap twice to bring briber forward
                    q.set(i - 2, q.get(i - 1));
                    q.set(i - 1, current);
                    q.set(i, q.get(i - 2));
                    swaps += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swaps);
    }

    public static void minimumBribes2(List<Integer> q) {
        // Write your code here
        HashMap<Integer, Integer> swapTracker = new HashMap<>();
        // key is the NUMBER VALUE, not the index
        // value is the SWAP COUNT
        int l = q.size();

        for (int k = 1; k <= l; k++) {
            swapTracker.put(k, 0);
        }

        int totalSwaps = 0;
        int i = 0;
        while (i < q.size()) {
            if (swapTracker.get(q.get(i)) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            int j = q.get(i) - 1;
            if (swapTracker.get(q.get(j)) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            if (q.get(i) != q.get(j)) {
                int temp = q.get(i);
                q.set(i, q.get(j));
                q.set(j, temp);
                totalSwaps++;
                swapTracker.put(q.get(i), swapTracker.get(q.get(i)) + 1);
                swapTracker.put(q.get(j), swapTracker.get(q.get(j)) + 1);
            } else {
                i++;
            }
        }
        System.out.println(totalSwaps);
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(List.of(1, 2, 5, 3, 4, 7, 8, 6));
        List<Integer> list2 = new ArrayList<>(List.of(2, 1, 5, 3, 4));
        List<Integer> list3 = new ArrayList<>(List.of(2, 5, 1, 3, 4));
        List<Integer> list4 = new ArrayList<>(List.of(5, 1, 2, 3, 7, 8, 6, 4));
        System.out.println(list3);
        // minimumBribes(list);
        minimumBribes(list3);
    }
}
