/*
bucket sort
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        int[] res = new int[k];
        List<Integer>[] freq = new List[nums.length + 1];

        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            freq[entry.getValue()].add(entry.getKey()); // freq -> number
        }
        
        int index = 0;
        for (int i = nums.length; i > 0 && index < k ; i--) {
            for (int num : freq[i]) {
                res[index++] = num;
                if (k == index) {
                    return res;
                }
            }
        }
        return res;
    }
}
