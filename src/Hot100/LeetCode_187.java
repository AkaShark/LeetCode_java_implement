package Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String subString = s.substring(i, i + 10);
//            if (!map.containsKey(subString)) {
//                map.put(subString, 1);
//            } else {
//                map.put(subString, map.get(subString) + 1);
//            }
            map.put(subString, map.getOrDefault(subString, 0) + 1);

            if (map.get(subString) == 2) {
                res.add(subString);
            }
        }
        return res;
    }
}
