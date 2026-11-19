class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        res = 0

        for i in range(len(height)):
            curr = height[i]
            while stack and height[stack[-1]] < curr:
                prev = stack.pop()
                if not stack:
                    continue
                h = min(height[stack[-1]], curr)
                res += (h - height[prev]) * (i - stack[-1] - 1)
            stack.append(i)
        
        return res