/*
binary serach

1. use a left and right pointer for the first 2 elements that sum up to 0

-1,0,1,2,-1,-4
l           r

2. use binary search to find the complementary element

time: O(nlog(n))
space: O(1)


0,1,2,-1, target: 2
l.     r

while

*/

class Solution {
    // public List<List<Integer>> threeSum(int[] nums) {
    //     int len = nums.length;
    //     int l = 0, r = len - 1;
        
    //     while (l < r) {

    //     }
    // }

    // private int binarySearch(int[] nums, int l, int r, int target) {
    //     while (l <= r) {
    //         int m = l + (r - l) / 2;
    //         if (nums[m] == target) {
    //             return m;
    //         }
    //         if (nums[m] < target) {
    //             l = m + 1;
    //         } else {
    //             r = m - 1;
    //         }
    //     }
    //     return -1;
    // }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.get(nums[i]) - 1);
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) - 1);
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int target = -(nums[i] + nums[j]);
                if (count.getOrDefault(target, 0) > 0) {
                    res.add(Arrays.asList(nums[i], nums[j], target));
                }
            }

            for (int j = i + 1; j < nums.length; j++) {
                count.put(nums[j], count.get(nums[j]) + 1);
            }
        }
        return res;
    }
}
