class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)
        res = 0

        for i in numSet:
            if i - 1 not in numSet:
                j = i + 1
                while j in numSet:
                    j += 1
                res = max(res, j - i)
        
        return res