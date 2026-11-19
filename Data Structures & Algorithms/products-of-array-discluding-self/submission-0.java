/*
prefix and suffix product problem

1 2 4 6

prefix - 1, 1 * 2, 1 * 2 * 4, 1 * 2 * 4 * 6
suffix - 2 * 4 * 6, 4 * 6, 6, 1

iterate thru 


*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            prefix[i] *= suffix[i];
        }

        return prefix;
    }
}  
