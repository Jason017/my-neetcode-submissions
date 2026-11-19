/*
For each index, we need the product of all elements before it and all elements after it. Instead of recomputing the product repeatedly, we can pre-compute prefix and suffix arrays

1 2 4 6

prefix - 1, 1 * 2, 1 * 2 * 4, 1 * 2 * 4 * 6
suffix - 2 * 4 * 6, 4 * 6, 6, 1

i, i * i-1, i * i-1 * i-2, ... , i * ... * i-n+1
i * ... * i-n+1, i * i-1 * i-2, i * i-1, ... ,i

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }
}  
