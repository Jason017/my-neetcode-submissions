/*
1) Prefix & Suffix

For each index, we need the product of all elements before it and all elements after it. Instead of recomputing the product repeatedly, we can pre-compute prefix and suffix arrays

1 2 4 6

prefix - 1, 1 * 2, 1 * 2 * 4, 1 * 2 * 4 * 6
suffix - 2 * 4 * 6, 4 * 6, 6, 1

i, i * i-1, i * i-1 * i-2, ... , i * ... * i-n+1
i * ... * i-n+1, i * i-1 * i-2, i * i-1, ... ,i

4 10 8 3


2) Division (not allowed)
- If there are two or more zeros, then every product will include at least one zero → the entire res is all zeros.
- If there's only one zero. then only the position containing that zero will get the product of all non zeros numbers. all other positions become 0
- If there's no zeros, we can safely do: res[i] = product / nums[i]

product = i * i+1 * i+2 * i+3

1 3 5 0 0
returns 0 0 0 0 0
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
