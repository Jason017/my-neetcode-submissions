/*
#1
-1,0,1,2,-1,-4

-4 -1 -1 0 1 2
i  l         r

#2
-1 -1 -1 0 1 1 1 1 
i  l             r
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] + nums[i] > 0) {
                    r--;
                } else if (nums[l] + nums[r] + nums[i] < 0) {
                    l++;
                } else {
                    res.add(new ArrayList<>(List.of(nums[i], nums[l], nums[r])));
                    r--;
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                }
            }
        }

        return res;
    }
}
