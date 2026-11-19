/*
2,20,4,10,3,4,5



*/

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1;
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            seen.add(num);
        }

        for (int num : seen) {
            if (seen.contains(num - 1)) {
                continue;
            }

            int length = 0;
            while (seen.contains(num + length)) {
                length++;
            }
            res = Math.max(res, length);
        }

        return res;
    }
}
