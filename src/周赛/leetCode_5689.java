package 周赛;

import java.util.List;

public class leetCode_5689 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        if (items == null || items.size() == 0) return 0;
        int index = -1;
        switch (ruleKey) {
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            default:
                index = 2;
        }
        
        int res = 0;
        String value = null;
        for (List<String> item: items) {
            switch (index) {
                case 0:
                    value = item.get(0);
                case 1:
                    value = item.get(1);
                case 2:
                    value = item.get(2);

            }
            if (value.equals(ruleValue)) res++;
        }
        return res;

    }
}
