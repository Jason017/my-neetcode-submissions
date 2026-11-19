/*
m strings, each has n chars

time - m * n * logn
space - m

1. create a map. Populate the key sorted chars for each string in the given array, the values are a list of corresponding strings. The sorted char array is the canonical key.

e.g.
aht - hat 
act - act, cat
opst - stop , pots, tops

2. group all the values into an array for each key in the map, and wrap them into a bigger list as the final answer
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        for (List<String> val : map.values()) {
            res.add(val);
        }
        return res;
    }
}
