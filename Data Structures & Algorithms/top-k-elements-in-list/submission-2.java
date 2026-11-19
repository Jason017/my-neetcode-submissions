/*
1,2,2,3,3,3
1. build the counter for the nums: key = number, value = its frequency
1: 1
2: 2
3: 3

2. create an arraylist of {freq, number} pairs, then sort it by frequency, highest first

freq num
3: 3
2: 2
1: 1

3. populate the result array with the first k numbers from the list, since it's sorted by frequency
when k = 2
returns [3,2]
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        List<int[]> freqs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            freqs.add(new int[] {entry.getValue(), entry.getKey()});
        }
        freqs.sort((a, b) -> b[0] - a[0]);

        for (int i = 0; i < k; i++) {
            res[i] = freqs.get(i)[1];
        }
        return res;
    }
}
