/*
m strings, each has n chars

m * logn

aht - hat 
act - act, cat

*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                map.put(sortedStr, new ArrayList<>());
                map.get(sortedStr).add(str);
            }
        }

        for (String key : map.keySet()) {
            res.add(new ArrayList<>());
            for (String str : map.get(key)) {
                res.get(res.size() - 1).add(str);
            }
        }
        return res;
    }
}
