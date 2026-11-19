/*
 * Group anagrams: strings that are rearrangements of each other go in the same bucket.
 *
 * Key idea: two strings are anagrams  <=>  their sorted characters are identical.
 * So use the sorted-char string as a canonical key, and collect originals under it.
 *
 *   "eat","tea","ate"  ->  key "aet"  ->  ["eat","tea","ate"]
 *   "tan","nat"        ->  key "ant"  ->  ["tan","nat"]
 *
 * Steps:
 *   1. For each string, sort its chars to build the key; append the original to that key's list.
 *   2. The map's values are exactly the groups — return them.
 *
 * m = number of strings, n = max string length
 * Time:  O(m * n log n)   -- sort each of m strings, n log n per sort
 * Space: O(m * n)         -- store m strings (plus their keys), each length n
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}