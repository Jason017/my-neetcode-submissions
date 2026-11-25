/*

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = nums.length - 2; j > i; j--) {
                for (int k = i + 1; k < j; k++) {
                    if ((i == j - 1 && nums[i] == nums[j]) || (j == k - 1 && nums[j] == nums[k])) {
                        continue;
                    }
                }
            }
        }
    }
}
