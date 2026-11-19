/*
1,2,2,3,3,3

1. build the counter for the nums, with key value pairs of number and its frequency
1: 1
2: 2
3: 3

2. gather all freq and their numbers and store in an array of arraylists

freq num
2:5
3:3,4

3. 

*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqArr = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (freqArr[entry.getValue()] == null) {
                freqArr[entry.getValue()] = new ArrayList<>();
            }
            freqArr[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        for (int i = nums.length; i >= 1; i--) {
            if (freqArr[i] != null) {
                for (int num : freqArr[i]) {
                    res[index] = num;
                    index++;
                    if (index == k) return res;
                }
            }
        }

        return res;
    }
}
