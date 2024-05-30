package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>(); 
        List<String> keyTracker = new ArrayList<>();
        String key = "";
        for (int i=0; i<strs.length;i++){
            char[] charArray = strs[i].toCharArray();
            //String sortedStr = new String(charArray);
            Arrays.sort(charArray);
            key = new String(charArray);
            if (!hm.containsKey(key)) {
                //hm.put(key, Arrays.asList(strs[i]));
                hm.put(key, new ArrayList<>(Arrays.asList(strs[i])));
                keyTracker.add(key);
            } else {
                List<String> temp = hm.get(key);
                temp.add(strs[i]); // add the new value to existing list
                hm.put(key, temp); // put the updated list back into the map
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String w : keyTracker) {
            List<String> temp = hm.get(w);
            res.add(temp);
        }
        return res;
    }
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res;
        res = groupAnagrams(arr);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }
}
