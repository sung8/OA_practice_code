
import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
import java.util.List;

public class Test {
    public static List<Integer> mergeTwo(List<Integer> list1, List<Integer> list2) {
        for(int i : list1) {
            int index = list2.indexOf(i);
            if(index > -1)
                list2.add(index,i);
            int newi = i;
            while(list2.indexOf(++newi) == -1) {
                index = list2.indexOf(newi);
             }
            list2.add(index+1, i);
        }
        return list2;
    }

    public static List<Integer> mergeTwo2(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>();

        int n = list1.size() + list2.size();

        int p1 = 0;
        int p2 = 0;

        int i = 0;
        while (i < n-2) {
            if (list1.get(p1) <= list2.get(p2) || p2 > list2.size() - 1) {
                res.add(list1.get(p1));
                p1++;
            }
            if (list1.get(p1) > list2.get(p2) || p1 > list1.size() - 1) {
                res.add(list2.get(p2));
                p2++;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> arr1 = List.of(1, 1, 1, 9, 10);
        List<Integer> arr2 = List.of(1, 99, 100);
        List<Integer> a = mergeTwo(arr1, arr2);
        System.out.println(a);
    }

}
