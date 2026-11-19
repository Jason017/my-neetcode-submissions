/*
For each index, we need the product of all elements before it and all elements after it. Instead of recomputing the product repeatedly, we can pre-compute prefix and suffix arrays

1 2 4 6

prefix - 1, 1 * 2, 1 * 2 * 4, 1 * 2 * 4 * 6
suffix - 2 * 4 * 6, 4 * 6, 6, 1

i, i * i-1, i * i-1 * i-2, ... , i * ... * i-n+1
i * ... * i-n+1, i * i-1 * i-2, i * i-1, ... ,i


4 10 8 3

product = i, i+1, i+2, i+3

1 3 5 0 0
returns 0 0 0 0 0
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int product = 1;
        int numZeros = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                numZeros++;
            } else {
                product *= nums[i];
            }
        }

        if (numZeros > 1) {
            return res;
        }

        for (int i = 0; i < n; i++) {
            if (numZeros > 0) {
                res[i] = nums[i] == 0 ? product : 0;
            } else {
                res[i] = product / nums[i];
            }
        }
        return res;
    }
}  
