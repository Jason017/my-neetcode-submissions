/*
-1 0 0 0 0 1
i.   k.  j.  

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                for (int k = i + 1; k < j; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(new ArrayList(List.of(nums[i], nums[k], nums[j])));
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }
}
