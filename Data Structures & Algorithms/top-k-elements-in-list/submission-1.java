/*
1,2,2,3,3,3

1. build the counter for the nums: key = number, value = its frequency
1: 1
2: 2
3: 3

2. create an arraylist of int[] with freq and number

freq num
1: 1
2: 2
3: 3

3. walk the array backward (higher index = more frequent number), and fill res until it has k numbers
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
